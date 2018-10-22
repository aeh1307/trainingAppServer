package no.aeh1307.trainingapp.resource;

import no.aeh1307.trainingapp.domain.Program;
import no.aeh1307.trainingapp.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.xml.ws.Response;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/program")
public class ProgramResource {

  @Autowired
  private ProgramService programService;

  @GetMapping("/")
  public List<Program> findAllPrograms() {
    return programService.getAllPrograms();
  }

  @GetMapping("/{id}")
  public Program findProgramById(@PathVariable(value="id") Long id) {
    return programService.getProgram(id);
  }

  @PostMapping("/")
  public ResponseEntity<Object> saveProgram(@RequestBody Program newProgram) {
    Program savedProgram = programService.saveProgram(newProgram);

    if(savedProgram == null) {
      return ResponseEntity.ok().body("Not found");
    }
    return ResponseEntity.ok().body(savedProgram);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> editProgram(@PathVariable(value = "id") Long programId, @RequestBody Program inProgram) {
    inProgram.setProgramId(programId);
    Program program = programService.updateProgram(inProgram);
    if(program == null) {
      return ResponseEntity.ok().body("Not found");
    }
    return ResponseEntity.ok().body(program);
  }

  @DeleteMapping("/{id}")
  public void deleteProgram(@PathVariable(value = "id") Long programId) {
    programService.deleteProgram(programId);
  }
}
