package br.com.labswire.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jpereira
 *
 */
@RestController
public class UserController {

	@Autowired
	UserRepository repository;

	// com parametro
	@RequestMapping(value = "/user/salvar", method = RequestMethod.POST)
	public User saveUser(@RequestBody User user) {
		return repository.save(user);
	}

	// MESMO METODO COM PUT
	@RequestMapping(value = "/user/salvar", method = RequestMethod.PUT)
	public User saveUserPut(@RequestBody User user) {
		return repository.save(user);
	}

	// UTILIZANDO DELETE
	// alterar para ler somente o id
	@RequestMapping(value = "/user/excluir", method = RequestMethod.DELETE)
	public String excluirUser(@RequestBody User user) {
		try {
			repository.delete(user.getId());
			return "User " + user.getId() + " deletado com sucesso";
		} catch (Exception e) {
			return "Erro ao deletar " + e.getMessage();
		}
	}

	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	public List<User> list() {
		return repository.findAll();
	}

}
