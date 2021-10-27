package com.azercell.personposition.dao.impl;

import com.azercell.personposition.dao.inter.PersonDaoInter;
import com.azercell.personposition.dao.inter.WorkPositionDaoInter;
import com.azercell.personposition.dto.PersonDTO;
import com.azercell.personposition.dto.WorkPositionDTO;
import com.azercell.personposition.exceptions.ConstraintException;
import com.azercell.personposition.exceptions.NotFoundException;
import com.azercell.personposition.modul.Person;
import com.azercell.personposition.modul.WorkPosition;
import com.azercell.personposition.modul.enums.PersonStatus;
import com.azercell.personposition.modul.enums.PositionStatus;
import com.azercell.personposition.repository.WorkPositionRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class WorkPositoionDaoImpl implements WorkPositionDaoInter {
    @Autowired
    WorkPositionRep workPositionRep;

    @Autowired
    PersonDaoInter personDaoInter;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<WorkPositionDTO> getAll(){

        return workPositionRep.findAll().stream().map(WorkPositionDTO::of).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public WorkPositionDTO getById(Long id) {
        WorkPosition workPosition =  workPositionRep.findById(id).orElseThrow(() -> new NotFoundException("Not found"));
        return new WorkPositionDTO(workPosition);}

    @Override
    @Transactional
    public WorkPositionDTO create(WorkPositionDTO workPosition){

        Set<PositionStatus> status = Collections.singleton(PositionStatus.INACTIVE);
        Set<PositionStatus> statusWorkPosition =workPosition.getStatus();
        PersonDTO personDTO = workPosition.getWorker();

        if(personDTO!=null){
            if(statusWorkPosition!=Collections.singleton(PositionStatus.VACANT)) {
                new ConstraintException("Worker can be added only to the Work Position which is in VACANT Status");
            }
            else{
                statusWorkPosition = Collections.singleton(PositionStatus.CATCHED);
            }
        }
        else{
            if( statusWorkPosition==null|| statusWorkPosition.isEmpty()){
                statusWorkPosition = status;
            }
            else
            {
                personDTO.setStatus( Collections.singleton(PersonStatus.EMPLOYED));
                PersonDTO p = personDaoInter.update(personDTO.getId(), personDTO);
            }
        }

        WorkPosition workPositions = workPositionRep.save(new WorkPosition(workPosition.getName(),workPosition.getCreated(),
                                                            statusWorkPosition,new Person(personDTO.getId())));
        return new WorkPositionDTO(workPositions) ;
    }


    @Override
    @Transactional
    public WorkPositionDTO update(Long id, WorkPositionDTO wp){
        WorkPosition workPosition = workPositionRep.findById(id).orElseThrow(() -> new NotFoundException("Not found") );
        workPosition.setName(wp.getName());
        workPosition.setWorker(new Person(wp.getWorker().getId()));
        workPosition.setCreated(wp.getCreated());
        workPosition.setStatus(wp.getStatus());

        WorkPosition updatedUser = workPositionRep.save(workPosition);
        return new WorkPositionDTO(updatedUser);
    }

    @Override
    public void delete(Long id) {
        WorkPosition WorkPosition =  workPositionRep.findById(id).orElseThrow(() -> new NotFoundException("Not found"));
        workPositionRep.deleteById(WorkPosition.getId());
    }
    
}
