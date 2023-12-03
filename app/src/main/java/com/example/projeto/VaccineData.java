package com.example.projeto;

public class VaccineData {
    private String nomePet;
    private String vacinaTipo;
    private String vacinaData;
    private String servico;

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public VaccineData(String nomePet, String vacinaTipo, String vacinaData, String servico) {
        this.nomePet = nomePet;
        this.vacinaTipo = vacinaTipo;
        this.vacinaData = vacinaData;
        this.servico = servico;
    }

    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public String getVacinaTipo() {
        return vacinaTipo;
    }

    public void setVacinaTipo(String vacinaTipo) {
        this.vacinaTipo = vacinaTipo;
    }

    public String getVacinaData() {
        return vacinaData;
    }

    public void setVacinaData(String vacinaData) {
        this.vacinaData = vacinaData;
    }
}
