package com.moim.addr.repository.custom;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;

import com.moim.addr.entity.QSidoSgg;
import com.moim.addr.entity.SidoSgg;
import com.moim.addr.service.sidosgg.SidoSggDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

/**
 * SidoSggCustomRepositoryImpl.java
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
@Transactional(readOnly = true)
public class SidoSggCustomRepositoryImpl extends QuerydslRepositorySupport implements SidoSggCustomRepository {
	
	final QSidoSgg sidoSgg = QSidoSgg.sidoSgg;
	
	public SidoSggCustomRepositoryImpl() {
		super(SidoSgg.class);
	}
	
	@Override
	public List<SidoSggDto.SidoRes> findDistinctSidoByOrderBySortSeq() {
		JPAQueryFactory queryFactory = new JPAQueryFactory(getEntityManager());
		return queryFactory
				.select(Projections.bean(SidoSggDto.SidoRes.class
						, sidoSgg.sido
						))
				.from(sidoSgg)
				.distinct()
				.fetch();
	}

}
