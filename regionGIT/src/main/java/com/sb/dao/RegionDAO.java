package com.sb.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sb.entities.Region;

@Repository
public interface RegionDAO extends CrudRepository<Region, Integer>{

}
