package com.ski.skistation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ski.skistation.entities.Cours;
import java.util.List;
@Repository

public interface CoursRepository extends CrudRepository<Cours,String> {

    List<Cours> retrieveAllCourses();

    Cours addCours(Cours cours);

    Cours updateCours(Cours cours);

    Cours retrieveCours(Long numCours);



}
