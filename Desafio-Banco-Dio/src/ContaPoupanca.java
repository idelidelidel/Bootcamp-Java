public class ContaPoupanca extends Conta {

	private boolean contaPoupanca = true;
	
	public ContaPoupanca(Cliente cliente) {
		super(cliente);
		this.contaPoupanca = true;
	}

	public boolean isContaPoupanca() {
		return contaPoupanca;
	}
	
	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Poupança ===");
		System.out.println("Nome: " + ContaPoupanca.this.getCliente().getNome());
		System.out.println(ContaPoupanca.this.getExtrato());
	}
}