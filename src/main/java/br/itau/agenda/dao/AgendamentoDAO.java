package br.itau.agenda.dao;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import br.itau.agenda.model.Agencia;
import br.itau.agenda.model.Agendamento;


public interface AgendamentoDAO extends CrudRepository<Agendamento, Integer> {
    //Recuperara agendamentos com filtros independentes
    public List<Agendamento> findByNomeCli(String nomeCli); 
    public List<Agendamento> findByDataAgendamento(LocalDate localDate);
    public List<Agendamento> findByAgencia(Agencia agencia);
    public List<Agendamento> findByAgenciaAndDataAgendamento(Agencia agencia, LocalDate dataAgendamento);
    public List<Agendamento> findByAgenciaAndNomeCli(Agencia agencia, String nomeCli);
    public List<Agendamento> findByNomeCliAndDataAgendamento(String nomeCli, LocalDate dataAgendamento);
    public List<Agendamento> findByNomeCliAndDataAgendamentoAndAgencia(String nomeCli, LocalDate dataAgendamento, Agencia agencia);

      
}
