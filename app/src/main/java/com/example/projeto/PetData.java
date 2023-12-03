package com.example.projeto;

public class PetData {
    private String petName;
    private String petType;
    private String petPort;
    private String petAge;

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public void setPetPort(String petPort) {
        this.petPort = petPort;
    }

    public void setPetAge(String petAge) {
        this.petAge = petAge;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    private Integer petId;

    public String getPetName() {
        return petName;
    }

    public String getPetType() {
        return petType;
    }

    public String getPetPort() {
        return petPort;
    }

    public String getPetAge() {
        return petAge;
    }


    public PetData(Integer petId, String petName, String petType, String petPort, String petAge) {
        this.petId = petId;
        this.petName = petName;
        this.petType = petType;
        this.petPort = petPort;
        this.petAge = petAge;
    }

    public PetData(){

    }
}
