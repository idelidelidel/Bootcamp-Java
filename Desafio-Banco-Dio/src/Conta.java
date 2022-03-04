
public abstract class Conta implements IConta{

	
	/* Atributos da classe
	 * protected serve para que sej possivel ver a variavel nas subclasses
	 * private é uma forma de controlar os atribuitos com isso, basta criar um
	 * método para acessar esses atributos. Assim o método criado segue as regras de
	 * negócios desejada.
	 */
	
	private static final int AGENCIA_CENTRAL = 1;
	private static int SEQUENCIA_CONTAS = 1 ;
	protected int agencia,numeroDaConta;
	protected double saldo;
	protected String extrato = "";
	protected Cliente cliente;
	
	//Metodo construtor
	public Conta(Cliente cliente) {
		this.agencia = AGENCIA_CENTRAL;
		this.numeroDaConta = SEQUENCIA_CONTAS++;
		this.cliente = cliente;
		this.extrato = "";
	}

	//Metodos da classe IConta
	
	@Override
	public void sacar(double valor) {
		if(valor <= getSaldo()) {
			saldo -= valor;
			extrato += "Saque: " + valor + ". Saldo: " + getSaldo() + ".\n";
		}
		else {
			System.out.println("Saldo insuficiente!");
			extrato += "Tentativa de Saque Inválida! Saldo Insuficiente!\n";
		}
	}

	@Override
	public void depositar(double valor) {
		if(valor>0) {
			saldo += valor;
			extrato += "Depósito: " + valor + ". Saldo: " + getSaldo() + ".\n";
		}
		else if(valor == 0){
			System.out.println("Não é possível depositar R$ 0.00 reais!");
		}
		else {
			System.out.println("Não é possível depositar valores negativos!");
		}
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor); 
		contaDestino.depositar(valor);
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumeroDaConta() {
		return numeroDaConta;
	}

	public double getSaldo() {
		return saldo;
	}
	

	public String getExtrato() {
		return extrato;
	}
	
	
}
