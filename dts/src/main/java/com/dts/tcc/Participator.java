package com.dts.tcc;

public interface Participator {

	void prepare() throws Exception;

	void commit() throws Exception;

	void rollBack() throws Exception;

	Status getPrepareStatus();

	Status getCommitStatus();

	Status getRollBackStatus();

	void setPrepareStatus(Status prepareStatus);

	void setCommitStatus(Status commitStatus);
	
	void setRollBackStatus(Status rollBackStatus);
}
