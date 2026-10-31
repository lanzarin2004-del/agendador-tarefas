package com.lanz.agendadortarefas.business.mapper;

import com.lanz.agendadortarefas.business.dto.TarefasDTO;
import com.lanz.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefaEntity(TarefasDTO dto);

    TarefasDTO paraTarefaDTO(TarefasEntity entity);
}
