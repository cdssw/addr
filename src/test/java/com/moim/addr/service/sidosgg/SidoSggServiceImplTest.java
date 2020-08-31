package com.moim.addr.service.sidosgg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import com.moim.addr.entity.SidoSgg;
import com.moim.addr.repository.SidoSggRepository;

/**
 * SidoSggServiceImplTest.java
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
@RunWith(MockitoJUnitRunner.class)
public class SidoSggServiceImplTest {

	// 테스트 하고자 하는 class
	private SidoSggServiceImpl sidoSggServiceImpl;
	
	// repository를 테스트 하지 않음
	@Mock private SidoSggRepository sidoSggRepository;
	
	private SidoSggDto.SidoRes res1;
	private SidoSgg res2;
	
	@Before
	public void setUp() {
		ModelMapper modelMapper = new ModelMapper();
		sidoSggServiceImpl = new SidoSggServiceImpl(modelMapper, sidoSggRepository);
		
		res1 = SidoSggDto.SidoRes.builder()
				.sido("서울특별시")
				.build();
		res2 = SidoSgg.builder()
				.sido("서울특별시")
				.sgg("강남구")
				.build();
	}
	
	@Test
	public void testGetSido() {
		// given
		given(sidoSggRepository.findDistinctSidoByOrderBySortSeq()).willReturn(Arrays.asList(res1));
		
		// when
		List<SidoSggDto.SidoRes> list = sidoSggServiceImpl.getSido();
		
		// then
		assertEquals(list.size(), 1);
	}
	
	@Test
	public void testGetSgg() {
		// given
		given(sidoSggRepository.findBySidoOrderBySortSeq(any())).willReturn(Arrays.asList(res2));
		
		// when
		List<SidoSggDto.SggRes> list = sidoSggServiceImpl.getSgg("서울특별시");
		
		// then
		assertEquals(list.size(), 1);
	}
}
