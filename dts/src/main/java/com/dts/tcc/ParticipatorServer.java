package com.dts.tcc;

public abstract class ParticipatorServer implements Participator {

	protected String name;
	protected Status prepareStatus = Status.Abort;
	protected Status commitStatus = Status.Abort;
	protected Status rollBackStatus = Status.Abort;

	public ParticipatorServer(String name) {
		this.name = name;
	}


	public Status getPrepareStatus() {
		return prepareStatus;
	}

	public void setPrepareStatus(Status status) {
		this.prepareStatus = status;
	}

	public Status getCommitStatus() {
		return commitStatus;
	}

	public void setCommitStatus(Status commitStatus) {
		this.commitStatus = commitStatus;
	}


	public Status getRollBackStatus() {
		return rollBackStatus;
	}

	public void setRollBackStatus(Status rollBackStatus) {
		this.rollBackStatus = rollBackStatus;
	}

	@Override
	public String toString() {
		return "ParticipatorServer [name=" + name + "]";
	}
}
