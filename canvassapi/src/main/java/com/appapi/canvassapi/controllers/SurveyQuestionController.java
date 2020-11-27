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

import com.appapi.canvassapi.dao.SurveyQuestionDAO;
import com.appapi.canvassapi.models.SurveyQuestion;

@RestController
@RequestMapping("/SurveyQuestion")
@CrossOrigin(origins = "*")
public class SurveyQuestionController {
	@Autowired
	SurveyQuestionDAO surveyQuestionDAO;
	
	@GetMapping("/all")
	public List<SurveyQuestion> getAllSurveyQuestions(){
		return surveyQuestionDAO.findAll();
	}
	
	@GetMapping("/getByResponseID")
	public SurveyQuestion getSurveyQuestionByID(Long questionID){
		return surveyQuestionDAO.getSurveyQuestionById(questionID);
	}
	
	@PostMapping("/createSubmittedSurvey")
	public SurveyQuestion createSubmittedSurvey(@Valid @RequestBody SurveyQuestion surveyQuestion) {
		return surveyQuestionDAO.save(surveyQuestion);
	}
}
