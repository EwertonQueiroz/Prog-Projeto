package padrao;

public class Medico extends Pessoa {
	private int crm;
	
	public Medico(String nome, String dataNasc, int cpf, int crm) {
		super(nome, dataNasc, cpf);
		this.crm = crm;
	}
	
	public int getCRM () {
		return this.crm;
	}
	
	public void setCRM (int crm) {
		this.crm = crm;
	}
	
	public String toString () {
		return "[Nome: " + this.getNome() + ", Data de Nascimento: " + this.getDataNasc() + ", CPF: " + this.getCPF() + ", CRM: " + this.getCPF() + "]";
	}

}
