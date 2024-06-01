package com.trainingcenter.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainingcenter.model.TrainingCenter;
import com.trainingcenter.repository.TrainingCenterRepository;

@Service
public class TrainingCenterService {

@Autowired

private TrainingCenterRepository repository;

public TrainingCenter saveTrainingCenter(TrainingCenter center) {
	center.setCreatedOn(Instant.now());
	return repository.save(center);
}
}
