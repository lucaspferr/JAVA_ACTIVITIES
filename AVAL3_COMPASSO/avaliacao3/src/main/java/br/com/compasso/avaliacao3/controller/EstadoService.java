package br.com.compasso.avaliacao3.controller;

import br.com.compasso.avaliacao3.modelo.Estado;
import br.com.compasso.avaliacao3.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;



@Service
public class EstadoService {

    private String[] regioes = {"Norte","Nordeste","Sul","Sudeste","Centro-Oeste"};

    private final EstadoRepository estadoRepository;

    @Autowired
    public EstadoService(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @Transactional
    public void atualizarEstado(Long id, Estado estado){
        Estado estado2 = estadoRepository.findById(id).orElseThrow(() -> new IllegalStateException("ID número "+id+" não existente."));
        estado2.setNome(estado.getNome());
        estado2.setRegiao(estado.getRegiao());
        estado2.setPopulacao(estado.getPopulacao());
        estado2.setCapital(estado.getCapital());
        estado2.setArea(estado.getArea());
    }

    public boolean verif_regiao(String regiao){
        if(regiao.matches("Norte") || regiao.matches("Nordeste") || regiao.matches("Sul") ||
                regiao.matches("Sudeste") || regiao.matches("Centro-Oeste")) return true;
        else return false;
    }
}
