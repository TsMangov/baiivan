package deploy.deploytest.repository;

import deploy.deploytest.model.entities.PismoDen;
import deploy.deploytest.model.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PismoDenRepository extends JpaRepository<PismoDen, Long> {



}
