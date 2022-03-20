package com.viceri.APIViceri.vusu;

import com.sun.istack.NotNull;

import javax.persistence.*;


@Entity
@Table(name = "apiTarefa")
public class APITarefa {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Tid;

    @NotNull
    private Long id_usuario;

    @NotNull
    private String tarefa;

    @NotNull
    private String desctarefa;

    @NotNull
    private String prioridade;

    @ManyToOne
    @JoinColumn(name="id_do_usu")
    private APIUsu apiUsu;

    public APITarefa() {
    }

    public APITarefa(Long Tid, Long id_usuario, String tarefa, String desctarefa, String prioridade) {
        this.Tid = Tid;
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

    public Long getTid() {return Tid;}

    public void setTid(Long Tid) {this.Tid = Tid;}

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