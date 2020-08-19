package com.teamG.TeamG.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.teamG.TeamG.model.Products;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Products, Integer> {

}
