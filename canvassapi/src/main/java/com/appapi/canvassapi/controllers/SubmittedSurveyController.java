package com.appapi.canvassapi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appapi.canvassapi.dao.SubmittedSurveyDAO;
import com.appapi.canvassapi.models.SubmittedSurvey;

@RestController
@RequestMapping("/SubmittedSurvey")
@CrossOrigin(origins = "*")
public class SubmittedSurveyController {
	@Autowired
	SubmittedSurveyDAO submittedSurveyDAO;
	
	@GetMapping("/all")
	public List<SubmittedSurvey> getAllSubmittedSurveys(){
		return submittedSurveyDAO.findAll();
	}
	
	@GetMapping("/getByResponseID")
	public SubmittedSurvey getSubmittedSurveyByID(Long responseID){
		return submittedSurveyDAO.getSubmittedSurveyById(responseID);
	}
	
	@PostMapping("/createSubmittedSurvey")
	public SubmittedSurvey createSubmittedSurvey(@Valid @RequestBody SubmittedSurvey submittedSurvey) {
		return submittedSurveyDAO.save(submittedSurvey);
	}
}
