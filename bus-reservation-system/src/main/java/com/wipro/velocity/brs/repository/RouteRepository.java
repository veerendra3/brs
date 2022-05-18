package com.wipro.velocity.brs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.velocity.brs.model.Routes;

public interface RouteRepository extends JpaRepository<Routes,Long>{
	
	public Routes findByRoute(String route);
	
	List<Routes> findTop5ByOrderByUseCountDesc();
	
	
}
