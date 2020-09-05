package com.moim.addr.service.sidosgg;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.moim.addr.repository.SidoSggRepository;
import com.moim.addr.service.sidosgg.SidoSggDto.SggRes;
import com.moim.addr.service.sidosgg.SidoSggDto.SidoRes;

import lombok.AllArgsConstructor;

/**
 * SidoSggServiceImpl.java
 * 
 * @author cdssw
 * @since Apr 6, 2020
 * @description 서비스 구현체
 * 
 * <pre>
 * since          author           description
 * ===========    =============    ===========================
 * Apr 6, 2020    cdssw            최초 생성
 * </pre>
 */
@AllArgsConstructor // private 변수에 autowired 추가 안해도 됨
@Service
public class SidoSggServiceImpl implements SidoSggService {

	private ModelMapper modelMapper;
	private SidoSggRepository sidoSggRepository;

	@Override
	public List<SidoRes> getSido() {
		return sidoSggRepository.findDistinctSidoByOrderBySortSeq().stream().map(m -> modelMapper.map(m, SidoRes.class)).collect(Collectors.toList());
	}

	@Override
	public List<SggRes> getSgg(String sido) {
		return sidoSggRepository.findBySidoOrderBySggAsc(sido).stream().map(m -> modelMapper.map(m, SggRes.class)).collect(Collectors.toList());
	}
	
}
