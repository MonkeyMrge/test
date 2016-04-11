package com.dts.test;

import com.dts.serverMock.CashMock;
import com.dts.serverMock.CouponMock;
import com.dts.serverMock.PointMock;
import com.dts.tcc.Transaction;
import com.dts.tcc.TransactionManager;
import com.dts.tcc.impl.TransactionManagerImpl;

public class Test {
	public static void main(String[] args) {

		for (int i = 0; i < 1; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					TransactionManager transactionManager = new TransactionManagerImpl();
					String name = Thread.currentThread().getName();
					transactionManager.begin();
					try {
						Transaction transaction = transactionManager.getTransaction();
						transaction.enListParticipator(new CashMock(name));
						transaction.enListParticipator(new CouponMock(name));
						transaction.enListParticipator(new PointMock(name));
						transaction.commit();
					} catch (Throwable cause) {
						transactionManager.rollBack();
					}
				}
			}).start();

		}
	}
}
