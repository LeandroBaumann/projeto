package br.itau.agenda.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import br.itau.agenda.model.Agendamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class AgendamentoDTO {
    
	private int numSeq;
    private String nomeCli;
    private String emailCli;
    private String celularCli;
    private LocalDate dataAgendamento;
    private LocalTime horaAgendamento;
    private String observacao;
    // private int id_agencia;
    
    public AgendamentoDTO(Agendamento agendamento) {
        this.numSeq = agendamento.getNumSeq();
        this.nomeCli = agendamento.getNomeCli();
        this.emailCli = agendamento.getEmailCli();
        this.celularCli = agendamento.getCelularCli();
        this.dataAgendamento = agendamento.getDataAgendamento();
        this.horaAgendamento = agendamento.getHoraAgendamento();
        this.observacao = agendamento.getObservacao();
    }

    
}
