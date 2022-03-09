package locadora.ildefonsoAmorimDeSouzaBragaMury;

public class Carro extends Veiculo {

	public Carro(String marca, String modelo, int anoDeFabricacao, String placa, double ValorDaDiaria, double valorAvaliado, int categoria) {
        super(marca, modelo, anoDeFabricacao, placa, ValorDaDiaria, valorAvaliado);
        this.categoria = categoria;
        tipo = 2;
    }
	
	private int categoria;
	
	public int getCategoria() {
		return categoria;
	}
	
//	public void setTipo() {
//		tipo = 2;
//	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public void calculoDoSeguro() {
		valorDoSeguro = (getValorAvaliado()*0.03)/365;	
	}
	
	public void mudarValorDiaria(int n,double taxa) {
			if(n==2) {
				
			}
	}
}
