package com.moim.addr.service.sidosgg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.moim.addr.config.JpaAuditingConfig;
import com.moim.addr.entity.SidoSgg;
import com.moim.addr.repository.SidoSggRepository;

/**
 * SidoSggRepositoryTest.java
 * 
 * @author cdssw
 * @since Apr 8, 2020
 * @description  
 * 
 * <pre>
 * since          author           description
 * ===========    =============    ===========================
 * Apr 8, 2020    cdssw            최초 생성
 * </pre>
 */
@RunWith(SpringRunner.class)
@DataJpaTest(includeFilters = @Filter(
		type = FilterType.ASSIGNABLE_TYPE,
		classes = {JpaAuditingConfig.class}))
@ActiveProfiles("test")
public class SidoSggRepositoryTest {

	@Autowired
	SidoSggRepository sidoSggRepository;
	
	@After
	public void cleanup() {
		sidoSggRepository.deleteAll();
	}
	
	@Test
	public void testFindBySidoByOrderBySortSeq() {
		// when
		List<SidoSgg> list = sidoSggRepository.findBySidoOrderBySggAsc("서울특별시");
		
		// then
		assertEquals(list.size(), 25);
	}
	
	@Test
	public void testFindDistinctSidoByOrderBySortSeq() {
		// when
		List<SidoSggDto.SidoRes> list = sidoSggRepository.findDistinctSidoByOrderBySortSeq();
		
		// then
		assertEquals(list.size(), 17);
	}
}
