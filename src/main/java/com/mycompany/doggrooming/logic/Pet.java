package com.mycompany.doggrooming.logic;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Mr_Paez
 */
@Entity
public class Pet implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int num_Owner;
    private String name;
    private String breed;
    private String color;
    private String allergic;
    private String specialAttention;
    private String observations;
    
    @OneToOne
    private Owner oneOwner;

    public Pet() {
    }

    public Pet(int num_Owner, String name, String breed, String color, String allergic, String specialAttention, String observations, Owner oneOwner) {
        this.num_Owner = num_Owner;
        this.name = name;
        this.breed = breed;
        this.color = color;
        this.allergic = allergic;
        this.specialAttention = specialAttention;
        this.observations = observations;
        this.oneOwner = oneOwner;
    }

    public int getNum_Owner() {
        return num_Owner;
    }

    public void setNum_Owner(int num_Owner) {
        this.num_Owner = num_Owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAllergic() {
        return allergic;
    }

    public void setAllergic(String allergic) {
        this.allergic = allergic;
    }

    public String getSpecialAttention() {
        return specialAttention;
    }

    public void setSpecialAttention(String specialAttention) {
        this.specialAttention = specialAttention;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Owner getOneOwner() {
        return oneOwner;
    }

    public void setOneOwner(Owner oneOwner) {
        this.oneOwner = oneOwner;
    }
    
    
}
