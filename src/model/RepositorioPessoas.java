package controller;

import model.Pessoa;

public interface RepositorioPessoas {
	
	public void cadastrar (Pessoa paciente);
	
	public Pessoa procurar (int cpf);
	
	public void remover (int cpf);
	
	public void atualizar (Pessoa paciente);
	
	public boolean existe (int cpf);

}
