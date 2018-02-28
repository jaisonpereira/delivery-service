package br.com.labswire.diarioProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.labswire.diarioProject.entity.Modulo;
import br.com.labswire.diarioProject.repository.ModuloRepository;

/**
 * @author jpereira
 *
 */
@RestController
public class ModuloController {

	@Autowired
	ModuloRepository repository;

	@RequestMapping(value = "/modulo", method = RequestMethod.GET)
	public List<Modulo> list() {
		return repository.findAll();
	}

	@RequestMapping(value = "/modulo", method = RequestMethod.POST)
	public Modulo save(@RequestBody Modulo modulo) {
		return repository.save(modulo);
	}

	@RequestMapping(value = "/modulo", method = RequestMethod.PUT)
	public Modulo edit(@RequestBody Modulo modulo) {
		return repository.save(modulo);
	}

	@RequestMapping(value = "/modulo/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String id) {
		repository.delete(id);
	}

}
