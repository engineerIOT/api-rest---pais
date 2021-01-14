package com.pais.apirest.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pais.apirest.models.Pais;
import com.pais.apirest.repository.PaisRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value="/api")
@Api(value="API REST Pais")
@CrossOrigin(origins="*")
public class PaisResource {

	@Autowired
	PaisRepository paisRepository;
	
	@GetMapping("/pais")
	@ApiOperation(value="Retorna uma lista de paises")
	public List <Pais> listaPaises(){
		return paisRepository.findAll();
	}
	
	@GetMapping("/pais/{id}")
	@ApiOperation(value="Retorna um pais unicos")
	public Pais listaPaisUnico(@PathVariable(value="id") long id){
		return paisRepository.findById(id);
	}
	
	@PostMapping("/pais")
	@ApiOperation(value="Salva um pais")
	public Pais salvarPais(@RequestBody Pais pais) {
		return paisRepository.save(pais);
	}
	
	@DeleteMapping("/pais")
	@ApiOperation(value="Deleta um pais")
	public void deletaPais(@RequestBody Pais pais) {
		paisRepository.delete(pais);
	}
	
	@PutMapping("/pais")
	@ApiOperation(value="Atualiza um pais")
	public Pais atualizaPais(@RequestBody Pais pais) {
		return paisRepository.save(pais);
	}
	
	
	
}
