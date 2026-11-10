package com.lanz.agendadortarefas.business.mapper;

import com.lanz.agendadortarefas.business.dto.TarefasDTO;
import com.lanz.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefaEntity(TarefasDTO dto);

    TarefasDTO paraTarefaDTO(TarefasEntity entity);

    List<TarefasEntity> paraListaTarefasEntity(List<TarefasDTO> dto);

    List<TarefasDTO> paraListaTarefasDTO(List<TarefasEntity> entity);
}
