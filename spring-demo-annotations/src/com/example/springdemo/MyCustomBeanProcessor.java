package com.example.springdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyCustomBeanProcessor implements BeanFactoryAware, BeanPostProcessor, DisposableBean{

	private BeanFactory beanFactory;
	
	private final List<Object> protoTypeBeans = new ArrayList<>();
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		
		System.out.println("The bean name is "+beanName);
		
		if(beanFactory.isPrototype(beanName)) {
			synchronized (protoTypeBeans) {
				protoTypeBeans.add(bean);
			}
		}
		return bean;
	}
	
	@Override
	public void destroy() throws Exception {
		synchronized (protoTypeBeans) {
			for(Object bean : protoTypeBeans) {
				if(bean instanceof DisposableBean) {
					DisposableBean diposable = (DisposableBean) bean;
					try {
						diposable.destroy();
					}catch (Exception e) {
                        e.printStackTrace();
                    }
				}
			}
			protoTypeBeans.clear();
		}
		
		
		
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
		
	}

}
