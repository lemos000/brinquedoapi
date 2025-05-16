package br.com.fiap.vmteste.repository;

import br.com.fiap.vmteste.domain.Brinquedo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrinquedoRepo extends JpaRepository<Brinquedo, Integer> {

}
