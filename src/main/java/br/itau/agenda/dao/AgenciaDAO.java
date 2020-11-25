package br.itau.agenda.dao;
import org.springframework.data.repository.CrudRepository;
import br.itau.agenda.model.Agencia;

public interface AgenciaDAO extends CrudRepository<Agencia, Integer> {
    // recuperar Agencias do sistema

    
}
