package com.spring.br.ProjectSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.br.ProjectSpring.entity.Usuario;
import com.spring.br.ProjectSpring.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> findAll() {
		return ResponseEntity.ok(usuarioService.findAll());
	}

	@GetMapping(path = "/name", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> findByName(@RequestParam(value = "name", required = false) String name) {
		return ResponseEntity.ok(usuarioService.findByName(name));
	}

	@GetMapping(path = "/email", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> findByName(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "email", required = false) String email) {
		return ResponseEntity.ok(usuarioService.findByNameAndEmail(name, email));
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity saveCandidate(@RequestBody Usuario candidate) {
		if (candidate.getName() == null) {
			return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
		}
		usuarioService.save(candidate);
		return ResponseEntity.ok().build();
	}
}
