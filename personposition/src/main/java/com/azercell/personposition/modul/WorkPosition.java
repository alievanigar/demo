package com.azercell.personposition.modul;

import com.azercell.personposition.dto.PersonDTO;
import com.azercell.personposition.modul.enums.PositionStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;
@Data
@NoArgsConstructor
@Entity
@Table(name="work_position")
public class WorkPosition {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(nullable=false)
    	private String name;
        @Column(nullable=false)
        private Date created ;
        @ElementCollection(targetClass= PositionStatus.class, fetch= FetchType.EAGER)
        @CollectionTable(name="position_status", joinColumns=@JoinColumn(name="position_id"))
        @Enumerated(EnumType.STRING)
        private Set<PositionStatus> status;

        @JoinColumn(name = "person_id", referencedColumnName = "id")
        @ManyToOne(optional = false)
        private Person worker;

        public WorkPosition(String name, Date created, Set<PositionStatus> status, Person worker) {
                this.name = name;
                this.created = created;
                this.status = status;
                this.worker = worker;
        }


}
