package locadora.ildefonsoAmorimDeSouzaBragaMury;

public class Aluguel {

	private Cliente c;
	private Veiculo v;
	private int tempo;
	private boolean alugado; 
	private double faturamento;
	private int dias;
	
	public void setDias(int dias) {
		this.dias = dias;
	}
	
	public int getDias() {
		return dias;
	}
	
	public void setFaturamento(double valor) {
		faturamento = faturamento + valor;
	}
	
	public double getFaturamento() {
		return faturamento;
	}
	
	
	public Cliente getC() {
		return c;
	}
	public void setC(Cliente c) {
		this.c = c;
	}
	public Veiculo getV() {
		return v;
	}
	public void setV(Veiculo v) {
		this.v = v;
	}
	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	
	public boolean getAlugado() {
		return alugado;
	}
	public void setAlugado(boolean alugado) {
		this.alugado = alugado;
	}
	
	
	public Aluguel(Cliente c, Veiculo v, int tempo, boolean alugado) {
		this.c = c;
		this.v = v;
		this.tempo = tempo;
		this.alugado = alugado;
	}
	
}
