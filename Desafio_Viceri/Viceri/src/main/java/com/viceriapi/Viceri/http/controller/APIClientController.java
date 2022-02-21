package com.viceriapi.Viceri.http.controller;


import com.viceriapi.Viceri.entity.APIClient;
import com.viceriapi.Viceri.service.APIClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/client")
public class APIClientController {

    @Autowired
    private APIClientService apiClientService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public APIClient salver(@Valid @RequestBody APIClient apiClient){
        return apiClientService.salvar(apiClient);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<APIClient> listarUsu(){
        return apiClientService.listarUsu();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public APIClient buscarUsuporID(@PathVariable("id") Long id){
        return apiClientService.buscarporID(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario nao encontrado"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerUsu(@PathVariable("id") Long id){
        apiClientService.buscarporID(id)
                .map(apiClient -> {
                    apiClientService.removerporID(apiClient.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario nao encontrado"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void autalizarUsu(@PathVariable("id") Long id, @RequestBody APIClient apiClient){
        apiClientService.buscarporID(id)
                .map(apiClientBase -> {
                    modelMapper.map(apiClient, apiClientBase);
                    apiClientService.salvar(apiClientBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario nao encontrado"));
    }
}
