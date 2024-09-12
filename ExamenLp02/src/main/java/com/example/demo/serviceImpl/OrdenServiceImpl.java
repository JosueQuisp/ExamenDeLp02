package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Orden;
import com.example.demo.repository.OrdenRepository;
import com.example.demo.service.OrdenService;

@Service

public class OrdenServiceImpl implements OrdenService{
    
	@Autowired
	private OrdenRepository ordenRepository; 
	
	@Override
	public Orden create(Orden c) {
		// TODO Auto-generated method stub
		return ordenRepository.save(c);
	}

	@Override
	public Orden update(Orden c) {
		// TODO Auto-generated method stub
		return ordenRepository.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		ordenRepository.deleteById(id);
	}

	@Override
	public Optional<Orden> read(Long id) {
		// TODO Auto-generated method stub
		return ordenRepository.findById(id);
	}

	@Override
	public List<Orden> readAll() {
		// TODO Auto-generated method stub
		return ordenRepository.findAll();
	}

}
