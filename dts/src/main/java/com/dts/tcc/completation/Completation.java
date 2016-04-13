package com.dts.tcc.completation;

public interface Completation {
	void savePoint(Object bean);

	void restorePoint(Object bean);
}
