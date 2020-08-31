package com.moim.addr.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * SidoSgg.java
 * 
 * @author cdssw
 * @since Apr 6, 2020
 * @description  
 * 
 * <pre>
 * since          author           description
 * ===========    =============    ===========================
 * Apr 6, 2020    cdssw            최초 생성
 * </pre>
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 코드 내에서 객체를 생성하지 못하도록
@Getter
@Entity
public class SidoSgg extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String sido;
	private String sgg;
	private int sortSeq;
	
	@Builder
	public SidoSgg(String sido, String sgg) {
		this.sido = sido;
		this.sgg = sgg;
	}
}
