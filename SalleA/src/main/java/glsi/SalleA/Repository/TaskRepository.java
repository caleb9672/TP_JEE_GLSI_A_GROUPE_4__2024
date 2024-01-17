package glsi.SalleA.Repository;


import glsi.SalleA.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}



