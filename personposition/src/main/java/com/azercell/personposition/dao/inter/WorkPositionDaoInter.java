package com.azercell.personposition.dao.inter;

import com.azercell.personposition.dto.WorkPositionDTO;

import java.util.List;

public interface WorkPositionDaoInter {

    WorkPositionDTO getById (Long id);
    WorkPositionDTO create(WorkPositionDTO workPositionDTO);

    List<WorkPositionDTO> getAll();
    WorkPositionDTO update(Long id, WorkPositionDTO workPositionDTO);
    void delete(Long id);
}
