package com.dts.serverMock;

import com.dts.tcc.ParticipatorServer;

public class CouponMock extends ParticipatorServer {

	public CouponMock(String name) {
		super(name + " CouponMock");
	}

	@Override
	public void doSth() throws Exception {
		System.out.println(Thread.currentThread().getName() + ": --->CouponMock dosth");
	}

}
