package com.example.demo.repo;

import com.example.demo.model.EmpsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpsRepo extends JpaRepository<EmpsModel,Integer> {

}
