package com.lanz.agendadortarefas.business;

import com.lanz.agendadortarefas.business.dto.TarefasDTO;
import com.lanz.agendadortarefas.business.mapper.TarefasConverter;
import com.lanz.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.lanz.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.lanz.agendadortarefas.infrastructure.repository.TarefasRepository;
import com.lanz.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefasConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravaTarefa(String token, TarefasDTO dto){
        String email = jwtUtil.extractUseremail(token.substring(7));
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefasConverter.paraTarefaEntity(dto);

        return tarefasConverter.paraTarefaDTO(
                tarefasRepository.save(entity));
    }
}
