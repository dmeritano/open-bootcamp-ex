package com.dmeritano.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmeritano.spring.entities.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long>{

	public List<Laptop> findByBrand(String brand);
	
}
