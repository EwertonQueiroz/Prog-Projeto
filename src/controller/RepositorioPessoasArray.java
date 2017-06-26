package controller;

import java.util.ArrayList;

import model.Pessoa;

public class RepositorioPessoasArray implements RepositorioPessoas {
	
	private ArrayList<Pessoa> pessoas;
	
	public RepositorioPessoasArray () {
		this.pessoas = new ArrayList<Pessoa>();
	}
	
	@Override
	public void cadastrar (Pessoa paciente) {
		if (paciente != null)
			this.pessoas.add(paciente);
		else
			System.out.println("Paciente inválido.");
	}

	@Override
	public Pessoa procurar (int cpf) {
		Pessoa aux = null;
		
		for (int i = 0; i < this.pessoas.size(); i++) {
			if (this.pessoas.get(i).getCPF() == cpf) {
				aux = this.pessoas.get(i);
				break;
			}
		}
		
		return aux;
	}

	@Override
	public void remover (int cpf) {
		for (int i = 0; i < this.pessoas.size(); i++) {
			if (this.pessoas.get(i).getCPF() == cpf) {
				this.pessoas.remove(i);
				break;
			}
		}
	}

	@Override
	public void atualizar (Pessoa paciente) {
		if (this.pessoas.contains(paciente)) {
			this.remover(paciente.getCPF());
			this.cadastrar(paciente);
		}
	}

	@Override
	public boolean existe (int cpf) {
		boolean result = false;
		
		for (int i = 0; i < this.pessoas.size(); i++) {
			if (this.pessoas.get(i).getCPF() == cpf) {
				result = true;
				break;
			}
		}
		
		return result;
	}
	
	public String toString () {
		StringBuilder s = new StringBuilder(); 
		
		s.append("Repositório Pessoas Array:\n\t[");
		
		for (int i = 0; i < this.pessoas.size(); i++) {
			s.append(this.pessoas.get(i).toString());
			
			if (i < this.pessoas.size() - 1)
				s.append(", ");
		}
		
		s.append("]");
		
		return s.toString();
	}

}
