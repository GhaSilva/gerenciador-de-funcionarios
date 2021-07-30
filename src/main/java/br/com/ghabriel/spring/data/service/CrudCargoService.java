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
			
			int action = scanner.nextInt();
			if(action == 1) {
				salvar(scanner);
			}
			if(action == 2) {
				atualizar(scanner);
			}
			else {
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
}
