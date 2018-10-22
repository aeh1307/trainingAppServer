package no.aeh1307.trainingapp.service;

import no.aeh1307.trainingapp.domain.Program;
import no.aeh1307.trainingapp.repository.ProgramRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramService {

  @Autowired
  private ProgramRepository programRepository;

  public List<Program> getAllPrograms() {
    return programRepository.findAll();
  }

  public Program getProgram(Long id) {
    return programRepository.findById(id).orElse(Program.builder().build());
  }

  public Program saveProgram(Program program) {
    return programRepository.save(program);
  }

  public Program updateProgram(Program inProgram) {
    Program dbProgram = programRepository.findById(inProgram.getProgramId()).orElse(null);
    if(dbProgram!=null){
      dbProgram.setProgramName(inProgram.getProgramName());
      dbProgram.setProgramDuration(inProgram.getProgramDuration());
      programRepository.save(dbProgram);
      BeanUtils.copyProperties(dbProgram, inProgram);
      return inProgram;
    } else {
      return null;
    }
  }

  public void deleteProgram(Long programId) {
    programRepository.deleteById(programId);
  }
}
