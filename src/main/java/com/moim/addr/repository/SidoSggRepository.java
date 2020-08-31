package com.moim.addr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moim.addr.entity.SidoSgg;
import com.moim.addr.repository.custom.SidoSggCustomRepository;

/**
 * SidoSggRepository.java
 * 
 * @author cdssw
 * @since Apr 6, 2020
 * @description Meet Table CRUD
 * 추가적인 데이터 접근이 필요하면 여기에 추가
 * 다른 서비스에서도 사용하기에 service pkg에서 분리
 * 
 * <pre>
 * since          author           description
 * ===========    =============    ===========================
 * Apr 6, 2020    cdssw            최초 생성
 * </pre>
 */
// SidoSggCustomRepository를 추가한것은 Service에서 SidoSggRepository 하나로 확장하기 위함
public interface SidoSggRepository extends JpaRepository<SidoSgg, Long>, SidoSggCustomRepository {

	List<SidoSgg> findBySidoOrderBySortSeq(final String sido);
}
