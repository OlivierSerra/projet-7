package com.nnk.springboot.services;

import com.nnk.springboot.domain.BidList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * service pour la gestion des entités - opérations fondamentales pour la ggestion du CRUD
 * - intermédiaire entre controller et repository
 */
public interface BidListService {
    List<BidList> findAll(); // récupère l'ens des BidLost de la BDD
    BidList findById(Integer id);// recherche les BIdList identifiées par leur ID
    BidList save(BidList bid); // enr une nouvelle bidList
    BidList update(Integer id, BidList bid); //MAJ une bidList
    void deleteById(Integer id); //suppr une bidList en fonction de son ID
}
