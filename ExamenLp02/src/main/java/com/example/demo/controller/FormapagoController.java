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

import com.example.demo.entity.Formapago;
import com.example.demo.service.FormapagoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/formapagos")

public class FormapagoController {
	
	@Autowired
	private FormapagoService pagoService; 
	
	
	@GetMapping
	public ResponseEntity<List<Formapago>> readAll(){
		try {
			List<Formapago> pago= pagoService.readAll(); 
			if (pago.isEmpty()) {
				return new  ResponseEntity<>(HttpStatus.NO_CONTENT); 
			}
			return new ResponseEntity<>(pago, HttpStatus.OK); 
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	
	@PostMapping
	public ResponseEntity<Formapago> createformapago(@Valid @RequestBody Formapago c){
		try {
			Formapago conss= pagoService.create(c); 
			return new ResponseEntity<>(conss, HttpStatus.CREATED);  
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Formapago> getpago(@PathVariable("id") Long id){
		Optional<Formapago> consul= pagoService.read(id); 
		return consul.map(vale -> new ResponseEntity<>(vale, HttpStatus.OK) )
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Formapago> updatepago(@PathVariable("id") Long id, @Valid @RequestBody Formapago pag){
		 Optional<Formapago> existing = pagoService.read(id);
	        if (existing.isPresent()) {
	            pag.setId(id);
	            return new ResponseEntity<>(pagoService.update(pag), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	}
	
	

	@DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletepago(@PathVariable("id") Long id) {
        try {
            pagoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	
	
	
	

}
