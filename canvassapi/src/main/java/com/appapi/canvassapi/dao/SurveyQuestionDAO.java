package com.appapi.canvassapi.dao;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.appapi.canvassapi.models.SurveyQuestion;
import com.appapi.canvassapi.repositories.SurveyQuestionRepository;

@Service
public class SurveyQuestionDAO{
	@Autowired
	SurveyQuestionRepository surveyQuestionRepository;
	
	/* save a SubmittedSurvey */
	public SurveyQuestion save(SurveyQuestion surveyQuestion) {
		return surveyQuestionRepository.save(surveyQuestion);
	}
	
	/* search all SubmittedSurveys */
	public List<SurveyQuestion> findAll(){
		return (List<SurveyQuestion>)surveyQuestionRepository.findAll();
	}
	
	/* get a SubmittedSurvey */
	public SurveyQuestion getSurveyQuestionById(Long questionID) {
		return surveyQuestionRepository.findSurveyQuestionByQuestionID(questionID);
	}
	
	/* delete a SubmittedSurvey */
	public void delete(SurveyQuestion surveyQuestion) {
		surveyQuestionRepository.delete(surveyQuestion);
	}

}
