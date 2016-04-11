package com.dts.tcc;

public interface Transaction {

	void enListParticipator(Participator participator) throws Exception;

	void deListParticipator(Participator participator) throws Exception;

	void commit() throws Exception;

	void rollBack() throws Exception;
}
