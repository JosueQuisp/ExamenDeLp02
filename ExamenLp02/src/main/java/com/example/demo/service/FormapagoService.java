package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Formapago;

public interface FormapagoService {
	
	Formapago create(Formapago c); 
	Formapago update(Formapago c); 
    void delete(Long id); 
    Optional<Formapago> read(Long id );
    List<Formapago> readAll(); 

}
