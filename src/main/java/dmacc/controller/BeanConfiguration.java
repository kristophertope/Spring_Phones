package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Phone;

@Configuration
public class BeanConfiguration {

	@Bean
	public Phone phone() {
		Phone bean = new Phone();
		bean.setManufacturer("Apple");
		bean.setModel("iPhone 12 Pro");
		bean.setCpuCores(6);
		bean.setFoldable(false);
		return bean;
	}
	
}
