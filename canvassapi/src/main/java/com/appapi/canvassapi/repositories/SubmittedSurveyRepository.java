package com.appapi.canvassapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appapi.canvassapi.models.SubmittedSurvey;

public interface SubmittedSurveyRepository extends JpaRepository<SubmittedSurvey, Long> {
  
	List<SubmittedSurvey> findSubmittedSurveyByUserName(String userName);
	
	SubmittedSurvey findSubmittedSurveyByResponseID(Long responseID);
}
