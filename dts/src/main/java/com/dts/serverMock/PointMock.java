package com.dts.serverMock;

import com.dts.tcc.ParticipatorServer;

public class PointMock extends ParticipatorServer {

	public PointMock(String name) {
		super(name + " PointMock");
	}

	@Override
	public void doSth() throws Exception {
		System.out.println(Thread.currentThread().getName() + ": --->PointMock dosth");
	}

}
