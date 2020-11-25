package br.itau.agenda.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.itau.agenda.dao.AgenciaDAO;
import br.itau.agenda.model.Agencia;

@RestController
@CrossOrigin("*")
@RequestMapping("/agencia")
public class AgenciaController {

    @Autowired // injeção de dependência
    private AgenciaDAO dao;
    
    // recuperar agencias do sistema
    @GetMapping("/all")
    public List<Agencia> listarTodos(){
        List<Agencia> lista = (List<Agencia>) dao.findAll();
        return lista;
    }   
}