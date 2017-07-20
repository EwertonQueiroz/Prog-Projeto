package model;

import java.util.ArrayList;

import controller.ExceptionPessoaCadastrada;
import controller.ExceptionPessoaNaoEncontrada;
import controller.Pessoa;

public class RepositorioPessoasArray implements RepositorioPessoas {
	
	private ArrayList<Pessoa> pessoas;
	
	public RepositorioPessoasArray () {
		this.pessoas = new ArrayList<Pessoa>();
	}
	
	@Override
	public void cadastrar (Pessoa paciente) throws ExceptionPessoaCadastrada {
		this.pessoas.add(paciente);
	}

	@Override
	public Pessoa procurar (int cpf) throws ExceptionPessoaNaoEncontrada {
		Pessoa aux = null;
		
		for (int i = 0; i < this.pessoas.size(); i++) {
			if (this.pessoas.get(i).getCPF() == cpf) {
				aux = this.pessoas.get(i);
				break;
			}
		}
		
		if (aux != null)
			return aux;
		
		else {
			ExceptionPessoaNaoEncontrada e = new ExceptionPessoaNaoEncontrada(cpf);
			throw e;
		}
	}

	@Override
	public void remover (int cpf) throws ExceptionPessoaNaoEncontrada {
		for (int i = 0; i < this.pessoas.size(); i++) {
			if (this.pessoas.get(i).getCPF() == cpf) {
				this.pessoas.remove(i);
				break;
			}
			
			else if (i == this.pessoas.size()) {
				ExceptionPessoaNaoEncontrada e = new ExceptionPessoaNaoEncontrada(cpf);
				throw e;
			}
		}
	}

	@Override
	public void atualizar (Pessoa paciente) throws ExceptionPessoaNaoEncontrada {
		if (this.pessoas.contains(paciente)) {
			int aux = this.pessoas.indexOf(paciente);
			this.pessoas.remove(paciente);
			this.pessoas.add(aux, paciente);
		}
		
		else {
			ExceptionPessoaNaoEncontrada e = new ExceptionPessoaNaoEncontrada(paciente.getNome(), paciente.getCPF(), paciente.getDataNasc());
			throw e;
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
		
		s.append("Reposit�rio Pessoas Array:\n\t[");
		
		for (int i = 0; i < this.pessoas.size(); i++) {
			s.append(this.pessoas.get(i).toString());
			
			if (i < this.pessoas.size() - 1)
				s.append(", ");
		}
		
		s.append("\n\t]");
		
		return s.toString();
	}

}
