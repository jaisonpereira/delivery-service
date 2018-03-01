package br.com.labswire.diarioProject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.labswire.security.Perfil;

public interface PerfilRepository extends MongoRepository<Perfil, String> {

	Perfil findByNome(String role_admin);

}