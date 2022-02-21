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

    public void deletTarefa(Long Tarefaid) {
        boolean exists = apiTarefaRepository.existsById(Tarefaid);
        if(!exists){
            throw new IllegalStateException("ID "+ Tarefaid +" nao existente.");
        }
        apiTarefaRepository.deleteById(Tarefaid);
    }


    @Transactional
    public void updateTarefa(Long Tarefaid, String tarefa, String desctarefa, String prioridade) {
        APITarefa apiTarefa = apiTarefaRepository.findById(Tarefaid)
                .orElseThrow(() -> new IllegalStateException("ID "+Tarefaid+" nao existente."));
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


    public Optional <APITarefa> findById(Long id) {
        return apiTarefaRepository.findById(id);
    }
}
