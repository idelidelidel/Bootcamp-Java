1ª Avaliação Prática
	
		Suponha que você deseja implementar um Sistema para Controle de uma Locadora de Veículos.
	Essa locadora trabalha com 4 tipos de veículos: moto (tipo 1), carro (tipo 2), ônibus (tipo 3) e caminhão (tipo 4).
	Todos os veículos possuem marca, modelo, ano de fabricação, placa, valor da diária e valor avaliado do bem.
	Os caminhões têm como informação adicional capacidade de carga transportada, as motos possuem uma informação adicional 
	sobre sua cilindrada, os carros a categoria (passeio, SUV, pick up) e ônibus a capacidade de passageiros.
	
		Cada um dos tipos de veículos existentes na locadora possui uma forma de cálculo do
	seguro diário exigido em caso de locação.
	
		O seguro de uma moto é dado pela fórmula (valordo bem*11%)/365, onde o valor do bem corresponde ao valor avaliado do veículo em
	questão.
		Da mesma forma, o seguro de um caminhão é dado pela fórmula (valor do
	bem*8%)/365, o seguro de um carro é (valor do bem*3%)/365 o seguro de um ônibus é
	(valor do bem*20%)/365.

		O aluguel de um determinado veículo é dado pela fórmula (valor
	da diária + seguro) * quantidade de dias.

		Para se controlar o valor de cada veículo e das suas diárias, é possível realizar a
	depreciação nos valores dos bens (reduzindo um percentual no valor de cada veículo), além
	de possibilitar um acréscimo no valor de todas as diárias de um tipo de veículo (por exemplo,
	aumentar a diária das motos em 10%).
	
		No sistema da locadora deverá existir uma série de consultas à frota, testando seus dados
	adicionais. Essas consultas permitem descobrir quais as motos com cilindrada maior ou igual
	a uma cilindrada desejada, encontrar caminhões que consigam transportar uma determinada
	quantidade de carga mínima e pesquisar carros que sejam de passeio ou SUV ou pick ups.
	
		1. Crie a classe que representa veículos (carro, caminhão, ônibus e motos), com base no que
	foi explicado nas aulas, levando em consideração as diversas características da
	linguagem Java para se construir programas com mais qualidade. Essa classe deve
	possuir pelo menos os métodos para retornar o valor do seguro, retornar valor de aluguel,
	aumentar e reduzir preço de uma diária e aumentar e reduzir o valor avaliado do bem,
	para cada tipo de veiculo. (4,0)

		2. Crie uma classe que implemente a classe Locadora, conforme definição a seguir, que tem
	como principal função controlar os veículos existentes. Essa locadora deverá possuir
	como um dos seus atributos um objeto RepositórioDeVeiculos, que deve ser uma
	estrutura de dados para armazenar veículos, seja ela um Array, Lista ou qualquer outra
	estrutura. Essa estrutura deve ser obrigada a possuir os métodos inserir(veículo) e
	procurar(placa), não permitindo a inserção de veículos com mesma placa. Lembre-se
	mais uma vez das características de qualidade de software implementadas pela
	linguagem Java para alcançar esses objetivos. A classe locadora deverá possuir os
	métodos cadastrar veículo, consultar aluguel, consultar seguro, aumentar ou diminuir
	diárias de um tipo de veículo, aumentar ou diminuir valor de um tipo de veículo e
	consultar a frota de acordo com a categoria e dados auxiliares (capacidade de carga,
	quantidade de passageiros e cilindrada). (4,0)
		
		3. Crie os demais métodos previstos a seguir (2,0).
	package exercicio1;
	import java.util.ArrayList;
	public class Locadora {
	public void inserir(Veiculo v);
	public void inserir(Cliente c);
	public Veiculo pesquisar(String placa;
	 public ArrayList<Veiculo> pesquisarMoto(int cilindrada);
	// tipo de carro
	// 1 (passeio), 2 (SUV), 3 (pickup)
	 public ArrayList<Veiculo> pesquisarCarro(int tipoCarro);
	 public ArrayList<Veiculo> pesquisarCaminhao(int carga);
	 public ArrayList<Veiculo> pesquisarOnibus(int passageiros);
	
	 //Seguro Moto = (valor do bem * 11%)/365
	 //Seguro Carro = (valor do bem * 3%)/365	
	 //Seguro Caminhão = (valor do bem * 8%)/365
	 //Seguro Ônibus = (valor do bem * 20%)/365
	 //Aluguel = (valor da diária + seguro) * quantidade de dias
	 public double calcularAluguel(String placa, int dias);
	 public void registrarAluguel(String placa, int dias, Cliente c);
	 public void registrarDevolucao(String placa, Cliente c);
	
	// tipo de veiculo
	// 0 (todos), 1 (moto), 2 (carro), 3 (caminhão), 4 (ônibus)
	 public void depreciarVeiculos(int tipo, double taxaDepreciacao);
	 public void aumentarDiaria(int tipo, double taxaAumento);
	 public double faturamentoTotal(int tipo);
	 public int quantidadeTotalDeDiarias(int tipo);
	}
