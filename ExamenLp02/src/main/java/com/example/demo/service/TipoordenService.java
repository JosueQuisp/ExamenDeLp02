package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Tipoorden;

public interface TipoordenService {
	
	Tipoorden create(Tipoorden c); 
	Tipoorden update(Tipoorden c); 
    void delete(Long id); 
    Optional<Tipoorden> read(Long id );
    List<Tipoorden> readAll(); 
	
	
}
