package com.viceri.APIViceri.vrepository;


import com.viceri.APIViceri.vusu.APIUsu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface APIUsuRepository extends JpaRepository<APIUsu, Long> {

    @Query("SELECT s FROM APIUsu s WHERE s.email =?1")
    Optional<APIUsu> findAPIUsuByEmail(String email);
}
