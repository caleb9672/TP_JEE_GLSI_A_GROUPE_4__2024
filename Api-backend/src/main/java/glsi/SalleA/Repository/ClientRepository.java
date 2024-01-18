package glsi.SalleA.Repository;


import glsi.SalleA.Model.Client;
import glsi.SalleA.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}


