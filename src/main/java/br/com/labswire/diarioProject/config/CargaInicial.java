package br.com.labswire.diarioProject.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.labswire.diarioProject.entity.Aluno;
import br.com.labswire.diarioProject.entity.Modulo;
import br.com.labswire.diarioProject.entity.Usuario;
import br.com.labswire.diarioProject.repository.PerfilRepository;
import br.com.labswire.diarioProject.repository.UsuarioRepository;
import br.com.labswire.security.Perfil;

/**
 * @author jpereira
 *
 *         Carga inicial
 *
 */
@Component
public class CargaInicial implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	PerfilRepository perfilRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent e) {
		List<Perfil> perfis = perfilRepository.findAll();

		if (perfis.isEmpty()) {
			perfilRepository.save(new Perfil("ROLE_ADMIN"));

			Perfil perfil = perfilRepository.findByNome("ROLE_ADMIN");

			List<Perfil> perfisUsuario = new ArrayList<>();

			perfisUsuario.add(perfil);

			usuarioRepository.save(new Usuario("admin", perfisUsuario, "123"));
		}

	}

	private void criarModulo(String nome) {
		Modulo modulo = new Modulo();

		modulo.setNome(nome);

	}

	private void criarAluno(String nome, String dataNascimento) throws ParseException {
		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date data = formato.parse(dataNascimento);
		aluno.setDtNascimento(data);

	}

}
