package locadora.ildefonsoAmorimDeSouzaBragaMury;

public abstract class Veiculo {

	// atributos da classe
	protected String marca, modelo, placa;

	protected int anoDeFabricacao, tipo;

	protected double valorDaDiaria, valorAvaliadoBem;

	// outros atributos
	protected double valorDoSeguro, valorDoAluguel;
	
	protected int dias;
	

	// métodos
	public Veiculo(String marca, String modelo, int anoDeFabricacao, String placa, double valorDaDiaria, double valorAvaliadoDoBem) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.valorDaDiaria = valorDaDiaria;
        this.valorAvaliadoBem = valorAvaliadoDoBem;
    }

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getAnoDeFabricacao() {
		return anoDeFabricacao;
	}

	public void setAnoDeFabricacao(int anoDeFabricacao) {
		this.anoDeFabricacao = anoDeFabricacao;
	}

	public int getTipo() {
		return tipo;
	}

	//public abstract void setTipo();

	public double getValorDiaria() {
		return valorDaDiaria;
	}

	public void setValorDiaria(double valorDaDiaria) {
		this.valorDaDiaria = valorDaDiaria;
	}

	public double getValorAvaliado() {
		return valorAvaliadoBem;
	}

	public void setValorAvaliadoBem(double valorAvaliadoBem) {
		this.valorAvaliadoBem = valorAvaliadoBem;
	}

	public double getValorDoSeguro() {
		return valorDoSeguro;
	}

	public abstract void calculoDoSeguro();

	public double getValorDoAluguel() {
		return valorDoAluguel;
	}

	public void calculoDoAluguel(int dias) {
		valorDoAluguel = ((getValorDiaria() + getValorDoSeguro()) * dias);
	}

	
	// mudanças nos objetos em si
	public void mudarValorDaDiaria(double taxa) {
		setValorDiaria(taxa * getValorDiaria() + getValorDiaria());
	}
	
	public void mudarValorAvaliadoDoBem(double taxa) {
		setValorAvaliadoBem(getValorAvaliado() - (taxa * getValorAvaliado()) );
	}
	
	public void setDias(int dias) {
		this.dias = dias;
	}
	
	public int getDias() {
		return dias;
	}

	// mudanças nas classes
	public abstract void mudarValorDiaria(int n, double taxa);

}
