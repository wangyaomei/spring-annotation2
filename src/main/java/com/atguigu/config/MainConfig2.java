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

//������==�����ļ�
@Conditional(WindowsCondition.class)
@Configuration  //����Spring����һ��������
public class MainConfig2 {

	//Ĭ���ǵ�ʵ����  @Scope:����������
	//@Scope("prototype")
	// 
	@Lazy
	@Bean("person")
	public Person person(){
		System.out.println("----------����Person------");
		return new Person("lisi", 20);
	}
	
	/**
	 * @Conditional({Condition}) �� ����һ�������������жϣ�����������������ע��bean
	 * 
	 * ���ϵͳ��windows����������ע��("bill")
	 * �����linuxϵͳ����������ע��("linus")
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
