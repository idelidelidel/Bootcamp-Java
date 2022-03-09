package locadora.ildefonsoAmorimDeSouzaBragaMury;

public class Caminhao extends Veiculo {

	public Caminhao(String marca, String modelo, int anoDeFabricacao, String placa, double ValorDaDiaria, double valorAvaliado, int carga) {
        super(marca, modelo, anoDeFabricacao, placa, ValorDaDiaria, valorAvaliado);
        this.carga = carga;
        tipo = 3;
    }
	
	private int carga;
	
	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}
	
	

	
//	public void setTipo() {
//		tipo = 4;
//	}

	public void calculoDoSeguro() {
		valorDoSeguro = (getValorAvaliado()*0.08)/365;	
	}
	
	public void mudarValorDiaria(int n,double taxa) {
			if(n==4) {
				
			}
	}
	
}
