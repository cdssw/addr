package com.moim.addr.service.sidosgg;
/**
 * SidoSggService.java
 * 
 * @author cdssw
 * @since Apr 6, 2020
 * @description Controller에 제공되는 서비스
 * 
 * <pre>
 * since          author           description
 * ===========    =============    ===========================
 * Apr 6, 2020    cdssw            최초 생성
 * </pre>
 */

import java.util.List;

public interface SidoSggService {

	List<SidoSggDto.SidoRes> getSido();
	List<SidoSggDto.SggRes> getSgg(final String sido);
}
