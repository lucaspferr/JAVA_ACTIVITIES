package com.viceri.APIViceri.vservice;

import com.viceri.APIViceri.vrepository.APITarefaRepository;
import com.viceri.APIViceri.vusu.APITarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class APITarefaService {

    private final APITarefaRepository apiTarefaRepository;

    @Autowired
    public APITarefaService(APITarefaRepository apiTarefaRepository) {
        this.apiTarefaRepository = apiTarefaRepository;
    }

    public List<APITarefa> getAPITarefas(){
        return apiTarefaRepository.findAll();
    }

    public void novoTarefa(APITarefa apiTarefa) {

        apiTarefaRepository.save(apiTarefa);


    }

    public void deletTarefa(Long Tid) {
        boolean exists = apiTarefaRepository.existsById(Tid);
        if(!exists){
            throw new IllegalStateException("ID "+ Tid +" nao existente.");
        }
        apiTarefaRepository.deleteById(Tid);
    }


    @Transactional
    public void updateTarefa(Long Tid, String tarefa, String desctarefa, String prioridade) {
        APITarefa apiTarefa = apiTarefaRepository.findById(Tid)
                .orElseThrow(() -> new IllegalStateException("ID "+Tid+" nao existente."));
        if(tarefa != null && tarefa.length() > 0 && !Objects.equals(apiTarefa.getTarefa(), tarefa)){
            apiTarefa.setTarefa(tarefa);
        }
        if(desctarefa != null && desctarefa.length() > 0 && !Objects.equals(apiTarefa.getDesctarefa(), desctarefa)){
            apiTarefa.setDesctarefa(desctarefa);
        }
        if(prioridade != null && prioridade.length() > 0 && !Objects.equals(apiTarefa.getPrioridade(), prioridade)){
            apiTarefa.setPrioridade(prioridade);
        }
    }


    public Optional <APITarefa> findById(Long Tid) {
        return apiTarefaRepository.findById(Tid);
    }
}
