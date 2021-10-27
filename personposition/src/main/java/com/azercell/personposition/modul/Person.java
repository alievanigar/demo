package com.azercell.personposition.modul;


import com.azercell.personposition.modul.enums.PersonStatus;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name="person")
public class Person {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
  @Column(nullable=false)
  private String name;
  @Column(nullable=false)
  private String surname;
  @Column(nullable=false)
  private String gender;
  @Column(nullable=false)
  private Integer age;

  @OneToMany( mappedBy = "user")
  private List<Skill> skills;

  @ElementCollection(targetClass= PersonStatus.class, fetch=FetchType.EAGER)
  @CollectionTable(name="person_status", joinColumns=@JoinColumn(name="person_id"))
  @Enumerated(EnumType.STRING)
  private Set<PersonStatus> status;

  public Person( String name, String surname, String gender, Integer age, List<Skill> skills, Set<PersonStatus> status) {
    this.name = name;
    this.surname = surname;
    this.gender = gender;
    this.age = age;
    this.skills = skills;
    this.status = status;

  }

  public Person(Long id) {
    this.id= id;
  }
}
