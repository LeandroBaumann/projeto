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

    // ???????
    //public Agendamento findByNome(String nome); - Cliente
    @PostMapping("/nome")
    public ResponseEntity<List<Agendamento>> findByNomeCli(@RequestBody Agendamento agendamento) {
        List<Agendamento> lista = dao.findByNomeCli(agendamento.getNomeCli());
        if(lista != null){
            return ResponseEntity.ok(lista);
        }
        return ResponseEntity.notFound().build();
    }

    // ???????
    //public Agendamento findByData(String data); - Data
    @PostMapping("/data")
    public ResponseEntity<List<Agendamento>> findByDataAgendamento(@RequestBody Agendamento agendamento) {
        List<Agendamento> lista = dao.findByDataAgendamento(agendamento.getDataAgendamento());
        if(lista != null){
            return ResponseEntity.ok(lista);
        }
        return ResponseEntity.notFound().build();
    }
 
    //public Agendamento findByAgencia(String agencia); - Agencia
    @PostMapping("/agencia")
    public ResponseEntity<List<Agendamento>> findByAgencia(@RequestBody Agendamento agendamento){
        List<Agendamento> lista = dao.findByAgencia(agendamento.getAgencia());
        if(lista != null){
            return ResponseEntity.ok(lista);
        }
        return ResponseEntity.notFound().build();
    }

    // Agencia Data
    @PostMapping("/agenciadata")
    public ResponseEntity<List<Agendamento>> findByAgenciaAndDataAgendamento(@RequestBody Agendamento agendamento){
        List<Agendamento> lista = dao.findByAgenciaAndDataAgendamento(agendamento.getAgencia(), agendamento.getDataAgendamento());
        if(lista != null){
            return ResponseEntity.ok(lista);
        }
        return ResponseEntity.notFound().build();
    }
    
    //Agencia Cliente
    @PostMapping("/agencianome")
    public ResponseEntity<List<Agendamento>> findByAgenciaAndNomeCli(@RequestBody Agendamento agendamento){
        List<Agendamento> lista = dao.findByAgenciaAndNomeCli(agendamento.getAgencia(), agendamento.getNomeCli());
        if(lista != null){
            return ResponseEntity.ok(lista);
        }
        return ResponseEntity.notFound().build();
    }

    //Cliente Data
    @PostMapping("/nomedata")
    public ResponseEntity<List<Agendamento>> findByNomeCliAndDataAgendamento(@RequestBody Agendamento agendamento){
        List<Agendamento> lista = dao.findByNomeCliAndDataAgendamento(agendamento.getNomeCli(), agendamento.getDataAgendamento());
        if(lista != null){
            return ResponseEntity.ok(lista);
        }
        return ResponseEntity.notFound().build();
    }

    //Cliente Agencia Data
    @PostMapping("/nomedataagencia")
    public ResponseEntity<List<Agendamento>> findByNomeCliAndDataAgendamentoAndAgencia(@RequestBody Agendamento agendamento){
        List<Agendamento> lista = dao.findByNomeCliAndDataAgendamentoAndAgencia(agendamento.getNomeCli(), agendamento.getDataAgendamento(), agendamento.getAgencia());
        if(lista != null){
            return ResponseEntity.ok(lista);
        }
        return ResponseEntity.notFound().build();
    }
}