package br.com.dio.desafio.dominio;


public class Laboratorio extends Conteudo {

	
	private String nome;
	private  boolean projetoFeito = false;
	private Dev dev = new Dev();
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Dev getDev() {
		return dev;
	}

	public void setDev(Dev dev) {
		this.dev = dev;
	}

	public boolean isProjetoFeito() {
		return projetoFeito;
	} 

	public void setProjetoFeito(boolean projetoFeito, Dev dev, int x) {
		/*Condicoes para aceitar:
		 * Nao ter terminado os conteudos incritos (a variavel de controle garante
		 * que o dev iniciou pelo menos um curso)
		 * Uma cargo horaria minima para finalizar o projeto do laboratorio */
		if((dev.getConteudosInscritos().isEmpty() == true)
				&& (dev.cargiHorariaTotal() > x)
				&& (dev.isControle() == true))
			this.projetoFeito = projetoFeito;
	}

    
	@Override
    public double calcularXp() {
		if(isProjetoFeito() == true)	return XP_PADRAO * getCargaHoraria();
		else return 0;
    }
	
	@Override
    public String toString() {
        return "Nome do laboratório: " + getNome()
        		+ "\nNome do Dev: " + dev.getNome()
        		+ "\nProjeto Feito? " + isProjetoFeito();
    }
}
