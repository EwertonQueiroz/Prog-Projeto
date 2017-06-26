package controller;

import java.util.ArrayList;

import model.Atendimento;

public class RepositorioAtendimentosArray implements RepositorioAtendimentos {

	private ArrayList<Atendimento> atendimentos;
	
	public RepositorioAtendimentosArray() {
		this.atendimentos = new ArrayList<Atendimento>();
	}
	
	@Override
	public void agendar (Atendimento atendimento) {
		if (atendimento != null)
			this.atendimentos.add(atendimento);
		else
			System.out.println("Atendimento inválido.");
	}

	@Override
	public Atendimento procurar (int id) {
		Atendimento aux = null;
		
		for (int i = 0; i < this.atendimentos.size(); i++) {
			if (this.atendimentos.get(i).getId() == id) {
				aux = this.atendimentos.get(i);
				break;
			}
		}
		
		return aux;
	}

	@Override
	public void remover (int id) {
		for (int i = 0; i < this.atendimentos.size(); i++) {
			if (this.atendimentos.get(i).getId() == id) {
				this.atendimentos.remove(i);
				break;
			}
		}
	}

	@Override
	public void atualizar (Atendimento atendimento) {
		if (this.atendimentos.contains(atendimento)) {
			this.remover(atendimento.getId());
			this.agendar(atendimento);
		}
	}

	@Override
	public boolean existe(int id) {
		boolean result = false;
		
		for (int i = 0; i < this.atendimentos.size(); i++) {
			if (this.atendimentos.get(i).getId() == id) {
				result = true;
				break;
			}
		}
		
		return result;
	}
	
	public String toString () {
		StringBuilder s = new StringBuilder(); 
		
		s.append("Repositório Atendimentos Array:\n\t[");
		
		for (int i = 0; i < this.atendimentos.size(); i++) {
			s.append(this.atendimentos.get(i).toString());
			
			if (i < this.atendimentos.size() - 1)
				s.append(", ");
		}
		
		s.append("]");
		
		return s.toString();
	}

}
