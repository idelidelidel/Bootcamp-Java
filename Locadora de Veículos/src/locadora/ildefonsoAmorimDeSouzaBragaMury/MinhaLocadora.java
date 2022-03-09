package locadora.ildefonsoAmorimDeSouzaBragaMury;

import java.util.ArrayList;

public class MinhaLocadora implements InterfaceLocadora {

	private RepositorioDeVeiculos veiculos = new RepositorioDeVeiculos();
	private Cliente pessoa[] = new Cliente[50];
	private int cont = 0;
	private ArrayList<Aluguel> aluga = new ArrayList<Aluguel>();
	private Dinheiro carteira = new Dinheiro();
	private Agenda bloco = new Agenda();

	// private int cont2 = 0;

	public void inserir(Veiculo veiculo) throws VeiculoJaCadastrado {
		veiculos.inserirR(veiculo);
	}

	public void inserir(Cliente cliente) throws ClienteJaCadastrado {
		pesquisarCliente(cliente.getCpf());
		pessoa[cont++] = cliente;
	}

	public void pesquisarCliente(int cpf) throws ClienteJaCadastrado {
		for (int i = 0; i < cont; i++) {
			if (pessoa[i].getCpf() == cpf) {
				throw new ClienteJaCadastrado();
			}
		}
		// return pessoa[i];
		// return null;
	}

	public void pesquisarCliente2(int cpf) throws ClienteNaoCadastrado {
		for (int i = 0; i < cont; i++) {
			if (pessoa[i].getCpf() == cpf) {
				return;
			}
		}
		throw new ClienteNaoCadastrado();
		// return pessoa[i];
		// return null;
	}

	public Veiculo pesquisar(String placa) throws VeiculoNaoCadastrado {
		return veiculos.pesquisarR(placa);
	}

	public ArrayList<Veiculo> pesquisarMoto(int cilindrada) {
		ArrayList<Veiculo> moto = veiculos.pesquisarMotoR(cilindrada);
		return moto;
	}

	public ArrayList<Veiculo> pesquisarCarro(int categoria) {
		ArrayList<Veiculo> carro = veiculos.pesquisarCarroR(categoria);
		return carro;
	}

	public ArrayList<Veiculo> pesquisarCaminhao(int carga) {
		ArrayList<Veiculo> caminhao = veiculos.pesquisarCaminhaoR(carga);
		return caminhao;
	}

	public ArrayList<Veiculo> pesquisarOnibus(int capacidade) {
		ArrayList<Veiculo> onibus = veiculos.pesquisarOnibusR(capacidade);
		return onibus;
	}

	public double calcularAluguel(String placa, int dias) throws VeiculoNaoCadastrado {
		double aluguel = veiculos.calcularAluguelR(placa, dias);
		return aluguel;
	}

	public void cadastrarCarteiraBloco(double valor, int tipo,int dias) {
		switch (tipo) {
		case 1:
			carteira.setMotoDinheiro(valor);
			carteira.setDinheiroTotal(valor);
			bloco.setMotoDias(dias);
			bloco.setTotalDias(dias);
			break;
		case 2:
			carteira.setCarroDinheiro(valor);
			carteira.setDinheiroTotal(valor);
			bloco.setCarroDias(dias);
			bloco.setTotalDias(dias);
			break;
		case 4:
			carteira.setOnibusDinheiro(valor);
			carteira.setDinheiroTotal(valor);
			bloco.setOnibusDias(dias);
			bloco.setTotalDias(dias);
			break;
		case 3:
			carteira.setCaminhaoDinheiro(valor);
			carteira.setDinheiroTotal(valor);
			bloco.setCaminhaoDias(dias);
			bloco.setTotalDias(dias);
			break;
		}
	}

	public void registrarAluguel(String placa, int dias, Cliente c)
			throws VeiculoNaoCadastrado, VeiculoAlugado, ClienteNaoCadastrado {
		// VeiculoNaoCadastrado, ClienteJaCadastrado
		/*
		 * Confere se existe o carro Confere se existe a pessoa tudo check? Insere em um
		 * vetor
		 */
		Veiculo teste = pesquisar(placa); // retorna veiculo ou exceçao VeiculoNaoCadastrado
		pesquisarVeiculoAlugado(teste); // ou nao retorna nada ou retorn excecao VeiculoAlugado
		pesquisarCliente2(c.getCpf()); // ou nao retorna nada ou exceção ClienteNaoCadastrado
		Aluguel padrao = new Aluguel(c, teste, dias, true);
		teste.calculoDoAluguel(dias);
		cadastrarCarteiraBloco(teste.getValorDoAluguel(), teste.getTipo(),dias);
		aluga.add(padrao);

		// padrao.setFaturamento(teste.getValorDoAluguel());
		// teste.setDias(dias);
//		padrao.setDias(dias);
		// padrao.setV(teste);
		// padrao.setC(c);
		// padrao.setTempo(dias);
		// padrao.setAlugado(true);

	}

	public void pesquisarVeiculoAlugado(Veiculo teste) throws VeiculoAlugado {

		for (Aluguel aluguel : aluga) {
			if (teste.getPlaca().equals(aluguel.getV().getPlaca())) {
				throw new VeiculoAlugado();
			}
		}
		return;
	}

	public void registrarDevolucao(String placa, Cliente c)
			throws VeiculoNaoCadastrado, ClienteNaoCadastrado, VeiculoNaoAlugado {
		Aluguel padrao = pesquisarAluguel(placa); // ou retorna nada ou exceçao VeiculoNaoAlugado
		// pesquisarVeiculoNaoAlugado(placa); // ou nao retorna nada ou retorna exceção
		// VeiculoNaoCadastrado
		pesquisarCliente2(c.getCpf()); // ou nao retorna nada ou exceção ClienteNaoCadastrado
		// o metodo acima ja tira o elemento do arraylist aluguel
		// padrao.setAlugado(false);
		aluga.remove(padrao);
	}

	public Aluguel pesquisarAluguel(String placa) throws VeiculoNaoAlugado, VeiculoNaoCadastrado {
		Veiculo padrao = pesquisar(placa);
		for (Aluguel aluguel : aluga) {
			if (aluguel.getV().getPlaca().equals(placa)) {
				return aluguel;
			}
		}
		throw new VeiculoNaoAlugado();
	}

	public void depreciarVeiculos(int tipo, double taxaDepreciacao) {
		veiculos.depreciarVeiculos(tipo, taxaDepreciacao);
	}

	public void aumentarDiaria(int tipo, double taxaAumento) {
		veiculos.aumentarDiarias(tipo, taxaAumento);
	}

	public double faturamentoTotal(int tipo) {
			double valor;	
		switch(tipo) {
			case 0:
				valor =  carteira.getDinheiroTotal();
				return valor;
			case 1:
				valor =	carteira.getMotoDinheiro();
				return valor;
			case 2:
				valor = 	carteira.getCarroDinheiro();
				return valor;
			case 4:
				valor =	carteira.getOnibusDinheiro();
				return valor;
			case 3:
				valor =	carteira.getCaminhaoDinheiro();
				return valor;
				default: 
				return 0;
		}
	}

	public int quantidadeTotalDeDiarias(int tipo) {
		int valor;	
		switch(tipo) {
			case 0:
				valor =  bloco.getTotalDias();
				return valor;
			case 1:
				valor =	bloco.getMotoDias();
				return valor;
			case 2:
				valor = bloco.getCarroDias();
				return valor;
			case 4:
				valor =	bloco.getOnibusDias();
				return valor;
			case 3:
				valor =	bloco.getCaminhaoDias();
				return valor;
				default: 
				return 0;
		}
	}

	// public void pesquisarVeiculoNaoAlugado(String placa) throws
	// VeiculoNaoCadastrado
	// {
	// Veiculo padrao = pesquisar(placa);
//	}

//	public Aluguel pesquisarAluguel(C) {;
//	
//	}
//	
//	public void inserirAluguel() {
//		aluga[cont2++] = ;
//	}
//	

//	public double consultarAluguel(Veiculo veiculo) {
//		return veiculo.getValorDoAluguel();
//	}
//
//	public double consultarSeguro(Veiculo veiculo) {
//		return veiculo.getValorDoSeguro();
//	}

//	public void aumentarDiaria(int n, double taxa) {
	// veiculos.mudarDiaria(n, taxa);
	// }

	// public void diminuirValor(int n, double taxa) {
	// veiculos.mudarValor(n, taxa);
	// }

}
