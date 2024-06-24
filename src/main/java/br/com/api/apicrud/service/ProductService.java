package br.com.api.apicrud.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.api.apicrud.model.*;
import br.com.api.apicrud.repo.ProductRepo;
import java.util.List;
import java.util.Optional;


@Service
public class ProductService {
	@Autowired
	private ProductRepo ProductRepository;
	
	public ProductModel create(ProductModel obj) {
		return ProductRepository.save(obj);
	}
	
	public void deleteById(Long id) {
		if(id== null || id<=0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		ProductRepository.deleteById(id);
	}
	
	public ProductModel getId(Long id) {
		if(id== null || id<=0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		Optional<ProductModel> obj = ProductRepository.findById(id);
		 return obj.get();
	}
	

	public List<ProductModel> getAll(){
		return ProductRepository.findAll();
	}
	
	public ProductModel update(ProductModel obj) {
		Optional<ProductModel> newObj = ProductRepository.findById(obj.getId());
		updateProduct(newObj, obj);
		return ProductRepository.save(newObj.get());
	}
	
	private void updateProduct(Optional<ProductModel> newObj, ProductModel obj) {
	
			newObj.get().setNome(obj.getNome());
			newObj.get().setMarca(obj.getMarca());
			newObj.get().setPreco(obj.getPreco());
	
	}
	

}
