package com.moim.addr.controller;

import org.springframework.boot.test.mock.mockito.MockBean;

import com.moim.addr.service.sidosgg.SidoSggService;

/**
 * BaseControllerTest.java
 * 
 * @author cdssw
 * @since May 2, 2020
 * 
 * <pre>
 * since          author           description
 * ===========    =============    ===========================
 * May 2, 2020   cdssw            최초 생성
 * </pre>
 */
public abstract class BaseControllerTest {

	// service 기능을 테스트 하는것이 아님
	// controller 테스트시 필요한 service mock 정의
	@MockBean protected SidoSggService sidoSggService;
}
