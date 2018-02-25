package br.com.labswire.example;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jpereira
 *
 */
@RestController
public class IndexController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "teste de index controller";
	}

	// com parametro
	@RequestMapping(value = "/nome/{nome}", method = RequestMethod.GET)
	public String index(@PathVariable String nome) {
		return "teste de index controller Path variable " + nome;
	}

}
