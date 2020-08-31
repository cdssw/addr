package com.moim.addr.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.moim.addr.service.sidosgg.SidoSggDto;
import com.moim.addr.service.sidosgg.SidoSggService;

import lombok.AllArgsConstructor;

/**
 * SidoSggController.java
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
@AllArgsConstructor
@RestController
@RequestMapping
public class SidoSggController {

	private SidoSggService sidoSggService;
	
	@GetMapping("/sido")
	@ResponseStatus(value = HttpStatus.OK)
	public List<SidoSggDto.SidoRes> getSidoList() {
		return sidoSggService.getSido();
	}
	
	@GetMapping("/sgg")
	@ResponseStatus(value = HttpStatus.OK)
	public List<SidoSggDto.SggRes> getSggList(@RequestParam("sido") final String sido) {
		return sidoSggService.getSgg(sido);
	}
}
