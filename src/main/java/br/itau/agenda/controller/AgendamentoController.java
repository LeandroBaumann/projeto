package br.itau.agenda.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import br.itau.agenda.dao.AgendamentoDAO;
import br.itau.agenda.dto.AgendamentoDTO;
import br.itau.agenda.model.Agendamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@RestController
@CrossOrigin("*")
@RequestMapping("/agendamento")

@Getter @Setter @AllArgsConstructor
public class AgendamentoController {

    @Autowired // injeção de dependência
    private AgendamentoDAO dao;

    // Inserir novo agendamento
    @PostMapping("/new")
    public ResponseEntity<Agendamento> inserirAgendamento(@RequestBody Agendamento agendamento){
        Agendamento newAgendamento = dao.save(agendamento);
        return ResponseEntity.ok(newAgendamento);
    }

    // Recupera todos agendamentos
    @GetMapping("/all")
    public List<Agendamento> listarTodos(){
        List<Agendamento> lista = (List<Agendamento>) dao.findAll();
        return lista;
    }

    // public Agendamento findByEmail(String email);
    @PostMapping("/email")
    public ResponseEntity<AgendamentoDTO> buscarPorEmail(@RequestBody Agendamento agendamento){
        Agendamento userFinded = dao.findByEmailCli(agendamento.getEmailCli());
        if(userFinded != null){
            AgendamentoDTO agendamentoDto = new AgendamentoDTO(userFinded);
            return ResponseEntity.ok(agendamentoDto);
        }
        return ResponseEntity.notFound().build();
    }

    //public Agendamento findByNome(String nome);
    @PostMapping("/nome")
    public ResponseEntity<AgendamentoDTO> buscarPorNome(@RequestBody Agendamento agendamento){
        Agendamento userFinded = dao.findByNomeCli(agendamento.getNomeCli());
        if(userFinded != null){
            AgendamentoDTO agendamentoDto = new AgendamentoDTO(userFinded);
            return ResponseEntity.ok(agendamentoDto);
        }
        return ResponseEntity.notFound().build();
    }

    //public Agendamento findByTelefone(String telefone);
    @PostMapping("/celular")
    public ResponseEntity<AgendamentoDTO> buscarPorCelular(@RequestBody Agendamento agendamento){
        Agendamento userFinded = dao.findByCelularCli(agendamento.getCelularCli());
        if(userFinded != null){
            AgendamentoDTO agendamentoDto = new AgendamentoDTO(userFinded);
            return ResponseEntity.ok(agendamentoDto);
        }
        return ResponseEntity.notFound().build();
    }
    
    //public Agendamento findByData(String data);
    @PostMapping("/data")
    public ResponseEntity<AgendamentoDTO> findByDataAgendamento(@RequestBody Agendamento agendamento){
        Agendamento userFinded = dao.findByDataAgendamento(agendamento.getDataAgendamento());
        if(userFinded != null){
            AgendamentoDTO agendamentoDto = new AgendamentoDTO(userFinded);
            return ResponseEntity.ok(agendamentoDto);
        }
        return ResponseEntity.notFound().build();
    }




    //public Agendamento findByAgencia(String agencia);
}