package br.itau.agenda.dao;
import java.time.LocalDate;

import org.springframework.data.repository.CrudRepository;
import br.itau.agenda.model.Agendamento;



public interface AgendamentoDAO extends CrudRepository<Agendamento, Integer> {
    //Recuperara agendamentos com filtros independentes
    public Agendamento findByNomeCli(String nomeCli);
    public Agendamento findByEmailCli(String emailCli);
    public Agendamento findByCelularCli(String celularCli);
    //public Agendamento findByIdAgencia(String Agencia);
    public Agendamento findByDataAgendamento(LocalDate localDate);
    //public Agendamento findByData(String dataIni, String dataFim);
    public Agendamento findByHoraAgendamento(String horaAgendamento);
    //public Agendamento findByData(String horaIni, String horaFim);
      
}
