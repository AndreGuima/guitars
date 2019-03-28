package com.adpguima;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.adpguima.model.Guitar;
import com.adpguima.service.GuitarService;

@Component
public class GuitarRepositoryCommandLineRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(GuitarRepositoryCommandLineRunner.class);

	@Autowired
	private GuitarService guitarService;

	@Override
	public void run(String... args) throws Exception {
		Guitar guitar = new Guitar("Gibson", "Les Paul", new Date());
		guitarService.add(guitar);
		log.info("New Guitar is created with id : " + guitar.getId());

		guitar = new Guitar("Fender", "Stratocaster", new Date());
		guitarService.add(guitar);
		log.info("New Guitar is created with id : " + guitar.getId());

		guitar = new Guitar("Gibson", "SG", new Date());
		guitarService.add(guitar);
		log.info("New Guitar is created with id : " + guitar.getId());

		guitar = new Guitar("Jackson", "Strato", new Date());
		guitarService.add(guitar);
		log.info("New Guitar is created with id : " + guitar.getId());

		guitar = new Guitar("Epiphone", "Semi Acustica", new Date());
		guitarService.add(guitar);
		log.info("New Guitar is created with id : " + guitar.getId());
	}

}
