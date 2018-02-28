package br.com.labswire.diarioProject.controller;

import static org.springframework.data.domain.Sort.Direction.ASC;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.labswire.diarioProject.entity.Usuario;
import br.com.labswire.diarioProject.repository.UsuarioRepository;

/**
 *
 * @author Nataniel Paiva <nataniel.paiva@gmail.com>
 */
@RestController
public class UsuarioController {

	@Autowired
	UsuarioRepository repository;

	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public List<Usuario> listUsuario() {
		return repository.findAll();
	}

	@RequestMapping(value = "/usuario/{nome}/like", method = RequestMethod.GET)
	public List<Usuario> listLike(@PathVariable String nome) {
		return repository.findByNomeLikeIgnoreCase(nome);
	}

	@RequestMapping(value = "/usuario/{nome}/full-text-search", method = RequestMethod.GET)
	public List<Usuario> listFullText(@PathVariable String nome) {
		Pageable pages = new PageRequest(0, 10, new Sort(new Order(ASC, "score")));

		TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny(nome);

		return repository.findAllBy(criteria, pages);
	}

	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public Usuario save(@RequestBody Usuario usuario) {
		return repository.save(usuario);
	}

	@RequestMapping(value = "/usuario", method = RequestMethod.PUT)
	public Usuario edit(@RequestBody Usuario usuario) {
		return repository.save(usuario);
	}

	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String id) {
		repository.delete(id);
	}

}
