package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;

import com.atguigu.bean.Person;
import com.atguigu.dao.BookDao;

//配置类==配置文件
@Configuration  //告诉Spring这是一个配置类

//@ComponentScan  value:指定要扫描的包
//excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件
//includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件
//FilterType.ANNOTATION：按照注解
//FilterType.ASSIGNABLE_TYPE：按照给定的类型；
//FilterType.ASPECTJ：使用ASPECTJ表达式
//FilterType.REGEX：使用正则指定
//FilterType.CUSTOM：使用自定义规则
//@ComponentScan(value="com.atguigu", excludeFilters = {
//		@Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})
//})
//@ComponentScan(value="com.atguigu", includeFilters = {
//		@Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})
//}, useDefaultFilters = false) // useDefaultFilters 禁用默认规则，使includeFilters生效， 默认为true

//可以定义多个ComponentScan
@ComponentScans(
		value = {
				@ComponentScan(value="com.atguigu", includeFilters = {
//						@Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})
//						,@Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookDao.class})
						@Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
						
				}, useDefaultFilters = false) // useDefaultFilters 禁用默认规则，使includeFilters生效， 默认为true
		}
		)
public class MainConfig {

	//给容器中注册一个Bean;类型为返回值的类型，id默认是用方法名作为id
	@Bean("person")
	public Person person01(){
		return new Person("lisi", 20);
	}

}
