package com.dts.tcc;

public interface TransactionManager {

	Transaction getTransaction();

	void begin();

	void commit();

	void rollBack();
}
