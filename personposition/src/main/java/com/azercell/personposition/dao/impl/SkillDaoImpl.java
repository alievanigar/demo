package com.azercell.personposition.dao.impl;


import com.azercell.personposition.dao.inter.SkillDaoInter;
import com.azercell.personposition.dto.SkillDTO;
import com.azercell.personposition.exceptions.NotFoundException;
import com.azercell.personposition.modul.Person;
import com.azercell.personposition.modul.Skill;
import com.azercell.personposition.repository.SkillRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillDaoImpl implements SkillDaoInter {
    @Autowired
    SkillRep skillRep;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<SkillDTO> getAll(){
        return skillRep.findAll().stream().map(SkillDTO::of).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public SkillDTO getById(Long id) {
        Skill skill =  skillRep.findById(id).orElseThrow(() -> new NotFoundException("Not found"));
        return new SkillDTO(skill);}

    @Override
    @Transactional
    public SkillDTO create(SkillDTO skillDTO){
         Skill skills = skillRep.save(new Skill(skillDTO.getName(),new Person(skillDTO.getUser().getId())));
        return  new SkillDTO(skills);
    }


    @Override
    @Transactional
    public SkillDTO update(Long id, SkillDTO s){
        Skill Skill = skillRep.findById(id).orElseThrow(() -> new NotFoundException("Not found") );
        Skill.setName(s.getName());
        Skill.setUser(new Person(s.getUser().getId()));

        Skill updatedUser = skillRep.save(Skill);
        return  new SkillDTO(updatedUser);
    }

    @Override
    public void delete(Long id) {
        Skill skill =  skillRep.findById(id).orElseThrow(() -> new NotFoundException("Not found"));
        skillRep.deleteById(skill.getId());
    }
}
