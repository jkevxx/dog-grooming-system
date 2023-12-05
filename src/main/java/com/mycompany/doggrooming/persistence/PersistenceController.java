package com.mycompany.doggrooming.persistence;

import com.mycompany.doggrooming.logic.Owner;
import com.mycompany.doggrooming.logic.Pet;
import com.mycompany.doggrooming.persistence.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mr_Paez
 */
public class PersistenceController {
    OwnerJpaController ownerJpa = new OwnerJpaController();
    PetJpaController petJpa = new PetJpaController();

    public void saveOwnerPet(Owner owner, Pet pet) {
        ownerJpa.create(owner);
        petJpa.create(pet);
    }

    public List<Pet> getPetList() {
        return petJpa.findPetEntities();
    }

    public void removePet(int client_num) {
        try {
            petJpa.destroy(client_num);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
