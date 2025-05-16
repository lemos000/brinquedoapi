package br.com.fiap.vmteste.services;

import br.com.fiap.vmteste.domain.Brinquedo;
import br.com.fiap.vmteste.repository.BrinquedoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BrinquedoService {

    @Autowired
    private BrinquedoRepo brinquedoRepo;

    public List<Brinquedo> findAll() {
        return brinquedoRepo.findAll();
    }

    public Brinquedo findById(int id) {
        return brinquedoRepo.findById(id).orElseGet(() -> null);
    }

    public Brinquedo save(Brinquedo livro) {
        return brinquedoRepo.save(livro);
    }

    public void deleteById(int id) {
        brinquedoRepo.deleteById(id);
    }
}