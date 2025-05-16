package br.com.fiap.brinquedoapi.operacao.controller;

import br.com.fiap.brinquedoapi.operacao.domain.Brinquedo;
import br.com.fiap.brinquedoapi.operacao.services.BrinquedoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brinquedos")
public class BrinquedoController {

    @Autowired
    private BrinquedoService brinquedoService;

    @GetMapping
    public List<Brinquedo> getAllBrinquedos() {
        return brinquedoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brinquedo> getBrinquedoById(@PathVariable int id) {
        Brinquedo brinquedo = brinquedoService.findById(id);
        if (brinquedo != null) {
            return ResponseEntity.ok(brinquedo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Brinquedo createBrinquedo(@RequestBody Brinquedo brinquedo) {
        return brinquedoService.save(brinquedo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brinquedo> updateBrinquedo(@PathVariable int id, @RequestBody Brinquedo brinquedoDetails) {
        Brinquedo brinquedo = brinquedoService.findById(id);
        if (brinquedo != null) {
            brinquedo.setNome(brinquedoDetails.getNome());
            brinquedo.setTipo(brinquedoDetails.getTipo());
            brinquedo.setClassificacao(brinquedoDetails.getClassificacao());
            brinquedo.setTamanho(brinquedoDetails.getTamanho());
            brinquedo.setPreco(brinquedoDetails.getPreco());
            return ResponseEntity.ok(brinquedoService.save(brinquedo));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrinquedo(@PathVariable int id) {
        Brinquedo brinquedo = brinquedoService.findById(id);
        if (brinquedo != null) {
            brinquedoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
