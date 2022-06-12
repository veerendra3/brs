package com.wipro.velocity.brs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wipro.velocity.brs.model.Routes;

public interface RouteRepository extends JpaRepository<Routes,Long>{
	
//	public Routes findByRoute(String route);
	
	List<Routes> findTop5ByOrderByUseCountDesc();
	
	@Query(value="Select * From routes WHERE source=?1 AND destination=?2",
			nativeQuery=true)
	Routes findRoute(String source, String destination);
	
	
	@Query(value="Select DISTINCT source FROM routes",
			nativeQuery=true)
	List<String> findSources();
	
	@Query(value="Select DISTINCT destination FROM routes",
			nativeQuery=true)
	List<String> findDestinations();
}

