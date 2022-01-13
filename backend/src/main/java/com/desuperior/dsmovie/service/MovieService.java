package com.desuperior.dsmovie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desuperior.dsmovie.dto.MovieDTO;
import com.desuperior.dsmovie.entities.Movie;
import com.desuperior.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;

	// findAll()
//	public List<MovieDTO> findAll(){
//		List<Movie> list = repository.findAll(Sort.by("name"));
//		return list.stream().map(x -> new MovieDTO(x)).collect(Collectors.toList());	
//	}
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAllPaged(Pageable pageable) {
		Page<Movie> page = repository.findAll(pageable);
		return page.map(x -> new MovieDTO(x));
	}
	
	public MovieDTO findById(Long id) {
		Movie entity = repository.findById(id).get();
		MovieDTO dto = new MovieDTO(entity);
		return dto;
	}

//	public MovieDTO insert(MovieDTO dto) {
//		Movie entity = new Movie();
//		entity.setTitle(dto.getTitle());
//		entity.setScore(dto.getScore());
//		entity.setCount(dto.getCount());
//		entity.setImage(dto.getImage());
//		entity = repository.save(entity);
//		return new MovieDTO(entity);
//	}

}
