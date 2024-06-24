package br.com.api.apicrud.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.apicrud.model.ProductModel;

public interface ProductRepo extends JpaRepository<ProductModel, Long> {
	
}
