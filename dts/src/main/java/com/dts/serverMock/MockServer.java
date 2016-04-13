package com.dts.serverMock;

import java.util.Random;

import com.dts.tcc.ParticipatorServer;
import com.dts.tcc.Status;

public abstract class MockServer extends ParticipatorServer {

	public MockServer(String name) {
		super(name);
	}

	public abstract void doSth() throws Exception;

	public void prepare() throws Exception {
		Thread.sleep(new Random().nextInt(500));
		if (new Random().nextInt(10) % 5 != 1) {
			prepareStatus = Status.Success;
			System.out.println(name + " is prepared!");
		} else {
			prepareStatus = Status.Abort;
			System.out.println(name + " is abort!");
		}
	}

	public void commit() throws Exception {
		Thread.sleep(new Random().nextInt(500));
		if (new Random().nextInt(10) % 5 != 1) {
			setCommitStatus(Status.Success);
			doSth();
			System.out.println(name + " is committed!");
		} else {
			setCommitStatus(Status.Abort);
			System.out.println(name + " is uncommitted!");
		}
	}

	public void rollBack() throws Exception {
		Thread.sleep(new Random().nextInt(500));
		if (new Random().nextInt(10) % 2 != 1) {
			setRollBackStatus(Status.Success);
			doRoll();
			System.out.println(name + " is rollBack Success!");
		} else {
			setRollBackStatus(Status.Abort);
			System.out.println(name + " is rollBack failure!");
		}
	}
	public abstract void doRoll() throws Exception;
}
