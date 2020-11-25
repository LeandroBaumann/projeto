package br.itau.agenda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity  // esta classe será aramzenada no BD
@Table(name = "itmn032_usuario") // nome da tabela no BD
@Getter @Setter @NoArgsConstructor

public class Usuario {
    
    @Id // esta campo é chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1, 2, 3, 4...
    @Column(name = "id")
    private int id;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "linkfoto", length = 200, nullable = true)
    private String linkfoto;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name="racf", length = 7, nullable = false)
    private String racf;

    @Column(name = "senha", length = 30, nullable = false)
    private String senha;

}
