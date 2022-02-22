package com.stefwebdesigner.bankSpringBoot.beans.repositories;

import com.stefwebdesigner.bankSpringBoot.beans.entities.UserEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<UserEntities, Integer> {

}
