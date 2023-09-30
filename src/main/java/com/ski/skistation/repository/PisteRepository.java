package com.ski.skistation.repository;

import com.ski.skistation.entities.Piste;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PisteRepository extends CrudRepository<Piste,Long> {



}
