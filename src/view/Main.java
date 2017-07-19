package view;

import controller.Atendimento;
import controller.Dependente;
import controller.ExceptionPessoaCadastrada;
import controller.Fachada;
import controller.Medico;
import controller.Paciente;
import controller.Pessoa;

public class Main {

	public static void main(String[] args) {
		Fachada f = Fachada.getInstance();
		
		Pessoa medico0 = new Medico("M�dico 0", "12/05/1976", 1234567890, "medico0", "senha0", 654321);
		Pessoa medico1 = new Medico("M�dico 1", "20/09/1988", 987654321, "medico1", "senha1", 547684);
		
		Pessoa dependente0 = new Dependente("Dependente0", "15/06/1989", 1515154561);
		Pessoa dependente1 = new Dependente("Dependente1", "15/06/1989", 1515154561);
		
		Pessoa paciente0 = new Paciente("Paciente 0", "05/05/1965", 213543543, "paciente0", "senha0", "nd");
		Pessoa paciente1 = new Paciente("Paciente 1", "31/12/1951", 324542378, "paciente1", "senha1", "nd");
		
		Atendimento atendimento0 = new Atendimento(medico0, paciente0, "Emerg�ncia", "20/06/2017", "Sintoma", "Prontu�rio", "Receita");
		Atendimento atendimento1 = new Atendimento(medico1, paciente1, "Emerg�ncia", "20/06/2017", "Sintoma", "Prontu�rio", "Receita");
		Atendimento atendimento2 = new Atendimento(medico0, paciente1, "Emerg�ncia", "20/06/2017", "Sintoma", "Prontu�rio", "Receita");
		
		((Paciente) paciente0).adicionarDependente(dependente0);
		((Paciente) paciente0).adicionarDependente(dependente1);
		
//		System.out.println(paciente0);
//		System.out.println(medico0);
//		System.out.println(atendimento0);
//		System.out.println(atendimento1);
//		System.out.println(atendimento2);
		
		try {
			f.cadastrar(medico0);
			f.cadastrar(medico0);
			f.cadastrar(medico1);
			f.cadastrar(paciente0);
			f.cadastrar(paciente1);
		} catch (ExceptionPessoaCadastrada e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("A pessoa " + e.getNome() + " nascida em " + e.getDataNascimento() + " com o CPF " + e.getCPF() + " já está cadastrada.");
		}
		
		f.cadastrar(atendimento0);
		f.cadastrar(atendimento1);
		f.cadastrar(atendimento2);
//		f.cadastrar(dependente0);
//		f.cadastrar(dependente1);
		System.out.println("[ + ] Reposit�rio ap�s cadastros:\n\n" + f);
		
		medico1.setNome("M�dico 01");
		paciente0.setNome("Paciente 00");
		atendimento1.setMedico(medico1);
		atendimento1.setPaciente(paciente0);
		f.atualizar(atendimento1);
		System.out.println("\n\n[ + ] Reposit�rio ap�s atualiza��es:\n\n" + f);
		
		System.out.println("\n\n[ + ] Pesquisas:\nN�o existe -> " + f.pesquisarAtendimento(4)
							+ "\nExiste -> " + f.pesquisarAtendimento(2) + "\nExiste -> " + f.pesquisar(1234567890)
							+ "\nN�o Existe -> " + f.pesquisar(12343486));
		
		f.remover(987654321);
		f.removerAtendimento(1);
		
		System.out.println("\n\n[ + ] Reposit�rio ap�s remo��es:\n\n" + f);
		
	}

}
