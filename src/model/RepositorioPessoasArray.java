package model;

import java.util.ArrayList;

import controller.Dependente;
import controller.ExceptionPessoaCadastrada;
import controller.ExceptionPessoaNaoEncontrada;
import controller.Paciente;
import controller.Pessoa;

public class RepositorioPessoasArray implements RepositorioPessoas {
	
	private ArrayList<Pessoa> pessoas;
	
	public RepositorioPessoasArray () {
		this.pessoas = new ArrayList<Pessoa>();
	}
	
	public ArrayList<Pessoa> getRepositorioPessoas () {
		return this.pessoas;
	}
	
	@Override
	public void cadastrar (Pessoa paciente) throws ExceptionPessoaCadastrada {
		this.pessoas.add(paciente);
	}
	
	@Override
	public void cadastrarDependente(Paciente titular, Dependente dependente) throws ExceptionPessoaCadastrada, ExceptionPessoaNaoEncontrada {
		Pessoa aux = this.procurar(titular.getCPF());
		
		if (aux == null) {
			ExceptionPessoaNaoEncontrada e = new ExceptionPessoaNaoEncontrada(titular.getCPF());
			throw e;
		}
		
		else
			((Paciente) aux).adicionarDependente(dependente);
	}

	@Override
	public Pessoa procurar (String cpf) throws ExceptionPessoaNaoEncontrada {
		Pessoa aux = null;
		
		for (int i = 0; i < this.pessoas.size(); i++) {
			if (this.pessoas.get(i).getCPF().equals(cpf)) {
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
	public void remover (String cpf) throws ExceptionPessoaNaoEncontrada {
		for (int i = 0; i < this.pessoas.size(); i++) {
			if (this.pessoas.get(i).getCPF().equals(cpf)) {
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
			ExceptionPessoaNaoEncontrada e = new ExceptionPessoaNaoEncontrada(paciente.getNome(), paciente.getCPF());
			throw e;
		}
	}

	@Override
	public boolean existe (String cpf) {
		boolean result = false;
		
		for (int i = 0; i < this.pessoas.size(); i++) {
			if (this.pessoas.get(i).getCPF().equals(cpf)) {
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
