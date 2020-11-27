package com.appapi.canvassapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appapi.canvassapi.models.SurveyQuestion;

public interface SurveyQuestionRepository extends JpaRepository<SurveyQuestion, Long> {
	SurveyQuestion findSurveyQuestionByQuestionID(Long questionID);
}
