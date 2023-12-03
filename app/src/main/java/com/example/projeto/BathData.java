package com.example.projeto;

public class BathData {
    private String petEscolha;
    private String typeService;
    private String serviceData;
    private String servico;
    public String getPetEscolha() {
        return petEscolha;
    }

    public void setPetEscolha(String petEscolha) {
        this.petEscolha = petEscolha;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    public String getServiceData() {
        return serviceData;
    }

    public void setServiceData(String serviceData) {
        this.serviceData = serviceData;
    }

    public BathData(String petEscolha, String typeService, String serviceData, String servico) {
        this.petEscolha = petEscolha;
        this.typeService = typeService;
        this.serviceData = serviceData;
        this.servico = servico;
    }
}
