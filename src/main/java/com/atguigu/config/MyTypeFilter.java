package com.atguigu.config;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

/**
 * ʹ��ע�ⷽ��ɨ������������Զ�����˹���
 * @author Administrator
 *
 */
public class MyTypeFilter implements TypeFilter{

	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

		//��ȡ��ǰ���ע����Ϣ
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		//��ȡ��ǰ����ɨ����������Ϣ
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		//��ȡ��ǰ����Դ�����·����
		Resource resource = metadataReader.getResource();

		String className = classMetadata.getClassName();
		System.out.println("---> " + className);
		
		if(className.contains("er")) {
			return true;
		}
		return false;

	}

}
