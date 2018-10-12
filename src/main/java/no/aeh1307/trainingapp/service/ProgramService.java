package no.aeh1307.trainingapp.service;

import no.aeh1307.trainingapp.domain.Program;
import no.aeh1307.trainingapp.repository.ProgramRepository;
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

}
