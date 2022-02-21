package com.viceri.APIViceri.vservice;

import com.viceri.APIViceri.vrepository.APIUsuRepository;
import com.viceri.APIViceri.vusu.APIUsu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class APIUsuService {

    private final APIUsuRepository apiUsuRepository;

    @Autowired
    public APIUsuService(APIUsuRepository apiUsuRepository) {
        this.apiUsuRepository = apiUsuRepository;
    }

    public List<APIUsu> getAPIUsuarios(){
        return apiUsuRepository.findAll();
    }

    public void novoUsu(APIUsu apiUsu) {
        Optional<APIUsu> apiUsuByEmail = apiUsuRepository
                .findAPIUsuByEmail(apiUsu.getEmail());
        if(apiUsuByEmail.isPresent()){
            throw new IllegalStateException("Email ja registrado");
        }
        apiUsuRepository.save(apiUsu);


    }

    public void deletUsu(Long Usuarioid) {
        boolean exists = apiUsuRepository.existsById(Usuarioid);
        if(!exists){
            throw new IllegalStateException("ID "+ Usuarioid +" nao existente.");
        }
        apiUsuRepository.deleteById(Usuarioid);
    }


    @Transactional
    public void updateUsu(Long Usuarioid, String nome, String email, String senha) {
        APIUsu apiUsu = apiUsuRepository.findById(Usuarioid)
                .orElseThrow(() -> new IllegalStateException("ID "+Usuarioid+" nao existente."));
        if(nome != null && nome.length() > 0 && !Objects.equals(apiUsu.getNome(), nome)){
            apiUsu.setNome(nome);
        }
        if(email != null && email.length() > 0 && !Objects.equals(apiUsu.getEmail(), email)){
            Optional<APIUsu> apiUsuOptional = apiUsuRepository
                    .findAPIUsuByEmail(email);
            if (apiUsuOptional.isPresent()){
                throw new IllegalStateException("Email pegue");
            }
            apiUsu.setEmail(email);
        }
        if(senha != null && senha.length() > 0 && !Objects.equals(apiUsu.getSenha(), senha)){
            apiUsu.setSenha(senha);
        }
    }


    public Optional <APIUsu> findById(Long id) {
        return apiUsuRepository.findById(id);
    }


}
