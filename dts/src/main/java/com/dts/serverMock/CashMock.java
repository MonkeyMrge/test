package com.dts.serverMock;

public class CashMock extends MockServer {

	public CashMock(String name) {
		super(name + " CashMock");
	}

	@Override
	public void doSth() throws Exception {
		System.out.println(Thread.currentThread().getName() + ": --->Cash Mock doSth");
	}

}
