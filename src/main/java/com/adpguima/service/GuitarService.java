package com.adpguima.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adpguima.model.Guitar;
import com.adpguima.repository.GuitarRepository;

@Service
public class GuitarService {

	@Autowired
	GuitarRepository guitarRepository;

	public List<Guitar> list() {
		return guitarRepository.findAll();
	}

	public Guitar add(Guitar guitarAdd) {
		return guitarRepository.save(guitarAdd);
	}
}
