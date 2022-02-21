package com.viceriapi.Viceri.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class APIClient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    //@Column(name = "nome", nullable = false)
    @NotBlank(message = "Campo Obrigatorio")
    private String nome;

    @Column(name = "email", unique = true)
    @NotBlank(message = "Campo Obrigatorio")
    private String email;

    //@Column(name = "senha", nullable = false)
    @NotBlank(message = "Campo Obrigatorio")
    private String senha;

}
