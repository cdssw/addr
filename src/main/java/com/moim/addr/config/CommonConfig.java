package com.moim.addr.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * CommonConfig.java
 * 
 * @author cdssw
 * @since 2020. 8. 31.
 * @description  
 * 
 * <pre>
 * since          author           description
 * ===========    =============    ===========================
 * 2020. 8. 31.    cdssw            최초 생성
 * </pre>
 */
@Configuration
public class CommonConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
