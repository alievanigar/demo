package com.azercell.personposition.dao.inter;

import com.azercell.personposition.dto.SkillDTO;

import java.util.List;

public interface SkillDaoInter {

    SkillDTO getById (Long id);
    SkillDTO create(SkillDTO skillDTO);

    List<SkillDTO> getAll();
    SkillDTO update(Long id, SkillDTO skillDTO);
    void delete(Long id);
}
