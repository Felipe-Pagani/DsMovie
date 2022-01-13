package com.desuperior.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desuperior.dsmovie.dto.MovieDTO;
import com.desuperior.dsmovie.service.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieControllers { 

	@Autowired
	private MovieService service;

	@GetMapping
	public Page<MovieDTO> findAllPaged(Pageable pageable) {
		return service.findAllPaged(pageable);
	}
	
	@GetMapping(value = "/{id}")
	public MovieDTO findById(@PathVariable Long id) {
		return service.findById(id);
		
		
	}
	
}