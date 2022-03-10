package com.stefwebdesigner.bankSpringBoot.repositories;

import com.stefwebdesigner.bankSpringBoot.entities.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

    Optional<UserModel> findByUsername(String username);


    //NO NEED TO SAVE OR DO MANY OF THE CRUD METHODS
    //IT IS ALL INCORPORATED INTO THE REPOSITORY

    //THIS INCLUDES THE FOLLOWING CODE ALREADY PREMADE:
    /*
    save()
    saveAll()
    findById()
    existsById()
    findAll()
    findById()
    count()
    deleteById()
    delete()
    deleteAll()
    */


}
