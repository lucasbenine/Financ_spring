package com.example.projetospring.controller;

import com.example.projetospring.model.ContasAReceber;
import com.example.projetospring.repository.ContasAReceberRepository;
import com.example.projetospring.service.ContasAReceberService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

    // estou ficando doido
    @RestController
    @RequestMapping("/contasareceber")
    public class ContasAReceberController {

        @Autowired
        private ContasAReceberService service;

        @Autowired
        private ContasAReceberRepository repository;

        @GetMapping
        public List<ContasAReceber> listaContas(){
            return repository.findAll();
        }

        @PostMapping
        public ResponseEntity<ContasAReceber> contasareceber (@RequestBody ContasAReceber contasareceber){
            contasareceber = service.inserir(contasareceber);
            return ResponseEntity.ok().body(contasareceber);
        }

        @PutMapping("/contasareceber/{Id}")
        public ResponseEntity<ContasAReceber> updateContas(
                @PathVariable(value = "Id") Long Id,
                @Valid @RequestBody ContasAReceber userDetails) throws ResourceNotFoundException {
            ContasAReceber contasareceber = ContasAReceberRepository.findById(Id)
                    .orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ Id));

            contasareceber.setId(userDetails.getId());
            contasareceber.setNomeConta(userDetails.getNomeConta());
            contasareceber.setValorConta(userDetails.getValorConta());
            contasareceber.setCategoria(userDetails.getCategoria());
            final ContasAReceber updateContas = ContasAReceberRepository.save(contasareceber);
            return ResponseEntity.ok(updateContas);
        }



        /*
        @DeleteMapping
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void excluir(@PathVariable Long Id){
            ContasAReceberRepository.deleteById(Id);
        }
*/

    }




