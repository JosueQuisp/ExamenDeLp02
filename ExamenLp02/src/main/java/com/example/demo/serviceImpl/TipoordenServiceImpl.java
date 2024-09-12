package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Tipoorden;
import com.example.demo.repository.TipoordenRepository;
import com.example.demo.service.TipoordenService;

@Service

public class TipoordenServiceImpl implements TipoordenService{
	
	@Autowired
	private TipoordenRepository repository; 

	@Override
	public Tipoorden create(Tipoorden c) {
		// TODO Auto-generated method stub
		return repository.save(c);
	}

	@Override
	public Tipoorden update(Tipoorden c) {
		// TODO Auto-generated method stub
		return repository.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public Optional<Tipoorden> read(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public List<Tipoorden> readAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
}
