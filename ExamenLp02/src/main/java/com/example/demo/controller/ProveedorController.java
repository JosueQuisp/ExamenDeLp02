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

import com.example.demo.entity.Proveedor;
import com.example.demo.service.ProveedorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/proveedores")

public class ProveedorController {

	@Autowired
	private ProveedorService proveedorService; 
	
	@GetMapping
	public ResponseEntity<List<Proveedor>> readAll(){
		try {
			List<Proveedor> consulta= proveedorService.readAll(); 
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
	public ResponseEntity<Proveedor> createproveedores(@Valid @RequestBody Proveedor c){
		try {
			Proveedor conss= proveedorService.create(c); 
			return new ResponseEntity<>(conss, HttpStatus.CREATED);  
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Proveedor> getproveedores(@PathVariable("id") Long id){
		Optional<Proveedor> consul= proveedorService.read(id); 
		return consul.map(vale -> new ResponseEntity<>(vale, HttpStatus.OK) )
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Proveedor> updateproveedores(@PathVariable("id") Long id, @Valid @RequestBody Proveedor pro){
		 Optional<Proveedor> existing = proveedorService.read(id);
	        if (existing.isPresent()) {
	            pro.setId(id);
	            return new ResponseEntity<>(proveedorService.update(pro), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	}
	
	
	@DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteproveedores(@PathVariable("id") Long id) {
        try {
            proveedorService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	
}
