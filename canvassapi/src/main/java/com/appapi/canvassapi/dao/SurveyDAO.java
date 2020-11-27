package com.appapi.canvassapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appapi.canvassapi.models.Survey;

import com.appapi.canvassapi.repositories.SurveyRepository;

@Service
public class SurveyDAO {
	@Autowired
	SurveyRepository surveyRepository;
	
	/* save a survey */
	public Survey save(Survey cust) {
		return surveyRepository.save(cust);
	}
	
	/* search all surveys */
	public List<Survey> findAll(){
		return (List<Survey>)surveyRepository.findAll();
	}
	
	/* get a survey */
	public Survey getSurveyById(Long surveyID) {
		return surveyRepository.findSurveyBySurveyID(surveyID);
	}
	
	/* delete a survey */
	public void delete(Survey survey) {
		surveyRepository.delete(survey);
	}
}
