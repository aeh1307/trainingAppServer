package no.aeh1307.trainingapp.service;

import no.aeh1307.trainingapp.domain.Activity;
import no.aeh1307.trainingapp.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

  private final ActivityRepository activityRepository;

  @Autowired
  public ActivityService(ActivityRepository activityRepository) {
    this.activityRepository = activityRepository;
  }

  public List<Activity> getAllActivities() {
    return activityRepository.findAll();
  }
}
