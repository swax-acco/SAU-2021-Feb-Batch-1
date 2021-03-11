package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.example.demo.model.FootballPlayer;
import com.example.demo.repository.FootballPlayerRepository;

@RestController
@RequestMapping("/football")
public class FootballPlayerController {
	
	@Autowired
	FootballPlayerRepository footballPlayerRepository;
	
	@GetMapping("/all")
	public ResponseEntity<List<FootballPlayer>> getPlayers()
	{
		List<FootballPlayer> players = new ArrayList<>();
		footballPlayerRepository.findAll().forEach(players::add);
		return new ResponseEntity<>(players, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<FootballPlayer> addPlayer(@RequestBody FootballPlayer player)
	{
		return new ResponseEntity<>(footballPlayerRepository.save(player), HttpStatus.OK);
	}
	
	@GetMapping("/findBy/{id}")
	public ResponseEntity<FootballPlayer> getPlayer(@PathVariable String id)
	{
		return new ResponseEntity<>(footballPlayerRepository.findById(id).get(), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePlayer(@PathVariable String id)
	{
		footballPlayerRepository.deleteById(id);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}
	
	@GetMapping("/goalsGreaterThanTen")
	public ResponseEntity<List<FootballPlayer>> getPlayersGoalsGreaterThanTen()
	{
		return new ResponseEntity<>(footballPlayerRepository.findByGoalsGreater10("com.example.demo.model.FootballPlayer"), HttpStatus.OK);
	}
}
