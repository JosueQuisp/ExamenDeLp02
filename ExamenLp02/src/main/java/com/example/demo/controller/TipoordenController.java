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

import com.example.demo.entity.Tipoorden;
import com.example.demo.service.TipoordenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tipoordenes")

public class TipoordenController {
	
	
	@Autowired
	private TipoordenService tipoService; 
	
	@GetMapping
	public ResponseEntity<List<Tipoorden>> readAll(){
		try {
			List<Tipoorden> consulta= tipoService.readAll(); 
			if (consulta.isEmpty()) {
				return new  ResponseEntity<>(HttpStatus.NO_CONTENT); 
			}
			return new ResponseEntity<>(consulta, HttpStatus.OK); 
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	
	@PostMapping
	public ResponseEntity<Tipoorden> createtipo(@Valid @RequestBody Tipoorden c){
		try {
			Tipoorden conss= tipoService.create(c); 
			return new ResponseEntity<>(conss, HttpStatus.CREATED);  
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Tipoorden> gettipo(@PathVariable("id") Long id){
		Optional<Tipoorden> consul= tipoService.read(id); 
		return consul.map(vale -> new ResponseEntity<>(vale, HttpStatus.OK) )
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Tipoorden> updatetipo(@PathVariable("id") Long id, @Valid @RequestBody Tipoorden tis){
		 Optional<Tipoorden> existing = tipoService.read(id);
	        if (existing.isPresent()) {
	            tis.setId(id);
	            return new ResponseEntity<>(tipoService.update(tis), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletetipo(@PathVariable("id") Long id) {
        try {
            tipoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
