package com.shiyanlou.lesson10.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shiyanlou.lesson10.domain.PaginationObject;
import com.shiyanlou.lesson10.domain.ResultObject;
import com.shiyanlou.lesson10.domain.Sport;
import com.shiyanlou.lesson10.service.SportService;

@RestController
@RequestMapping("api/v1/sport")
public class SportController {

	@Autowired
	private SportService sportService;
	
	@GetMapping("get")
	public ResultObject getSportById(@RequestParam int id) {
		Sport sport = sportService.getSportById(id);
		ResultObject resultObject = new ResultObject(0, "success", sport);
		return resultObject;
	}
	
	@PostMapping("add")
	public ResultObject insertSport(Sport sport) {
		int modifyId = sportService.insertSport(sport);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("modifyId", modifyId);
		ResultObject resultObject = new ResultObject(0, "success", map);
		return resultObject;
	}
	
	@GetMapping("list")
	public ResultObject getAllSport(@RequestParam int pageNum, @RequestParam int pageSize) {
		PaginationObject paginationObject = sportService.getAllSport(pageNum, pageSize);
		ResultObject resultObject = new ResultObject(0, "success", paginationObject);
		return resultObject;
	}
	
	@DeleteMapping("delete")
	public ResultObject deleteSport(@RequestParam int id) {
		int modifyId = sportService.deleteSport(id);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("modifyId", modifyId);
		ResultObject resultObject = new ResultObject(0, "success", map);
		return resultObject;
	}
	
	@PutMapping("edit")
	public ResultObject updateSport(Sport sport) {
		int modifyId = sportService.updateSport(sport);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("modifyId", modifyId);
		ResultObject resultObject = new ResultObject(0, "success", map);
		return resultObject;
	}
}
