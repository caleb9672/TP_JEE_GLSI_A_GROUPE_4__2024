package glsi.SalleA.Repository;
import glsi.SalleA.Model.DbUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DbUserRepository extends JpaRepository<DbUser, Integer> {
    public DbUser findByUsername(String username);
}
