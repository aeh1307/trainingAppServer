package no.aeh1307.trainingapp.repository;

import no.aeh1307.trainingapp.domain.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Long>{
}
