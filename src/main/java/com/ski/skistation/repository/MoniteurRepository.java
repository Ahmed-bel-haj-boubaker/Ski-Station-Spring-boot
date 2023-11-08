package com.ski.skistation.repository;

import com.ski.skistation.entities.Moniteur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MoniteurRepository extends CrudRepository<Moniteur,Long> {



}
