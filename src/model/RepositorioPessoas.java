package model;

import java.util.ArrayList;

import controller.Dependente;
import controller.ExceptionPessoaCadastrada;
import controller.ExceptionPessoaNaoEncontrada;
import controller.Paciente;
import controller.Pessoa;

public interface RepositorioPessoas {
	
	public void cadastrar (Pessoa pessoa) throws ExceptionPessoaCadastrada;
	
	public void cadastrarDependente (Paciente titular, Dependente dependente) throws ExceptionPessoaCadastrada, ExceptionPessoaNaoEncontrada;
	
	public Pessoa procurar (String cpf) throws ExceptionPessoaNaoEncontrada;
	
	public ArrayList<Pessoa> listarPessoas ();
	
	public void remover (String cpf) throws ExceptionPessoaNaoEncontrada;
	
	public void atualizar (Pessoa pessoa) throws ExceptionPessoaCadastrada, ExceptionPessoaNaoEncontrada;
	
	public boolean existe (String cpf);

}
