package model;

import java.util.ArrayList;

import controller.Atendimento;
import controller.ExceptionAtendimentoCadastrado;
import controller.ExceptionAtendimentoNaoEncontrado;

public class RepositorioAtendimentosArray implements RepositorioAtendimentos {

	private ArrayList<Atendimento> atendimentos;
	
	public RepositorioAtendimentosArray() {
		this.atendimentos = new ArrayList<Atendimento>();
	}
	
	@Override
	public void agendar (Atendimento atendimento) throws ExceptionAtendimentoCadastrado {
		this.atendimentos.add(atendimento);
	}

	@Override
	public Atendimento procurar (int id) throws ExceptionAtendimentoNaoEncontrado {
		Atendimento aux = null;
		
		for (int i = 0; i < this.atendimentos.size(); i++) {
			if (this.atendimentos.get(i).getCod() == id) {
				aux = this.atendimentos.get(i);
				break;
			}
		}
		
		if (aux !=  null)
			return aux;
		else {
			ExceptionAtendimentoNaoEncontrado e = new ExceptionAtendimentoNaoEncontrado(id);
			throw e;
		}
	}

	@Override
	public void remover (int id) throws ExceptionAtendimentoNaoEncontrado {
		for (int i = 0; i < this.atendimentos.size(); i++) {
			if (this.atendimentos.get(i).getCod() == id) {
				this.atendimentos.remove(i);
				break;
			}
		
			else if (i == this.atendimentos.size()) {
				ExceptionAtendimentoNaoEncontrado e = new ExceptionAtendimentoNaoEncontrado(id);
				throw e;
			}
		}
	}

	@Override
	public void atualizar (Atendimento atendimento) throws ExceptionAtendimentoNaoEncontrado {
		if (this.atendimentos.contains(atendimento)) {
			int aux = this.atendimentos.indexOf(atendimento);
			this.atendimentos.remove(atendimento);
			this.atendimentos.add(aux, atendimento);
		}
		
		else {
			ExceptionAtendimentoNaoEncontrado e = new ExceptionAtendimentoNaoEncontrado(atendimento.getCod(), atendimento.getPaciente(), atendimento.getMedico(), atendimento.getDataAtendimento());
		}
	}

	@Override
	public boolean existe(int id) {
		boolean result = false;
		
		for (int i = 0; i < this.atendimentos.size(); i++) {
			if (this.atendimentos.get(i).getCod() == id) {
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
				s.append(",\n\t");
		}
		
		s.append("]");
		
		return s.toString();
	}

}
