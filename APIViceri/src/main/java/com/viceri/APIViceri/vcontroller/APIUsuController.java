package com.viceri.APIViceri.vcontroller;

import com.viceri.APIViceri.vservice.APIUsuService;
import com.viceri.APIViceri.vusu.APIUsu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "viceri/usuario")
public class APIUsuController {

    private final APIUsuService apiUsuService;

    @Autowired
    public APIUsuController(APIUsuService apiUsuService) {
        this.apiUsuService = apiUsuService;
    }

    @GetMapping
    public List<APIUsu> getAPIUsuarios(){
        return apiUsuService.getAPIUsuarios();
    }

    @PostMapping
    public void regUsuar(@RequestBody APIUsu apiUsu){
        apiUsuService.novoUsu(apiUsu);
    }

    @DeleteMapping(path = "{Usuarioid}")
    public void delUsuar(@PathVariable("Usuarioid") Long Usuarioid){
        apiUsuService.deletUsu(Usuarioid);
    }

    @PutMapping(path = "{Usuarioid}")
    public void atuUsu(
            @PathVariable("Usuarioid") Long Usuarioid,
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String senha){
        apiUsuService.updateUsu(Usuarioid, nome, email, senha);
    }
}
