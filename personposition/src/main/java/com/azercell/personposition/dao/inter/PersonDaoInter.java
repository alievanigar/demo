package com.azercell.personposition.dao.inter;



import com.azercell.personposition.dto.PersonDTO;

import java.util.List;

public interface PersonDaoInter {
    PersonDTO getById (Long id);
    PersonDTO create(PersonDTO person);

    List<PersonDTO> getAll();
    PersonDTO update(Long id, PersonDTO personDTO);
    void delete(Long id);
}
