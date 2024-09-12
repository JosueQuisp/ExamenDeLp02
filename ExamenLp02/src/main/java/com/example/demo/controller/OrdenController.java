package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.Orden;
import com.example.demo.service.OrdenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ordenes")


public class OrdenController {
	
	@Autowired
	private OrdenService ordenService; 
	
	
	@GetMapping
	public ResponseEntity<List<Orden>> readAll(){
		try {
			List<Orden> ode= ordenService.readAll(); 
			if (ode.isEmpty()) {
				return new  ResponseEntity<>(HttpStatus.NO_CONTENT); 
			}
			return new ResponseEntity<>(ode, HttpStatus.OK); 
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	
	@PostMapping
	public ResponseEntity<Orden> createorden(@Valid @RequestBody Orden c){
		try {
			Orden conss= ordenService.create(c); 
			return new ResponseEntity<>(conss, HttpStatus.CREATED);  
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Orden> getorden(@PathVariable("id") Long id){
		Optional<Orden> consul= ordenService.read(id); 
		return consul.map(vale -> new ResponseEntity<>(vale, HttpStatus.OK) )
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Orden> updateorden(@PathVariable("id") Long id, @Valid @RequestBody Orden ordens){
		 Optional<Orden> existing = ordenService.read(id);
	        if (existing.isPresent()) {
	            ordens.setId(id);
	            return new ResponseEntity<>(ordenService.update(ordens), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	}
	
	
	@DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteorden(@PathVariable("id") Long id) {
        try {
            ordenService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	
	
    
	
	
	

}
