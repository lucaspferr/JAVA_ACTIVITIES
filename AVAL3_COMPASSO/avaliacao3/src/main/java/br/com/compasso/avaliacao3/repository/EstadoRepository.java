package br.com.compasso.avaliacao3.repository;

import br.com.compasso.avaliacao3.modelo.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    List<Estado> findByRegiao(String aregiao);
}
