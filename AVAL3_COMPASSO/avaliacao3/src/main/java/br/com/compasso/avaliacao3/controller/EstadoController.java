package br.com.compasso.avaliacao3.controller;


import br.com.compasso.avaliacao3.modelo.Estado;
import br.com.compasso.avaliacao3.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/states")
public class EstadoController {


    private final EstadoService estadoService;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    @GetMapping
    public List<Estado> buscar(String regiao){
        if(regiao == null){
            List<Estado> estados = estadoRepository.findAll();
            return estados;
        }
        List<Estado> estados = estadoRepository.findByRegiao(regiao);
        return estados;
    }

    @PostMapping
    @Transactional
    public String cadastrar(@RequestBody Estado estado){
        String _regiao = estado.getRegiao();
        if (estadoService.verif_regiao(_regiao)) {
            estadoRepository.save(estado);
            return "Postagem bem sucedida!";
        }else return "Por favor, escreva alguma região válida.";
    }

    @GetMapping("/{id}")
    public Estado buscarPorID(@PathVariable Long id){
        Optional<Estado> estado = estadoRepository.findById(id);
        return estado.get();
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable Long id, @RequestBody Estado estado){
        estadoService.atualizarEstado(id, estado);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id){
        try {
            estadoRepository.deleteById(id);
            return ("Registro com o ID "+id+" deletado com sucesso.");
        }catch (Exception e){
            return ("Houve um erro.");
        }
    }

}
