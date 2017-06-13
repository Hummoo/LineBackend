package com.example.demo.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.LineGroup;

@Repository
public interface LineGroupRepository extends CrudRepository<LineGroup, Serializable> {
	
}
