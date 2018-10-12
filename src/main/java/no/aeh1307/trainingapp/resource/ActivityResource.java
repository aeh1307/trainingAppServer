package no.aeh1307.trainingapp.resource;

import no.aeh1307.trainingapp.domain.Activity;
import no.aeh1307.trainingapp.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActivityResource {

  private final ActivityService activityService;

  @Autowired
  public ActivityResource(ActivityService activityService) {
    this.activityService = activityService;
  }

  @GetMapping("/activities")
  public List<Activity> getActivities() {
    return activityService.getAllActivities();
  }


}
