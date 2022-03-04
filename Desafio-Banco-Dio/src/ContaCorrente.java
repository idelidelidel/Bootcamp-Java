public class ContaCorrente extends Conta {

	private boolean contaCorrente = true;
	
	public ContaCorrente(Cliente cliente) {
		super(cliente);
		this.contaCorrente = true;
	}

	public boolean isContaCorrente() {
		return contaCorrente;
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		System.out.println("Nome: " + ContaCorrente.this.getCliente().getNome());
		System.out.println(ContaCorrente.this.getExtrato());
	}
	
}