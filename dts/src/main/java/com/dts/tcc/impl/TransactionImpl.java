package com.dts.tcc.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.dts.Exception.RetryOutException;
import com.dts.config.ConfigTable;
import com.dts.tcc.Participator;
import com.dts.tcc.Status;
import com.dts.tcc.Transaction;

public class TransactionImpl implements Transaction {
	Logger logger = Logger.getLogger(TransactionImpl.class);

	List<Participator> taskList = new ArrayList<Participator>();

	@Override
	public void enListParticipator(Participator participator) throws Exception {
		taskList.add(participator);
	}

	@Override
	public void deListParticipator(Participator participator) throws Exception {
		if (taskList.isEmpty()) {
			logger.debug(taskList + ", taskList is Empty!");
			throw new IllegalArgumentException();
		} else if (!taskList.contains(participator)) {
			logger.debug(participator + "is not involved in tasklist: " + taskList);
			throw new IllegalArgumentException();
		}
		taskList.remove(participator);
	}

	@Override
	public void commit() throws Exception {
		if (taskList.isEmpty()) {
			logger.debug(taskList + ", taskList is Empty!");
			throw new IllegalArgumentException();
		}
		for (Participator participator : taskList) {
			participator.prepare();
			if (!participator.getPrepareStatus().equals(Status.Success)) {
				System.out.println(Thread.currentThread().getName() + " prepare failure!");
				for (int i = 0; i < ConfigTable.PREPARE_RETRY_TIME; i++) {
					System.out.println(Thread.currentThread().getName() + " " + (i + 1) + " prepare retry:");
					participator.prepare();
					if (participator.getPrepareStatus().equals(Status.Success))
						break;
					System.out.println(Thread.currentThread().getName() + " " + (i + 1) + " prepare failure");

				}
				if (!participator.getPrepareStatus().equals(Status.Success)) {
					logger.debug(participator + " prepare failure out of times");
					throw new RetryOutException();
				}
			}
		}
		for (Participator participator : taskList) {
			participator.commit();
			if (!participator.getCommitStatus().equals(Status.Success)) {
				System.out.println(Thread.currentThread().getName() + " commmit failure!");
				for (int i = 0; i < ConfigTable.COMMIT_RETRY_TIME; i++) {
					System.out.println(Thread.currentThread().getName() + " " + (i + 1) + " commit retry:");
					participator.commit();
					if (participator.getCommitStatus().equals(Status.Success))
						break;
					System.out.println(Thread.currentThread().getName() + " " + (i + 1) + " commit failure");
				}
				if (!participator.getCommitStatus().equals(Status.Success)) {
					logger.debug(participator + " commit failure out of times");
					throw new RetryOutException();
				}
			}
		}
	}

	@Override
	public void rollBack() throws Exception {
		if (taskList.isEmpty())
			throw new IllegalArgumentException();
		System.out.println(Thread.currentThread().getName() + " is rollBack!");

	}

}
