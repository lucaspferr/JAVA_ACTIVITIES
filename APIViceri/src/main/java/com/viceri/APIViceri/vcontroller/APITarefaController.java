package com.viceri.APIViceri.vcontroller;

import com.viceri.APIViceri.vservice.APITarefaService;
import com.viceri.APIViceri.vusu.APITarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "viceri/tarefa")
public class APITarefaController {

    private final APITarefaService apiTarefaService;

    @Autowired
    public APITarefaController(APITarefaService apiTarefaService) {
        this.apiTarefaService = apiTarefaService;
    }

    @GetMapping
    public List<APITarefa> getAPITarefas(){
        return apiTarefaService.getAPITarefas();
    }

    @GetMapping(path = "{Tid}")
    public Optional<APITarefa> VoltaUma(Long Tid){return apiTarefaService.findById(Tid);}

    @PostMapping
    public void regTarefa(@RequestBody APITarefa apiTarefa){
        apiTarefaService.novoTarefa(apiTarefa);
    }

    @DeleteMapping(path = "{Tid}")
    public void delTarefa(@PathVariable("Tid") Long Tid){
        apiTarefaService.deletTarefa(Tid);
    }

    @PutMapping(path = "{Tid}")
    public void atuTarefa(
            @PathVariable("Tid") Long Tid,
            @RequestParam(required = false) String tarefa,
            @RequestParam(required = false) String desctarefa,
            @RequestParam(required = false) String prioridade){
        apiTarefaService.updateTarefa(Tid, tarefa, desctarefa, prioridade);
    }
}
