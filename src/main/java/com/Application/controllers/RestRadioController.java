package com.Application.controllers;

import java.util.List;
import java.util.Random;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Application.model.Radio;
import com.Application.repositories.RadioRepository;

//Here a will serve the Rest-type endpoints for the Radio data

//default route is root /
@RestController
public class RestRadioController {

	//RestRadioController HAS-A RadioRepository
	//is final so once assigned it cant change
	private final RadioRepository radioRepo;
	
	//constructor to wire the Repository
	public RestRadioController(RadioRepository radioRepo) {
		super();
		this.radioRepo = radioRepo;
	}



	//getMapping for retrieve all the Radios from the db
	@GetMapping("/api/radios")
	public ResponseEntity<List<Radio>> allRadios(){
		
		//create a random number to not return always the data fine
		//this is for testing. now i want production config
		
		/*
		 
		 
		Random rand = new Random();
		int randInt = rand.nextInt(100);
		System.out.println("random int is: "+randInt);
		//if even return the data, otherwise return a message
		if (randInt%2==0) {
			List<Radio> radios = radioRepo.findAll();
			return ResponseEntity.status(HttpStatus.ACCEPTED)
							.header("Custom-header", "custom")
							.body(radios);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								.header("Error finding the radios", "not found error")
								.build();  //build with no body
		}
		*/
		
		List<Radio> radios = radioRepo.findAll();
		return ResponseEntity.status(HttpStatus.ACCEPTED)
						.header("Custom-header", "custom")
						.body(radios);
		

	}
	
	
	
	
	
}
