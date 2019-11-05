package eu.epitech.cashmanager.cm50.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import eu.epitech.cashmanager.cm50.models.User;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

}
