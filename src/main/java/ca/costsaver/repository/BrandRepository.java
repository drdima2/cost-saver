package ca.costsaver.repository;

import ca.costsaver.entity.Brand;
import ca.costsaver.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BrandRepository extends JpaRepository<Brand,Integer> {

}
