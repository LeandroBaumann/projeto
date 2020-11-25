package br.itau.agenda.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // esta classe será aramzenada no BD
@Table(name = "itmn032_agendamento") // nome da tabela no BD
@Getter
@Setter
@NoArgsConstructor

public class Agendamento {

    @Id // esta campo é chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1, 2, 3, 4...
    @Column(name = "num_seq")
    private int numSeq;

    @Column(name = "nome_cli", length = 100, nullable = false)
    private String nomeCli;

    @Column(name = "email_cli", length = 100, nullable = false)
    private String emailCli;

    @Column(name = "celular_cli", length = 20, nullable = false)
    private String celularCli;

    @Column(name = "data_agendamento")
    private LocalDate dataAgendamento;

    @Column(name = "hora_agendamento")
    private LocalTime horaAgendamento;

    @Column(name = "observacao", length = 255, nullable = false)
    private String observacao;

    // @Column(name = "id_agencia", nullable = false)
    // private int id_agencia;

    @ManyToOne
    @JoinColumn(name = "id_agencia")
    @JsonIgnoreProperties("agendamentos")
    private Agencia agencia;
}
