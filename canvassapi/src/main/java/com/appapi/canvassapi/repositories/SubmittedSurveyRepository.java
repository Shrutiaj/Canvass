package com.appapi.canvassapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appapi.canvassapi.models.SubmittedSurvey;

public interface SubmittedSurveyRepository extends JpaRepository<SubmittedSurvey, Long> {
	SubmittedSurvey findSubmittedSurveyByResponseID(Long responseID);

}
