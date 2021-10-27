package com.azercell.personposition.repository;


import com.azercell.personposition.modul.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRep extends CrudRepository<Person, Long> {
}
