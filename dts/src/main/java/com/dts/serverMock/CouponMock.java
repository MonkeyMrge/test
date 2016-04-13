package com.dts.serverMock;

public class CouponMock extends MockServer {

	public CouponMock(String name) {
		super(name + " CouponMock");
	}

	@Override
	public void doSth() throws Exception {
		System.out.println(Thread.currentThread().getName() + ": --->CouponMock dosth");
	}

	@Override
	public void doRoll() throws Exception {
		System.out.println(Thread.currentThread().getName() + ": --->CouponMock doRoll");
		
	}

}
