package com.adpguima.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.adpguima.exception.GuitarNotFoundException;
import com.adpguima.model.Guitar;
import com.adpguima.service.GuitarService;

@RestController
@RequestMapping("/guitars")
public class GuitarController {

	@Autowired
	GuitarService guitarService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Guitar> findAll() {
		List<Guitar> guitarList = guitarService.list();
		return guitarList;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Guitar save(@RequestBody Guitar guitar) {
		return guitarService.add(guitar);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		try {
			guitarService.delete(id);
		} catch (EmptyResultDataAccessException ex) {
			throw new GuitarNotFoundException("Guitar not found in the database with id: " + id);
		}
	}
}