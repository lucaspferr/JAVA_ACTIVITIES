package com.viceriapi.Viceri.service;

import com.viceriapi.Viceri.entity.APIClient;
import com.viceriapi.Viceri.repository.APIClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class APIClientService {

    @Autowired
    private APIClientRepository apiClientRepository;

    public APIClient salvar (APIClient apiClient){
        return apiClientRepository.save(apiClient);
    }

    public List<APIClient> listarUsu(){
        return apiClientRepository.findAll();
    }

    public Optional<APIClient> buscarporID(Long id){
        return apiClientRepository.findById(id);
    }

    public void removerporID(Long id){
        apiClientRepository.deleteById(id);
    }


}
