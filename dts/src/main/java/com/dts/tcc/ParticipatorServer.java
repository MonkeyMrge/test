package com.dts.tcc;

import java.util.Random;

public abstract class ParticipatorServer implements Participator {

	private String name;
	private Status prepareStatus = Status.Abort;
	private Status commitStatus = Status.Abort;

	public ParticipatorServer(String name) {
		this.name = name;
	}

	@Override
	public void prepare() throws Exception {
		Thread.sleep(new Random().nextInt(500));
		if (new Random().nextInt(10) % 10 != 1) {
			prepareStatus = Status.Success;
			System.out.println(name + " is prepared!");
		} else {
			prepareStatus = Status.Abort;
			System.out.println(name + " is abort!");
		}
	}

	@Override
	public void commit() throws Exception {
		Thread.sleep(new Random().nextInt(500));
		if (new Random().nextInt(10) % 10 != 1) {
			setCommitStatus(Status.Success);
			doSth();
			System.out.println(name + " is committed!");
		} else {
			setCommitStatus(Status.Abort);
			System.out.println(name + " is uncommitted!");
		}
	}

	@Override
	public void rollBack() throws Exception {
		Thread.sleep(new Random().nextInt(500));
		System.out.println(name + " is rollBacked!");
	}

	public abstract void doSth() throws Exception;

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

	@Override
	public String toString() {
		return "ParticipatorServer [name=" + name + "]";
	}

}
