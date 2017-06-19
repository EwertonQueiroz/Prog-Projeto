package padrao;

public class Main {

	public static void main(String[] args) {
		Pessoa medico = new Medico("Médico 1", "12/05/1976", 1234567890, 654321);
		
		Pessoa dependente0 = new Dependente("Dependente0", "15/06/1989", 1515154561);
		Pessoa dependente1 = new Dependente("Dependente1", "15/06/1989", 1515154561);
		
		Cliente cliente = new Cliente("Cliente", "05/05/1965", 213543543, "Particular");
		
		cliente.adicionarDependente(dependente0);
		cliente.adicionarDependente(dependente1);
		
		System.out.println(cliente);
		
	}

}
