package br.com.labswire.diarioProject.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;

import br.com.labswire.diarioProject.entity.Arquivo;
import br.com.labswire.diarioProject.repository.ArquivoRepository;

/**
 * @author jpereira
 *
 */
@RestController
public class ArquivoController {

	@Autowired
	ArquivoRepository arquivoRepository;

	private final GridFsTemplate gridFsTemplate;

	@Autowired
	public ArquivoController(GridFsTemplate gridFsTemplate) {
		this.gridFsTemplate = gridFsTemplate;
	}

	@RequestMapping(value = "/arquivo", method = RequestMethod.POST)
	public String save(@RequestParam("file") MultipartFile file) throws IOException {

		DBObject metaData = new BasicDBObject();

		Arquivo arquivo = new Arquivo();

		arquivo.setDescricao(file.getOriginalFilename());
		arquivo.setTamanho(file.getSize());

		arquivoRepository.save(arquivo);

		metaData.put("idArquivo", arquivo.getId());

		// depois validar o content type , para validar a extensao do arquivo
		gridFsTemplate.store(file.getInputStream(), file.getOriginalFilename(), file.getContentType(), metaData).save();

		return "Deu certo!";
	}

	@RequestMapping(value = "/arquivo/{id}", method = RequestMethod.GET)
	public HttpEntity<byte[]> get(@PathVariable("id") String id) {
		try {

			Optional<GridFSDBFile> optionalCreated = loadById(id);
			if (optionalCreated.isPresent()) {
				GridFSDBFile created = optionalCreated.get();
				ByteArrayOutputStream os = new ByteArrayOutputStream();
				created.writeTo(os);
				HttpHeaders headers = new HttpHeaders();
				headers.add(HttpHeaders.CONTENT_TYPE, created.getContentType());
				return new HttpEntity<>(os.toByteArray(), headers);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (IOException e) {
			return new ResponseEntity<>(HttpStatus.IM_USED);
		}
	}

	@RequestMapping(value = "/arquivo", method = RequestMethod.GET)
	public List<Arquivo> list() {
		List<Arquivo> arquivos = arquivoRepository.findAll();
		// filtrando arquivo usando lambda do java 8
		return arquivos.stream().filter(p -> p.getTamanho() > 6000).collect(Collectors.toList());
	}

	private Optional<GridFSDBFile> loadById(String id) {
		GridFSDBFile file = gridFsTemplate.findOne(getMetaDataQuery(id));
		return Optional.ofNullable(file);
	}

	private static Query getMetaDataQuery(String id) {
		return Query.query(GridFsCriteria.whereMetaData("idArquivo").is(id));
	}

}