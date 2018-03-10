package br.com.labswire.diarioProject.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.labswire.diarioProject.entity.Modulo;
import br.com.labswire.diarioProject.entity.Pedido;
import br.com.labswire.diarioProject.entity.Usuario;
import br.com.labswire.diarioProject.repository.ModuloRepository;
import br.com.labswire.diarioProject.repository.PedidoRepository;
import br.com.labswire.diarioProject.repository.UsuarioRepository;

/**
 * @author jpereira
 *
 *         Carga inicial
 *
 */
@Component
public class CargaInicial implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	BCryptPasswordEncoder encoder;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	ModuloRepository moduloRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent e) {
		usuarioRepository.deleteAll();
		moduloRepository.deleteAll();
		pedidoRepository.deleteAll();

		List<Usuario> usuarios = usuarioRepository.findAll();
		if (usuarios.isEmpty()) {
			Usuario adminUser = new Usuario("admin", encoder.encode("123"));
			adminUser.addPerfil(br.com.labswire.enums.Perfil.ADMIN);
			usuarioRepository.save(adminUser);
			Usuario cliente = new Usuario("cliente", encoder.encode("123"));
			usuarioRepository.save(cliente);

			Pedido pedido1 = new Pedido("teste1");
			pedido1.setUsuario(cliente);
			pedidoRepository.save(pedido1);

			Pedido pedido2 = new Pedido("teste2");
			pedido1.setUsuario(adminUser);
			pedidoRepository.save(pedido2);

		}

		for (int i = 0; i < 8; i++) {
			Modulo modulo = new Modulo();
			modulo.setNome("teste" + i);
			moduloRepository.save(modulo);
		}

	}

	// private void criarAluno(String nome, String dataNascimento) throws
	// ParseException {
	// Aluno aluno = new Aluno();
	// aluno.setNome(nome);
	// SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
	// Date data = formato.parse(dataNascimento);
	// aluno.setDtNascimento(data);
	//
	// }

}
