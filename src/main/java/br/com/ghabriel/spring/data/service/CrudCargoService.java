package br.com.ghabriel.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.ghabriel.spring.data.orm.Cargo;
import br.com.ghabriel.spring.data.repository.CargoRepository;

@Service
public class CrudCargoService {
	private boolean system = true;
	
	private final CargoRepository cargoRepository;
	public CrudCargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}
	
	public void inicial(Scanner scanner) {
		while(system) {
			System.out.println("Qual ação você quer executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("2 - Vizualizar");
			
			int action = scanner.nextInt();
			switch (action) {
			case 1: 
				salvar(scanner);
				break;
			case 2:
				atualizar(scanner);
				break;
			case 3:
				vizualizar();
				break;
			default:
				system = false;
				break;
			}
		}
		
	}
	
	public void salvar(Scanner scanner) {
		System.out.println("Descrição do Cargo: ");
		String descricao = scanner.next();
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Salvo com Sucesso");
	}
	
	public void atualizar(Scanner scanner) {
		System.out.println("Id do Cargo");
		Integer id = scanner.nextInt();
		System.out.println("Nova descrição do Cargo");
		String descricao = scanner.next();


		Cargo cargo = new Cargo();
		cargo.setId(id);
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Atualizado com Sucesso");
	}
	
	public void vizualizar() {
		Iterable<Cargo> cargos = cargoRepository.findAll();
		for (Cargo cargo : cargos) {
			System.out.println(cargo);
		}
	}
	
}
