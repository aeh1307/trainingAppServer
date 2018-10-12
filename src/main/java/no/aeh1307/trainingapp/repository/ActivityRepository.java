package no.aeh1307.trainingapp.repository;

import no.aeh1307.trainingapp.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
