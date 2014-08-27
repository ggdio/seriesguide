package br.com.devteam.sguide.repository;

import javax.persistence.EntityManagerFactory;

import org.springframework.stereotype.Repository;

import br.com.devteam.sguide.model.Usuario;
import br.com.devteam.sguide.mvc.repository.AbstractRepository;

/**
 * Usuario Repository
 * @author rm69232
 *
 */
@Repository
public class UsuarioRepository extends AbstractRepository<Usuario> {

	public UsuarioRepository(EntityManagerFactory factory) {
		super(factory);
	}

}
