package com.Application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Application.model.Radio;

@Repository
public interface RadioRepository extends JpaRepository<Radio, Long>{

}
