package com.dts.serverMock;

import com.dts.tcc.ParticipatorServer;

public class CashMock extends ParticipatorServer {

	public CashMock(String name) {
		super(name + " CashMock");
	}

	@Override
	public void doSth() throws Exception {
		System.out.println(Thread.currentThread().getName() + ": --->Cash Mock doSth");
	}

}
