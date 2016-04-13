package com.dts.tcc.completation;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;

public class CompletationImpl implements Completation {

	private ThreadLocal<HashMap<String, Object>> pointMap = new ThreadLocal<HashMap<String, Object>>();

	@Override
	public void savePoint(Object bean) {
		if (pointMap.get() == null) {
			pointMap.set(new HashMap<String, Object>());
		}
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
			PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor des : descriptors) {
				String fieldName = des.getName();
				Method getter = des.getReadMethod();
				Object fieldValue = getter.invoke(bean, new Object[] {});
				if (!fieldName.equalsIgnoreCase("class")) {
					pointMap.get().put(fieldName, fieldValue);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void restorePoint(Object bean) {
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
			PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor des : descriptors) {
				String fieldName = des.getName();
				if (pointMap.get().containsKey(fieldName)) {
					Method setter = des.getWriteMethod();
					setter.invoke(bean, new Object[] { pointMap.get().get(fieldName) });
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
