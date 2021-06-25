package deploy.deploytest.repository;

import deploy.deploytest.model.entities.AnalizDen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnalizDenRepository extends JpaRepository<AnalizDen, Long> {
    List<AnalizDen> findAllByPismoDen_Id(Long id);
}
