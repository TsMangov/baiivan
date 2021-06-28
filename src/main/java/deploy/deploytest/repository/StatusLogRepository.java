package deploy.deploytest.repository;

import deploy.deploytest.model.entities.StatusLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StatusLogRepository extends JpaRepository<StatusLog, Long> {

    List<StatusLog> findAllByAnalizDen_Id (Long analizId);
}