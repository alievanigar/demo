package com.azercell.personposition.dto;


import com.azercell.personposition.modul.Person;
import com.azercell.personposition.modul.WorkPosition;
import com.azercell.personposition.modul.enums.PositionStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class WorkPositionDTO {
    private Long id;
    private String name;
    private Date created ;
    private Set<PositionStatus> status;
    private PersonDTO worker;

    public WorkPositionDTO(WorkPosition wp){
        this.id = wp.getId();
        this.name = wp.getName();
        this.created = wp.getCreated();
        this.status = wp.getStatus();
        Person p = wp.getWorker();

       this.worker = new PersonDTO(p);
    }

    public static WorkPositionDTO of(WorkPosition workPosition) {
        return new WorkPositionDTO(workPosition);
    }
}
