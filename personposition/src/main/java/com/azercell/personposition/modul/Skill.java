package com.azercell.personposition.modul;


import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name="skill")
public class Skill implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private String name;
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @NotNull
    private Person user;

    public Skill(String name, Person user) {
        this.name = name;
        this.user = user;
    }

    public Skill(Long id) {
        this.id = id;
    }
}
