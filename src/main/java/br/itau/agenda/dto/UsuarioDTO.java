package br.itau.agenda.dto;

import br.itau.agenda.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class UsuarioDTO {
    //private int id;
    private String email;
    private String linkfoto;
    //private String nome;
    private String racf;
    private String senha;

    public UsuarioDTO(Usuario usuario) {
      //  this.id = usuario.getId();
        this.email = usuario.getEmail();
        this.linkfoto = usuario.getLinkfoto();
      //  this.nome = usuario.getNome();
        this.racf = usuario.getRacf();
        this.senha = usuario.getSenha();
    }
    
}
