package com.spring.br.ProjectSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.br.ProjectSpring.entity.Usuario;
import com.spring.br.ProjectSpring.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> findByName(String name) {
		return usuarioRepository.findByNameContainingIgnoreCase(name);
	}

	public List<Usuario> findByNameAndEmail(String name, String email) {
		List<Usuario> listByNameAndEmail = usuarioRepository.findByNameAndEmail(name, email);
		if (listByNameAndEmail.isEmpty()) {
			Usuario newCandidate = new Usuario();
			newCandidate.setName("Renata");
			newCandidate.setEmail("renata@gmail.com");
			listByNameAndEmail.add(newCandidate);
			return listByNameAndEmail;
		}
		return listByNameAndEmail;
	}

	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioRepository.findAll();
	}

	public void save(Usuario candidate) {
		usuarioRepository.save(candidate);
	}
}
