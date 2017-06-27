package model;

import controller.Atendimento;

public interface RepositorioAtendimentos {

	public void agendar (Atendimento atendimento);
	
	public Atendimento procurar (int id);
	
	public void remover (int id);
	
	public void atualizar (Atendimento atendimento);
	
	public boolean existe (int id);
}
