package br.itau.agenda.model;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity  // esta classe será aramzenada no BD
@Table(name = "itmn032_agencia") // nome da tabela no BD
@Getter @Setter @NoArgsConstructor

public class Agencia {

@Id // esta campo é chave primaria
@GeneratedValue(strategy = GenerationType.IDENTITY) // 1, 2, 3, 4...
@Column(name = "id")
private int id;

@Column(name = "nome_agencia", length = 100, nullable = false)
private String nome_agencia;

@Column(name = "hora_inicio")
private int hora_inicio;

@Column(name = "hora_fim")
private int hora_fim;

@OneToMany(mappedBy = "agencia")
@JsonIgnoreProperties("agencia")
private List<Agendamento> agendamentos;

}
