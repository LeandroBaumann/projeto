package br.itau.agenda.dao;

import org.springframework.data.repository.CrudRepository;
import br.itau.agenda.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{
    public Usuario findByEmailOrRacf(String email, String racf);
    
}
