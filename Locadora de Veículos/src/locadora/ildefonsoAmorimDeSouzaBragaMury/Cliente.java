package locadora.ildefonsoAmorimDeSouzaBragaMury;

public class Cliente {

	private int cpf;
	private String nome;

	public Cliente(String nome, int cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	
	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
