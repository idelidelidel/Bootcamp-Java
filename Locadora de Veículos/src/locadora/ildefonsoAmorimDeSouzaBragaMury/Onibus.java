package locadora.ildefonsoAmorimDeSouzaBragaMury;

public class Onibus extends Veiculo {

	public Onibus(String marca, String modelo, int anoDeFabricacao, String placa, double ValorDaDiaria, double valorAvaliado, int capacidade) {
        super(marca, modelo, anoDeFabricacao, placa, ValorDaDiaria, valorAvaliado);
        this.capacidade = capacidade;
        tipo = 4;
    }
	
	private int capacidade;
	
	public int getCapacidade() {
		return capacidade;
	}
	
//	public void setTipo() {
//		tipo = 3;
//	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public void calculoDoSeguro() {
		valorDoSeguro = (getValorAvaliado()*0.2)/365;	
	}
		
	public void mudarValorDiaria(int n,double taxa) {
			if(n==3) {
				
			}
	}
	
}
