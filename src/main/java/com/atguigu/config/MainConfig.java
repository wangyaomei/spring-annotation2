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

//������==�����ļ�
@Configuration  //����Spring����һ��������

//@ComponentScan  value:ָ��Ҫɨ��İ�
//excludeFilters = Filter[] ��ָ��ɨ���ʱ����ʲô�����ų���Щ���
//includeFilters = Filter[] ��ָ��ɨ���ʱ��ֻ��Ҫ������Щ���
//FilterType.ANNOTATION������ע��
//FilterType.ASSIGNABLE_TYPE�����ո��������ͣ�
//FilterType.ASPECTJ��ʹ��ASPECTJ���ʽ
//FilterType.REGEX��ʹ������ָ��
//FilterType.CUSTOM��ʹ���Զ������
//@ComponentScan(value="com.atguigu", excludeFilters = {
//		@Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})
//})
//@ComponentScan(value="com.atguigu", includeFilters = {
//		@Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})
//}, useDefaultFilters = false) // useDefaultFilters ����Ĭ�Ϲ���ʹincludeFilters��Ч�� Ĭ��Ϊtrue

//���Զ�����ComponentScan
@ComponentScans(
		value = {
				@ComponentScan(value="com.atguigu", includeFilters = {
//						@Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})
//						,@Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookDao.class})
						@Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
						
				}, useDefaultFilters = false) // useDefaultFilters ����Ĭ�Ϲ���ʹincludeFilters��Ч�� Ĭ��Ϊtrue
		}
		)
public class MainConfig {

	//��������ע��һ��Bean;����Ϊ����ֵ�����ͣ�idĬ�����÷�������Ϊid
	@Bean("person")
	public Person person01(){
		return new Person("lisi", 20);
	}

}
