package com.dts.tcc;

public interface Participator {

	void prepare() throws Exception;

	void commit() throws Exception;

	void rollBack() throws Exception;

	Status getPrepareStatus();

	Status getCommitStatus();

	void setPrepareStatus(Status status);

	void setCommitStatus(Status status);
}
