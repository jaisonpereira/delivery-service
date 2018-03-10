package br.com.labswire.diarioProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.labswire.diarioProject.entity.Pedido;
import br.com.labswire.diarioProject.repository.PedidoRepository;
import br.com.labswire.service.PedidoService;

/**
 *
 * @author Nataniel Paiva <nataniel.paiva@gmail.com>
 */
@RestController
public class PedidoController {

	@Autowired
	PedidoRepository repository;

	@Autowired
	PedidoService service;

	@RequestMapping(value = "/pedido", method = RequestMethod.GET)
	public List<Pedido> listPedido() {
		return repository.findAll();
	}

	@GetMapping(value = "/page")
	public ResponseEntity<Page<Pedido>> listPagePedidoByUser(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "dataCadastro") String orderBy,
			@RequestParam(value = "direction", defaultValue = "DESC") String direction

	) throws Exception {
		Page<Pedido> list = service.findPagePerUsuario(page, linesPerPage, orderBy, direction);

		return ResponseEntity.ok().body(list);
	}

}
