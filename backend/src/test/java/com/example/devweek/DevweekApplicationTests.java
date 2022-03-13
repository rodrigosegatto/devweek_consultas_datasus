package com.example.devweek;

import com.example.devweek.Controller.ControllerRegiao;
import com.example.devweek.Entity.Regiao;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.*;
import java.util.Random;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DevweekApplicationTests {

	private final String URL="/api/regiao";

	@Autowired
	MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ControllerRegiao controller;

	//Listar os objetos
	@Test
	public void getControllerTest() throws Exception{
		mockMvc.perform(get(URL))
				.andExpect(status().isOk()
				);
	}

	//Listar os objetos por Id
	@Test
	public void getByIdControllerTest() throws Exception{
		mockMvc.perform(get(URL+"/1"))
				.andExpect(status().isOk()
				);
	}

	//Adicionar Nova Região
	@Test
	public void addNewRegiaoTest() throws Exception{
		Regiao newRegiao = new Regiao("Noroeste", 57L);
		newRegiao.setId(new Random().nextLong());
		mockMvc.perform(post(URL+"/novo")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(newRegiao)))
				.andExpect(status().isOk());
	}

	//Deletar Região
	@Test
	public void deleteByIdControllerTest() throws Exception{
		mockMvc.perform(delete(URL+"/delete/{id}","6")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	private static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
