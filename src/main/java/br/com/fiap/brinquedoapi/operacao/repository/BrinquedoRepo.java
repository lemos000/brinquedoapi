package br.com.fiap.brinquedoapi.operacao.repository;

import br.com.fiap.brinquedoapi.operacao.domain.Brinquedo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrinquedoRepo extends JpaRepository<Brinquedo, Integer> {

}
