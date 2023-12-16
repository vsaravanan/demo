package com.govtech.demo.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;



public abstract class AService<T, IPK, R extends JpaRepository<T, IPK>>    {

    @Autowired
    private R repo;

    public Iterable<T> findAll () {

        return repo.findAll();

    }


}


