
public class Cliente {

	//Atributos
	private String nome,dataDeNascimento;
	private int cpf;

	//Metodo construtor
			public Cliente(String nome,String dataDeNascimento, int cpf) {
				this.nome = nome;
				this.dataDeNascimento = dataDeNascimento;
				this.cpf = cpf;	
			}
			
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
	
}
