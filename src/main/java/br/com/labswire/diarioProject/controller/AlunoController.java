package br.com.labswire.diarioProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.labswire.diarioProject.entity.Aluno;
import br.com.labswire.diarioProject.repository.AlunoRepository;

/**
 * @author jpereira
 *
 */
@RestController
public class AlunoController {

	@Autowired
	AlunoRepository repository;

	@RequestMapping(value = "/aluno", method = RequestMethod.GET)
	public List<Aluno> list() {
		return repository.findAll();
	}

	@RequestMapping(value = "/aluno", method = RequestMethod.POST)
	public Aluno save(@RequestBody Aluno aluno) {
		return repository.save(aluno);
	}

	@RequestMapping(value = "/aluno", method = RequestMethod.PUT)
	public Aluno edit(@RequestBody Aluno aluno) {
		return repository.save(aluno);
	}

	@RequestMapping(value = "/aluno/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String id) {
		repository.delete(id);
	}

}
