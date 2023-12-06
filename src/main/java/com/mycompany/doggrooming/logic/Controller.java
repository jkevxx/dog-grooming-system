package com.mycompany.doggrooming.logic;

import com.mycompany.doggrooming.persistence.PersistenceController;
import java.util.List;

/**
 *
 * @author Mr_Paez
 */
public class Controller {
    PersistenceController persistenceController = new PersistenceController();

    public void saveRegister(String petName, String breed, String color, 
            String allergic, String specialAttention, String ownerName, 
            String ownerPhone, String observations) {
        
        Owner owner = new Owner();
        owner.setName(ownerName);
        owner.setOwnerPhone(ownerPhone);
        
        Pet pet = new Pet();
        pet.setName(petName);
        pet.setBreed(breed);
        pet.setColor(color);
        pet.setAllergic(allergic);
        pet.setSpecialAttention(specialAttention);
        pet.setObservations(observations);
        pet.setOneOwner(owner);
        
        persistenceController.saveOwnerPet(owner, pet);
    }

    public List<Pet> getPets() {
        return persistenceController.getPetList();
    }

    public void deletePet(int client_num) {
        persistenceController.removePet(client_num);
    }

    public Pet getPetByOwnerId(int client_num) {
        return persistenceController.getOnePet(client_num);
    }

    public void updatePet(Pet pet, String petName, String breed, 
            String color, String allergic, String specialAttention, 
            String observations, String ownerName, String ownerPhone) {
        
        pet.setName(petName);
        pet.setBreed(breed);
        pet.setColor(color);
        pet.setObservations(observations);
        pet.setSpecialAttention(specialAttention);
        pet.setAllergic(allergic);
        
        // modify Pet
        persistenceController.modifyPet(pet);
        
        // setting owner values
        Owner owner = this.searchOwner(pet.getOneOwner().getId_owner());
        owner.setName(ownerName);
        owner.setOwnerPhone(ownerPhone);
        
        this.updateOwner(owner);
    }

    private Owner searchOwner(int id_owner) {
        return persistenceController.getOwner(id_owner);
    }

    private void updateOwner(Owner owner) {
        persistenceController.modifyOwner(owner);
    }

}
