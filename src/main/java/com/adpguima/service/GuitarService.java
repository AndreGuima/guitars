package com.adpguima.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.adpguima.model.Guitar;
import com.adpguima.repository.GuitarRepository;

@Service
public class GuitarService {

	private static final Logger log = LoggerFactory.getLogger(GuitarService.class);

	@Autowired
	GuitarRepository guitarRepository;

	public List<Guitar> list() {
		return guitarRepository.findAll();
	}

	public Guitar add(Guitar guitarAdd) {

		log.info("New Guitar is created with id: {0} ", guitarAdd.getId());
		return guitarRepository.save(guitarAdd);
	}

	public void delete(long id) throws EmptyResultDataAccessException {
		guitarRepository.deleteById(id);
	}
}
