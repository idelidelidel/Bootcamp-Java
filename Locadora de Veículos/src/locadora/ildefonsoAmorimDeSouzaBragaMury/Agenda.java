package locadora.ildefonsoAmorimDeSouzaBragaMury;

public class Agenda {

	private int motoDias,carroDias,caminhaoDias,OnibusDias,totalDias;

	public int getMotoDias() {
		return motoDias;
	}

	public void setMotoDias(int motoDias) {
		this.motoDias += motoDias;
	}

	public int getCarroDias() {
		return carroDias;
	}

	public void setCarroDias(int carro) {
		this.carroDias += carro;
	}

	public int getCaminhaoDias() {
		return caminhaoDias;
	}

	public void setCaminhaoDias(int caminhaoDias) {
		this.caminhaoDias += caminhaoDias;
	}

	public int getOnibusDias() {
		return OnibusDias;
	}

	public void setOnibusDias(int onibusDias) {
		OnibusDias += onibusDias;
	}

	public int getTotalDias() {
		return totalDias;
	}

	public void setTotalDias(int totalDias) {
		this.totalDias += totalDias;
	}
	
	
}
