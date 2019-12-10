package ca.costsaver.repository;

import ca.costsaver.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface StoreRepository extends JpaRepository<Store, Integer> {

    List<Store> findByBrandId(Integer brandId);

}
