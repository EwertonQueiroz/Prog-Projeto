package view;

import model.Atendimento;
import model.Dependente;
import model.Medico;
import model.Paciente;
import model.Pessoa;

public class Main {

	public static void main(String[] args) {
		Pessoa medico = new Medico("Médico 1", "12/05/1976", 1234567890, "medico1", "senha1", 654321);
		
		Pessoa dependente0 = new Dependente("Dependente0", "15/06/1989", 1515154561);
		Pessoa dependente1 = new Dependente("Dependente1", "15/06/1989", 1515154561);
		
		Pessoa paciente = new Paciente("Paciente 1", "05/05/1965", 213543543, "paciente1", "senha1", "nd");
		
		Atendimento atendimento = new Atendimento(medico, paciente, "Emergência", "20/06/2017", "Sintoma", "Prontuário", "Receita");
		
		((Paciente) paciente).adicionarDependente(dependente0);
		((Paciente) paciente).adicionarDependente(dependente1);
		
		System.out.println(paciente);
		System.out.println(medico);
		
	}

}
