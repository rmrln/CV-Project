package fr.takima.demo;

import fr.takima.demo.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FomationDAO extends JpaRepository<Formation, Long> {

}
