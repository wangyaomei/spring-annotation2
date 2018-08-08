package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Conditional;

import com.atguigu.bean.Person;
import com.atguigu.condition.LinuxCondition;
import com.atguigu.condition.WindowsCondition;
import com.atguigu.dao.BookDao;

//配置类==配置文件
@Conditional(WindowsCondition.class)
@Configuration  //告诉Spring这是一个配置类
public class MainConfig2 {

	//默认是单实例的  @Scope:调整作用域
	//@Scope("prototype")
	// 
	@Lazy
	@Bean("person")
	public Person person(){
		System.out.println("----------创建Person------");
		return new Person("lisi", 20);
	}
	
	/**
	 * @Conditional({Condition}) ： 按照一定的条件进行判断，满足条件给容器中注册bean
	 * 
	 * 如果系统是windows，给容器中注册("bill")
	 * 如果是linux系统，给容器中注册("linus")
	 */
	@Conditional(WindowsCondition.class)
	@Bean("bill")
	public Person person01(){
		return new Person("Bill Gates",62);
	}
	
	@Conditional(LinuxCondition.class)
	@Bean("linus")
	public Person person02(){
		return new Person("linus", 48);
	}
}
