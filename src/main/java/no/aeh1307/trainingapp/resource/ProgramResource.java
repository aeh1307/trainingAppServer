package no.aeh1307.trainingapp.resource;

import no.aeh1307.trainingapp.domain.Program;
import no.aeh1307.trainingapp.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProgramResource {

  @Autowired
  private ProgramService programService;

  @GetMapping("/programs")
  public List<Program> retrieveAllStudents() {
    System.out.println("Hello");
    return programService.getAllPrograms();
  }
}
