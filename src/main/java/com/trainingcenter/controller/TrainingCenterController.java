package com.trainingcenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainingcenter.model.TrainingCenter;
import com.trainingcenter.service.TrainingCenterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/training-centers")
public class TrainingCenterController {
	
	@Autowired
	private TrainingCenterService service;
	
	@PostMapping
	public ResponseEntity<TrainingCenter>createTrainingCenter(@Valid @RequestBody TrainingCenter center){
		TrainingCenter saveCenter=service.saveTrainingCenter(center);
		return ResponseEntity.ok(saveCenter);
	}
	
}
