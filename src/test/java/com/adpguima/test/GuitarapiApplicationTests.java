package com.adpguima.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import com.adpguima.GuitarapiApplication;
import com.adpguima.test.utils.JsonLoader;

@SpringBootTest(classes = { GuitarapiApplication.class })
@RunWith(SpringRunner.class)
public class GuitarapiApplicationTests {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void getAllGuitarsTest() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/guitars").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$[0].id").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].brand").isNotEmpty());
	}

	@Test
	public void postGuitarTest() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.post("/guitars").content(JsonLoader.fromPath("Guitar/saveGuitar"))
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andExpect(status().isCreated())
				.andExpect(jsonPath("$.model", equalTo("Telecaster Custom 2")))
				.andExpect(jsonPath("$.brand", equalTo("Squier Fender")));
	}

	@Test
	public void postGuitarShouldReturnBadRequestTest() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.post("/guitars").accept(MediaType.APPLICATION_JSON).param("name",
				"New Guitar Name")).andExpect(status().isBadRequest());
	}

	@Test
	public void deleteGuitarTest() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.delete("/guitars/1").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isNoContent());
	}

	@Test
	public void deleteGuitarShouldReturnNotFoundTest() throws Exception {

		mockMvc.perform(
				MockMvcRequestBuilders.delete("/guitars/101").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isNotFound());
	}

}
