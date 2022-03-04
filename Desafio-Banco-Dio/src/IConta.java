
public interface IConta {

	//Regras de negocio para as Contas
	
	void sacar(double valor); 
	
	void depositar(double valor);
	
	void transferir(double valor, IConta contaDestino);
	
	void imprimirExtrato();
}
