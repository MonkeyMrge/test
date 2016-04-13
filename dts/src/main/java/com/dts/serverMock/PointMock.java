package com.dts.serverMock;

public class PointMock extends MockServer {

	public PointMock(String name) {
		super(name + " PointMock");
	}

	@Override
	public void doSth() throws Exception {
		System.out.println(Thread.currentThread().getName() + ": --->PointMock dosth");
	}

}
