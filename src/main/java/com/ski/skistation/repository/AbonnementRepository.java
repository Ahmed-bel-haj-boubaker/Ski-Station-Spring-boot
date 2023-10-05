package com.ski.skistation.repository;

import com.ski.skistation.entities.Abonnement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbonnementRepository extends CrudRepository<Abonnement,Long> {



}
