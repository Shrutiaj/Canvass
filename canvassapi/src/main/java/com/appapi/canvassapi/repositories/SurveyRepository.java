package com.appapi.canvassapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appapi.canvassapi.models.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
	Survey findSurveyBySurveyID(Long surveyID);
}
