package com.atguigu.test;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.atguigu.bean.Blue;
import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;
import com.atguigu.config.MainConfig2;

public class IOCTest {
	
	@SuppressWarnings("resource")
	@Test
	public void test03(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
		String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
		for(String str : beanNamesForType) {
			System.out.println(str);
		}
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String property = environment.getProperty("os.name");
		System.out.println(property);
	}
	
	@SuppressWarnings("resource")
	@Test
	public void test02(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : definitionNames) {
			System.out.println(name);
		}
		Object person1 = applicationContext.getBean("person");
		Object person2 = applicationContext.getBean("person");
		System.out.println(person1 == person2);
	}
	
	@SuppressWarnings("resource")
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : definitionNames) {
			System.out.println(name);
		}
	}
}
