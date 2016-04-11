package com.dts.tcc.impl;

import com.dts.tcc.Transaction;
import com.dts.tcc.TransactionManager;

public class TransactionManagerImpl implements TransactionManager {

	ThreadLocal<Transaction> transactionLocal = new ThreadLocal<Transaction>();

	// private static TransactionManagerImpl transactionManagerImpl;
	//
	// private TransactionManagerImpl() {
	// }
	//
	// public TransactionManager getInstance() {
	// if (transactionManagerImpl == null)
	// syncInit();
	// return transactionManagerImpl;
	// }
	//
	// private static void syncInit() {
	// if (transactionManagerImpl == null)
	// transactionManagerImpl = new TransactionManagerImpl();
	// }

	@Override
	public Transaction getTransaction() {
		return transactionLocal.get();
	}

	@Override
	public void begin() {
		transactionLocal.set(new TransactionImpl());
	}

	@Override
	public void commit() {
		try {
			transactionLocal.get().commit();
		} catch (Exception e) {
			rollBack();
		}
	}

	@Override
	public void rollBack() {
		try {
			transactionLocal.get().rollBack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
