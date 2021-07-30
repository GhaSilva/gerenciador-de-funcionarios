package br.com.ghabriel.spring.data.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.ghabriel.spring.data.orm.Cargo;

public interface CargoRepository extends CrudRepository<Cargo, Integer>{

}
