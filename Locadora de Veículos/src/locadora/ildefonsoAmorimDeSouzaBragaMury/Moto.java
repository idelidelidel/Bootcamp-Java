package locadora.ildefonsoAmorimDeSouzaBragaMury;

public class Moto extends Veiculo {

	public Moto(String marca, String modelo, int anoDeFabricacao, String placa, double ValorDaDiaria, double valorAvaliado, int cilindrada) {
        super(marca, modelo, anoDeFabricacao, placa, ValorDaDiaria, valorAvaliado);
        this.cilindrada = cilindrada;
        tipo = 1;
    }

	private int cilindrada;

	public int getCilindrada() {
		return cilindrada;
	}

	//public void setCilindrada(int cilindrada) {
		///this.cilindrada = cilindrada;
	//}
	
	//public void setTipo() {
		//tipo = 1;
	//}

	public void calculoDoSeguro() {
		valorDoSeguro = (((getValorAvaliado() * 0.11)) / 365);
	}

	public void mudarValorDiaria(int n, double taxa) {
		if (n == 1) {
			
		}
	}
}
