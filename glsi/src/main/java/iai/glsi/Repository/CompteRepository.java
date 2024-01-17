package iai.glsi.Repository;

import iai.glsi.Model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
   @Query(value = "SELECT * FROM Compte c WHERE c.id_client = :idClient", nativeQuery = true)
   List<Compte> findByProprietaireId(@Param("idClient") long idClient);


}



