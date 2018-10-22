package no.aeh1307.trainingapp.resource;

import no.aeh1307.trainingapp.domain.Activity;
import no.aeh1307.trainingapp.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityResource {

  private final ActivityService activityService;

  @Autowired
  public ActivityResource(ActivityService activityService) {
    this.activityService = activityService;
  }

  @GetMapping("/")
  public List<Activity> getActivities() {
    return activityService.getAllActivities();
  }

  @PostMapping("/")
  public ResponseEntity<Object> addActivity(@RequestBody Activity newActivity) {
    Activity activity = activityService.addActivityToProgram(newActivity);
    if(activity == null) {
      return ResponseEntity.ok().body("Not found");
    }
    return ResponseEntity.ok().body(activity);
  }


}
