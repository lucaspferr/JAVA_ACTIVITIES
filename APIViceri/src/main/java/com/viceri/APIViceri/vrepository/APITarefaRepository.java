package com.viceri.APIViceri.vrepository;

import com.viceri.APIViceri.vusu.APITarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface APITarefaRepository extends JpaRepository<APITarefa, Long> {


    @Query("SELECT a FROM APIUsu a WHERE a.id =?1")
    Optional<APITarefa> findById(Long id);
}
