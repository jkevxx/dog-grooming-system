package com.mycompany.doggrooming.persistence;

import com.mycompany.doggrooming.logic.Owner;
import com.mycompany.doggrooming.logic.Pet;

/**
 *
 * @author Mr_Paez
 */
public class PersistenceController {
    OwnerJpaController ownerJpa = new OwnerJpaController();
    PetJpaController petJpa = new PetJpaController();

    public void save(Owner owner, Pet pet) {
        ownerJpa.create(owner);
        petJpa.create(pet);
    }
}
