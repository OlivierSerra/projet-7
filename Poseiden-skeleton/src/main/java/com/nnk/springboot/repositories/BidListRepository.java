package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.BidList;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Assurer le lien avec la BDD - assure la gestion des entités et mie en place de ma gestion des opérations CRUD
 */

public interface BidListRepository extends JpaRepository<BidList, Integer> {

}
