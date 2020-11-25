package br.itau.agenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itau.agenda.dao.UsuarioDAO;
import br.itau.agenda.dto.UsuarioDTO;
import br.itau.agenda.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")

@Getter @Setter @AllArgsConstructor
public class UsuarioController {

    @Autowired // injeção de dependência
    private UsuarioDAO dao;

    // login email/racf e senha
    @PostMapping("/login")
    public ResponseEntity<UsuarioDTO> login(@RequestBody Usuario usuario) {
        Usuario userFinded = dao.findByEmailOrRacf(usuario.getEmail(), usuario.getRacf());

        if (userFinded != null) {
            if (userFinded.getSenha().equals(usuario.getSenha())) {
                UsuarioDTO userDto = new UsuarioDTO(userFinded);
                return ResponseEntity.ok(userDto);
            }
            return ResponseEntity.status(401).build();
        }
        return ResponseEntity.status(401).build(); 
    }
}
