package locadora.ildefonsoAmorimDeSouzaBragaMury;

import java.util.ArrayList;

public class RepositorioDeVeiculos {

	private ArrayList<Veiculo> veiculosArray = new ArrayList<Veiculo>();

	public void inserirR(Veiculo veiculo) throws VeiculoJaCadastrado {
		pesquisarR1(veiculo.getPlaca());
		veiculo.calculoDoSeguro();
		// if (teste == null) {
		veiculosArray.add(veiculo);
		// }
	}
	// em pesquisar, o N assume dois valores, 1 para inserir, 0 para retornar
	// veiculo nao cadastrado

	public Veiculo pesquisarR(String placa) throws VeiculoNaoCadastrado {
		// O pesquisar ou encontra um ja cadastrada ou nao. Nesse caso, ambos as saidas
		// ESTAVAM com erro
		for (Veiculo veiculo : veiculosArray) {
			if (veiculo.getPlaca() == placa) {
				return veiculo;
			}
		}
		throw new VeiculoNaoCadastrado();
	}

	public void pesquisarR1(String placa) throws VeiculoJaCadastrado {
		for (Veiculo veiculo : veiculosArray) {
			if (veiculo.getPlaca() == placa) {
				throw new VeiculoJaCadastrado();
			}
		}
	}

	public ArrayList<Veiculo> pesquisarMotoR(int cilindrada) {
		ArrayList<Veiculo> motos = new ArrayList<Veiculo>(); // devo instanciar?
		for (Veiculo veiculo : veiculosArray) {
			if (veiculo.getTipo() == 1) {
				if (((Moto) veiculo).getCilindrada() == cilindrada)
					motos.add(veiculo);
			}
		}
		return motos;
	}

	public ArrayList<Veiculo> pesquisarCarroR(int categoria) {
		ArrayList<Veiculo> carros = new ArrayList<Veiculo>();
		for (Veiculo veiculo : veiculosArray) {
			if (veiculo.getTipo() == 2) {
				if (((Carro) veiculo).getCategoria() == categoria)
					carros.add(veiculo);
			}
		}
		return carros;
	}

	public ArrayList<Veiculo> pesquisarCaminhaoR(int carga) {
		ArrayList<Veiculo> caminhao = new ArrayList<Veiculo>();
		for (Veiculo veiculo : veiculosArray) {
			if (veiculo.getTipo() == 3) {
				if (((Caminhao) veiculo).getCarga() == carga)
					caminhao.add(veiculo);
			}
		}
		return caminhao;
	}

	public ArrayList<Veiculo> pesquisarOnibusR(int capacidade) {
		ArrayList<Veiculo> Onibus = new ArrayList<Veiculo>();
		for (Veiculo veiculo : veiculosArray) {
			if (veiculo.getTipo() == 4) {
				if (((Onibus) veiculo).getCapacidade() == capacidade)
					Onibus.add(veiculo);
			}
		}
		return Onibus;
	}

	public double calcularAluguelR(String placa, int dias) throws VeiculoNaoCadastrado {
		Veiculo padrao = pesquisarR(placa);
		padrao.calculoDoSeguro();
		padrao.calculoDoAluguel(dias);
		return padrao.getValorDoAluguel();
	}

	public void depreciarVeiculos(int n, double taxa) {
		if (n == 0) {
			for (Veiculo veiculo : veiculosArray) {
				veiculo.mudarValorAvaliadoDoBem(taxa);
			}
		} else {

			for (Veiculo veiculo : veiculosArray) {
				if (veiculo.getTipo() == n) {
					veiculo.mudarValorAvaliadoDoBem(taxa);
				}
			}
		}
	}

	public void aumentarDiarias(int n, double taxa) {
		if (n == 0) {
			for (Veiculo veiculo : veiculosArray) {
				veiculo.mudarValorDaDiaria(taxa);
			}
		} else {
			for (Veiculo veiculo : veiculosArray) {
				if (veiculo.getTipo() == n) {
					veiculo.mudarValorDaDiaria(taxa);
				}
			}
		}
		
	}
	
	
}