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

    @GetMapping(path = "{id}")
    public Optional<APITarefa> VoltaUma(Long id){return apiTarefaService.findById(id);}

    @PostMapping
    public void regTarefa(@RequestBody APITarefa apiTarefa){
        apiTarefaService.novoTarefa(apiTarefa);
    }

    @DeleteMapping(path = "{id}")
    public void delTarefa(@PathVariable("id") Long id){
        apiTarefaService.deletTarefa(id);
    }

    @PutMapping(path = "{id}")
    public void atuTarefa(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String tarefa,
            @RequestParam(required = false) String desctarefa,
            @RequestParam(required = false) String prioridade){
        apiTarefaService.updateTarefa(id, tarefa, desctarefa, prioridade);
    }
}
