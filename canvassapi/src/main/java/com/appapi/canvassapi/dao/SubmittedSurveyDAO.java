package com.appapi.canvassapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appapi.canvassapi.models.SubmittedSurvey;
import com.appapi.canvassapi.repositories.SubmittedSurveyRepository;

@Service
public class SubmittedSurveyDAO {
	@Autowired
	SubmittedSurveyRepository submittedSurveyRepository;
	
	/* save a SubmittedSurvey */
	public SubmittedSurvey save(SubmittedSurvey role) {
		return submittedSurveyRepository.save(role);
	}
	
	/* search all SubmittedSurveys */
	public List<SubmittedSurvey> findAll(){
		return (List<SubmittedSurvey>)submittedSurveyRepository.findAll();
	}
	
	/* get a SubmittedSurvey */
	public SubmittedSurvey getSubmittedSurveyById(Long responseID) {
		return submittedSurveyRepository.findSubmittedSurveyByResponseID(responseID);
	}
	
	/* delete a SubmittedSurvey */
	public void delete(SubmittedSurvey submittedSurvey) {
		submittedSurveyRepository.delete(submittedSurvey);
	}
}
