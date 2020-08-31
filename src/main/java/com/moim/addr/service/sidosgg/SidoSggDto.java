package com.moim.addr.service.sidosgg;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * SidoSggDto.java
 * 
 * @author cdssw
 * @since Apr 18, 2020
 * @description  SidoSgg Rest용 DTO
 * 
 * <pre>
 * since          author           description
 * ===========    =============    ===========================
 * Apr 18, 2020   cdssw            최초 생성
 * </pre>
 */
public class SidoSggDto {

	@Getter
	@Setter
	@NoArgsConstructor
	@SuperBuilder
	public static abstract class BaseRes {
		// Time format 처리
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
		private LocalDateTime inputDt;
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
		private LocalDateTime modifyDt;
	}
	
	@Getter
	@Setter
	@NoArgsConstructor
	@SuperBuilder
	public static class SidoRes extends BaseRes {
		private String sido;
	}
	
	@Getter
	@Setter
	@NoArgsConstructor
	@SuperBuilder
	public static class SggRes extends BaseRes {
		private String sido;
		private String sgg;
	}

}
