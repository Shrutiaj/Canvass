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

import com.appapi.canvassapi.dao.SurveyDAO;
import com.appapi.canvassapi.models.Survey;

@RestController
@RequestMapping("/Survey")
@CrossOrigin(origins = "*")
public class SurveyController {
	@Autowired
	SurveyDAO surveyDAO;
	
	@GetMapping("/all")
	public List<Survey> getAllCustomers(){
		return surveyDAO.findAll();
	}
	
	@GetMapping("/getByResponseID")
	public Survey getSubmittedSurveyByID(Long surveyID){
		return surveyDAO.getSurveyById(surveyID);
	}
	
	@PostMapping("/createSubmittedSurvey")
	public Survey createSubmittedSurvey(@Valid @RequestBody Survey survey) {
		return surveyDAO.save(survey);
	}
}
