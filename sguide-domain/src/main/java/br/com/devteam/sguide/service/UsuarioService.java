package br.com.devteam.sguide.service;

import org.springframework.stereotype.Service;

import br.com.devteam.sguide.model.Usuario;
import br.com.devteam.sguide.mvc.repository.Repository;
import br.com.devteam.sguide.mvc.service.AbstractService;

/**
 * Usuario Service
 * @author rm69232
 *
 */
@Service
public class UsuarioService extends AbstractService<Usuario> {

	public UsuarioService(Repository<Usuario> repository) {
		super(repository);
	}

}
