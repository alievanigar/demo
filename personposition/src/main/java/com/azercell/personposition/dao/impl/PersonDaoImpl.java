package com.azercell.personposition.dao.impl;

import com.azercell.personposition.dao.inter.PersonDaoInter;
import com.azercell.personposition.dto.PersonDTO;
import com.azercell.personposition.dto.SkillDTO;
import com.azercell.personposition.exceptions.NotFoundException;
import com.azercell.personposition.modul.Person;
import com.azercell.personposition.modul.Skill;
import com.azercell.personposition.modul.enums.PersonStatus;
import com.azercell.personposition.repository.PersonRep;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class PersonDaoImpl implements PersonDaoInter {

    private final PersonRep personRep;
    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<PersonDTO> getAll(){
        List<Person> personList =(List<Person>) personRep.findAll();

        return  personList.stream().map(PersonDTO::of).collect(Collectors.toList());

    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public PersonDTO getById(Long id) {
         Person person =  personRep.findById(id).orElseThrow(() -> new NotFoundException("Not found"));
        return new PersonDTO(person);}

    @Override
    @Transactional
    public PersonDTO create(PersonDTO personDTO){
        List<SkillDTO> skillDTOS = personDTO.getSkills();
        List<Skill> skills = new ArrayList<>();
        for (int i = 0; i < skillDTOS.size(); i++) {
            Skill s = new Skill(skills.get(i).getId());
            skills.add(s);
        }

        Set<PersonStatus> status = Collections.singleton(PersonStatus.UNEMPLOYED);
        Set<PersonStatus> statusPerson =null;

        if(personDTO.getStatus()==null||personDTO.getStatus().isEmpty()){
            statusPerson = status;
        }
        else{
            statusPerson = personDTO.getStatus();
        }

        final Person person = personRep.save(new Person(personDTO.getName(),personDTO.getSurname(), personDTO.getGender(),
                personDTO.getAge(), skills ,statusPerson));
        return  new PersonDTO(person);
    }


    @Override
    @Transactional
    public PersonDTO update(Long id, PersonDTO p){
        List<Skill> skills = null;
        if(p.getSkills()!=null|| !p.getSkills().isEmpty()) {
            List<SkillDTO> skillDTOS = p.getSkills();

            for (int i = 0; i < skillDTOS.size(); i++) {
                Skill s = new Skill(skills.get(i).getId());
                skills.add(s);
            }
        }
        Person person = personRep.findById(id).orElseThrow(() -> new NotFoundException("Not found") );
        person.setSurname(p.getSurname());
        person.setAge(p.getAge());
        person.setName(p.getName());
        person.setGender(p.getGender());
        person.setSkills(skills);
        if(skills!=null||!skills.isEmpty()) {
            person.setStatus(Collections.singleton(PersonStatus.JOB_SEEKER));
        }
        else{
            person.setStatus(p.getStatus());
        }

         Person updatedUser = personRep.save(person);
        return new PersonDTO(updatedUser);
    }

    @Override
    public void delete(Long id) {
        Person person =  personRep.findById(id).orElseThrow(() -> new NotFoundException("Not found"));
        personRep.deleteById(person.getId());
    }
}
