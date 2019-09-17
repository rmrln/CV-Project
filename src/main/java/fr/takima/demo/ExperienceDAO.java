package fr.takima.demo;

import fr.takima.demo.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceDAO extends JpaRepository<Experience, Long> {

}


