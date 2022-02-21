package com.viceri.APIViceri.vusu;

import com.sun.istack.NotNull;

import javax.persistence.*;


@Entity
@Table
public class APITarefa {




    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Long id_usuario;

    @NotNull
    private String tarefa;

    @NotNull
    private String desctarefa;

    @NotNull
    private String prioridade;

    public APITarefa() {
    }

    public APITarefa(Long id, Long id_usuario, String tarefa, String desctarefa, String prioridade) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.tarefa = tarefa;
        this.desctarefa = desctarefa;
        this.prioridade = prioridade;
    }

    public APITarefa(Long id_usuario, String tarefa, String desctarefa, String prioridade) {
        this.id_usuario = id_usuario;
        this.tarefa = tarefa;
        this.desctarefa = desctarefa;
        this.prioridade = prioridade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }

    public String getDesctarefa() {
        return desctarefa;
    }

    public void setDesctarefa(String desctarefa) {
        this.desctarefa = desctarefa;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }
}