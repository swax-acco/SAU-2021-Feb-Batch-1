package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.repository.BookmyshowRepository;
import com.example.demo.model.Bookmyshow;

@RestController
@RequestMapping("/bookMyShow")
public class BookmyshowController {

	
	@Autowired
	BookmyshowRepository bookmyshowRepository;
	
	@PostMapping("/add")
	public ResponseEntity<Bookmyshow> addMovie(@RequestBody Bookmyshow movie)
	{
		return new ResponseEntity<>(bookmyshowRepository.save(movie), HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Bookmyshow>> getMovies()
	{
		List<Bookmyshow> movies = new ArrayList<>();
		bookmyshowRepository.findAll().forEach(movies::add);
		return new ResponseEntity<>(movies, HttpStatus.OK);
	}
	@GetMapping("findBy/{id}")
	public ResponseEntity<Bookmyshow> getmovie(@PathVariable String id)
	{
		return new ResponseEntity<>(bookmyshowRepository.findById(id).get(), HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteMovie(@PathVariable String id)
	{
		bookmyshowRepository.deleteById(id);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}
	
	@GetMapping("findByName/{name}")
	public ResponseEntity<List<Bookmyshow>> getMovieByName(@PathVariable String name)
	{
		List<Bookmyshow> movies = new ArrayList<>();
		bookmyshowRepository.findAllByMovieName(name).forEach(movies::add);
		return new ResponseEntity<>(movies, HttpStatus.OK);
	}
	
	@GetMapping("findByCity/{city}")
	public ResponseEntity<List<Bookmyshow>> getMovieByCity(@PathVariable String city)
	{
		List<Bookmyshow> movies = new ArrayList<>();
		bookmyshowRepository.findAllByMovieCity(city).forEach(movies::add);
		return new ResponseEntity<>(movies, HttpStatus.OK);
	}

}
