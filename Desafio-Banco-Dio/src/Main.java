public class Main {

	public static void main(String[] args) {

		// Gerando o banco
		Banco banco = new Banco();

		/*
		 * Origina-se primeiros os clientes, para depois associar a sua conta e por fim
		 * fazer operações com outras contas do banco
		 */

		Cliente clienteJoao = new Cliente("João Carlos", "11/05/2000", 00001);
		Cliente clienteMaria = new Cliente("Maria Olinda", "06/02/1980", 00002);
		Cliente clienteLucas = new Cliente("Lucas", "23/11/1990", 00003);

		Conta contaJoao = new ContaCorrente(clienteJoao);
		
		Conta contaJoao1 = new ContaPoupanca(clienteJoao);

		Conta contaMaria = new ContaCorrente(clienteMaria);

		Conta contaLucas = new ContaPoupanca(clienteLucas);

		//Adicionando as contas no banco
		banco.getContas().add(contaJoao);
		banco.getContas().add(contaJoao1);
		banco.getContas().add(contaMaria);
		banco.getContas().add(contaLucas);
		
		//Mostrando os valores setados
		
		for (Conta contas : banco.getContas()) {
			System.out.println("Nome do cliente: " +contas.getCliente().getNome());
			System.out.println("Data de nascimento: " +contas.getCliente().getDataDeNascimento());
			System.out.println("CPF: " +contas.getCliente().getCpf());
			System.out.println("Numero da agência: "+contas.getAgencia());
			System.out.println("Numero da conta: "+contas.getNumeroDaConta());
			if(contas instanceof ContaCorrente) {
				System.out.println("Conta Corrente: " +((ContaCorrente) contas).isContaCorrente());
			}
			else {
				System.out.println("Conta Poupanca: " + ((ContaPoupanca) contas).isContaPoupanca());
			}
			System.out.println();
		}
		
	//	banco.getContas().get(0).
		//Operacoes de deposito
		
		for (Conta contas : banco.getContas()) {
			contas.depositar(100.0);
		}
		
		//Operacoes de saques 
		
		for (Conta contas: banco.getContas()) {
			contas.sacar(50);
		}
		
		//Operacoes de transferencia
		
		//Joao transferindo da conta corrente para poupanca
		banco.getContas().get(0).transferir(25,contaJoao1);
		
		//Lucas transferindo da sua conta poupanca para a conta corrente de Maria
		banco.getContas().get(3).transferir(50,contaMaria);
		
		//O resultado de todas as operacoes
		for (Conta contas : banco.getContas()) {
			contas.imprimirExtrato();
		}
	}	
}
