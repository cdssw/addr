package com.moim.addr.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.moim.addr.service.sidosgg.SidoSggDto;

import lombok.extern.slf4j.Slf4j;

/**
 * MeetControllerTest.java
 * 
 * @author cdssw
 * @since Apr 18, 2020
 * @description  
 * 
 * <pre>
 * since          author           description
 * ===========    =============    ===========================
 * Apr 18, 2020   cdssw            최초 생성
 * </pre>
 */
@RunWith(SpringRunner.class)
@WebMvcTest // controller 관련 bean만 로딩
@Slf4j
public class SidoSggControllerTest extends BaseControllerTest {

	private MockMvc mvc;
	
	@Autowired
	private WebApplicationContext ctx;
	
	private SidoSggDto.SidoRes res1;
	private SidoSggDto.SggRes res2;
	
	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(ctx)
				.addFilters(new CharacterEncodingFilter("UTF-8", true)) // 한글깨짐 방지 처리
				.alwaysDo(print()) // 항상 결과 print
				.build();
		
		res1 = SidoSggDto.SidoRes.builder()
				.sido("서울특별시")
				.build();
		res2 = SidoSggDto.SggRes.builder()
				.sido("서울특별시")
				.sgg("강남구")
				.build();
	}
	
	@Test
	public void testGetSidoList() throws Exception {
		// given
		given(sidoSggService.getSido()).willReturn(Arrays.asList(res1));
		
		// when
		final MvcResult result = mvc.perform(get("/sido")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()) // 200 확인
				.andReturn();
		
		log.info(result.getResponse().getContentAsString());		
	}	
	
	@Test
	public void testGetSggList() throws Exception {
		// given
		given(sidoSggService.getSgg(any())).willReturn(Arrays.asList(res2));
		
		// when
		final MvcResult result = mvc.perform(get("/sgg")
				.contentType(MediaType.APPLICATION_JSON)
				.param("sido", "서울특별시"))
				.andExpect(status().isOk()) // 200 확인
				.andReturn();
		
		log.info(result.getResponse().getContentAsString());		
	}
}
