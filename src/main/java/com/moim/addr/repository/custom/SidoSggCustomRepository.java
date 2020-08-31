package com.moim.addr.repository.custom;

import java.util.List;

import com.moim.addr.service.sidosgg.SidoSggDto;

/**
 * SidoSggCustomRepository.java
 * 
 * @author cdssw
 * @since Apr 25, 2020
 * 
 * <pre>
 * since          author           description
 * ===========    =============    ===========================
 * Apr 25, 2020   cdssw            최초 생성
 * </pre>
 */
public interface SidoSggCustomRepository {

	List<SidoSggDto.SidoRes> findDistinctSidoByOrderBySortSeq();
}
