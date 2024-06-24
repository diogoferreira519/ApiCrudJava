package br.com.api.apicrud.controller;
import br.com.api.apicrud.model.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.api.apicrud.service.*;


@RestController
@RequestMapping("/produtos")
public class ProductController {
    @Autowired
    private ProductService service;
    
    @PostMapping()
    public ResponseEntity<ProductModel> create(@RequestBody ProductModel obj) {
         if (obj == null || obj.getNome() == null || obj.getNome().isEmpty()) {
             throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto inválido: nome não pode ser nulo ou vazio");
         }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductModel> getId(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.getId(id));
    }
    
    @GetMapping
    public ResponseEntity<List<ProductModel>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }
    
    @PutMapping(value ="/{id}")
    public ResponseEntity<ProductModel> update(@PathVariable Long id, @RequestBody ProductModel obj) {
        obj.setId(id);
        return ResponseEntity.ok().body(service.update(obj));
    }
}

	

	
	


