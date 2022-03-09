package locadora.ildefonsoAmorimDeSouzaBragaMury;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

//import org.junit.jupiter.api.Test;

class Teste {

	@Test
	void testeInserirVeiculo() throws VeiculoJaCadastrado {
		MinhaLocadora locadora = new MinhaLocadora();
		Veiculo carro1 = new Carro("Estrela", "Antares", 1980, "A-100", 50, 20000, 1);
		locadora.inserir(carro1);
		try {
			// Testando inserir ve�culo de mesma placa
			locadora.inserir(carro1);
			fail("Exce��o VeiculoJaCadastrado era esperada");
		} catch (VeiculoJaCadastrado e) {
			// Ok, exce��o era esperada
		}
	}
	
	@Test
	void testeInserirCliente() throws ClienteJaCadastrado {
		MinhaLocadora locadora = new MinhaLocadora();
		Cliente cli1 = new Cliente("Z� Carlos", 1234);
		
		locadora.inserir(cli1);
		try {
			// Testando inserir cliente de mesmo cpf
			locadora.inserir(cli1);
			fail("Exce��o ClienteJaCadastrado era esperada");
		} catch (ClienteJaCadastrado e) {
			// Ok, exce��o era esperada
		}
	}
	
	@Test
	void testePesquisarVeiculo() throws VeiculoJaCadastrado, VeiculoNaoCadastrado {
		MinhaLocadora locadora = new MinhaLocadora();
		Veiculo carro1 = new Carro("Estrela", "Antares", 1980, "A-100", 50, 20000, 1);
		
		locadora.inserir(carro1);
		Veiculo pesquisa = locadora.pesquisar("A-100");
		
		// Teste para saber se a pesquisa deu certo
		assertEquals(carro1.getValorAvaliado(), pesquisa.getValorAvaliado());
		
		try {
			// Testando pesquisar placa inexistente
			locadora.pesquisar("X-911");
			fail("Exce��o VeiculoNaoCadastrado era esperada");
		} catch (VeiculoNaoCadastrado e) {
			// Ok, exce��o era esperada
		}
	}
	
	@Test
	void testePesquisarMoto() throws VeiculoJaCadastrado {
		MinhaLocadora locadora = new MinhaLocadora();
		Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, "X-911", 40, 15000, 50);
		Veiculo moto2 = new Moto("Joca Motores", "Zulu", 1978, "Q-123", 30, 10000, 40);
		Veiculo moto3 = new Moto("C�lcio Motores", "Molar", 1985, "W-321", 50, 18000, 50);
		
		locadora.inserir(moto1);
		locadora.inserir(moto2);
		locadora.inserir(moto3);
		
		ArrayList<Veiculo> motos50c = locadora.pesquisarMoto(50);
		
		// Confirmando numero de motos com 50 cilindradas
		assertEquals(2, motos50c.size());
	}

	@Test
	void testePesquisarCarro() throws VeiculoJaCadastrado {
		MinhaLocadora locadora = new MinhaLocadora();
		Veiculo carro1 = new Carro("Estrela", "Antares", 1980, "A-100", 50, 23000, 1);
		Veiculo carro2 = new Carro("Joca Motores", "Pre�", 1978, "Q-123", 40, 20000, 3);
		Veiculo carro3 = new Carro("C�lcio Motores", "Canino", 1985, "W-321", 60, 25000, 2);
		
		locadora.inserir(carro1);
		locadora.inserir(carro2);
		locadora.inserir(carro3);
		
		ArrayList<Veiculo> carrosPasseio = locadora.pesquisarCarro(1);
		
		// Confirmando numero de carro de passeio
		assertEquals(1, carrosPasseio.size());
	}
	
	@Test
	void testePesquisarCaminhao() throws VeiculoJaCadastrado {
		MinhaLocadora locadora = new MinhaLocadora();
		Veiculo caminhao1 = new Caminhao("Estrela", "Betelgeuse", 1975, "X-911", 70, 30000, 200);
		Veiculo caminhao2 = new Caminhao("Joca Motores", "Malbar�", 1978, "Q-123", 80, 45000, 300);
		Veiculo caminhao3 = new Caminhao("C�lcio Motores", "Incisivo", 1985, "W-321", 90, 60000, 200);
		
		locadora.inserir(caminhao1);
		locadora.inserir(caminhao2);
		locadora.inserir(caminhao3);
		
		ArrayList<Veiculo> caminhoesCarga200 = locadora.pesquisarCaminhao(200);
		
		// Confirmando numero de caminhoes com carga 200
		assertEquals(2, caminhoesCarga200.size());
	}
	
	@Test
	void testePesquisarOnibus() throws VeiculoJaCadastrado {
		MinhaLocadora locadora = new MinhaLocadora();
		Veiculo onibus1 = new Onibus("Estrela", "Aldebar�", 1975, "X-911", 60, 30000, 50);
		Veiculo onibus2 = new Onibus("Joca Motores", "Kall'anggo", 1978, "Q-123", 70, 40000, 50);
		Veiculo onibus3 = new Onibus("C�lcio Motores", "Bicusp", 1985, "W-321", 85, 50000, 70);
		
		locadora.inserir(onibus1);
		locadora.inserir(onibus2);
		locadora.inserir(onibus3);
		
		ArrayList<Veiculo> onibus50p = locadora.pesquisarOnibus(50);
		
		// Confirmando numero de onibus com 50 passageiros
		assertEquals(2, onibus50p.size());
	}
	
	@Test
	void testeCalcularAluguel() throws VeiculoJaCadastrado, VeiculoNaoCadastrado {
		MinhaLocadora locadora = new MinhaLocadora();
		Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, "X-911", 40, 15000, 50);
		Veiculo carro1 = new Carro("Estrela", "Antares", 1980, "A-100", 50, 20000, 1);
		Veiculo caminhao1 = new Caminhao("Estrela", "Betelgeuse", 1975, "S-123", 70, 30000, 200);
		Veiculo onibus1 = new Onibus("Estrela", "Aldebar�", 1975, "I-412", 60, 30000, 50);
		locadora.inserir(moto1);
		locadora.inserir(carro1);
		locadora.inserir(caminhao1);
		locadora.inserir(onibus1);
		
		double aluguelMoto = locadora.calcularAluguel("X-911", 5);
		double aluguelCarro = locadora.calcularAluguel("A-100", 5);
		double aluguelCaminhao = locadora.calcularAluguel("S-123", 5);
		double aluguelOnibus = locadora.calcularAluguel("I-412", 5);
		
		// Confirmando valor do aluguel da moto: (40(diaria) + 4.52(seguro diario)) * 5 dias = 222.6
		assertEquals(222.6, aluguelMoto, 0.01);
		// Confirmando valor do aluguel do carro: (50(di�ria) + 1.64(seguro diario)) * 5 dias = 258.22
		assertEquals(258.22, aluguelCarro, 0.01);
		// Confirmando valor do aluguel do caminhao: (70(diaria) + 6.58(seguro diario)) * 5 dias = 382.88
		assertEquals(382.88, aluguelCaminhao, 0.01);
		// Confirmando valor do aluguel do onibus: (60(diaria) + 16.44(seguro diario)) * 5 dias = 382.19
		assertEquals(382.19, aluguelOnibus, 0.01);
		
		try {
			// Testando calcular aluguel para placa inexistente
			locadora.calcularAluguel("X-999", 10);
			fail("Exce��o VeiculoNaoCadastrado esperada");
		} catch (VeiculoNaoCadastrado e) {
			// Ok, exce��o era esperada
		}
	}
	
	@Test
	void testeRegistrarAluguel() throws VeiculoNaoCadastrado, VeiculoAlugado, ClienteNaoCadastrado, VeiculoJaCadastrado, ClienteJaCadastrado {
		MinhaLocadora locadora = new MinhaLocadora();
		Veiculo carro1 = new Carro("Estrela", "Antares", 1980, "A-100", 50, 20000, 1);
		Cliente cli1 = new Cliente("Z� Carlos", 1234);
		locadora.inserir(carro1);
		locadora.inserir(cli1);
		
		locadora.registrarAluguel("A-100", 5, cli1);
		try {
			// Testando registrar aluguel de carro j� alugado
			locadora.registrarAluguel("A-100", 5, cli1);
			fail("Exce��o VeiculoAlugado esperada");
		} catch (VeiculoAlugado e) {
			// Ok, exce��o era esperada
		}
		
		try {
			// Testando registrar aluguel de placa n�o cadastrada
			locadora.registrarAluguel("X-999", 5, cli1);
			fail("Exce��o VeiculoNaoCadastrado esperada");
		} catch (VeiculoNaoCadastrado e) {
			// Ok, exce��o era esperada
		}
		
		Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, "X-911", 40, 15000, 50);
		Cliente cli2 = new Cliente("Josu� Dutra", 5412);
		locadora.inserir(moto1);
		
		try {
			// Testando registrar alguel para cliente nao cadastrado
			locadora.registrarAluguel("X-911", 5, cli2);
			fail("Exce��o ClienteNaoCadastrado esperada");
		} catch (ClienteNaoCadastrado e) {
			// Ok, exce��o era esperada
		}
	}
	
	@Test
	void testeRegistrarDevolucao() throws VeiculoJaCadastrado, ClienteJaCadastrado, VeiculoNaoCadastrado, VeiculoAlugado, ClienteNaoCadastrado, VeiculoNaoAlugado {
		MinhaLocadora locadora = new MinhaLocadora();
		Veiculo carro1 = new Carro("Estrela", "Antares", 1980, "A-100", 50, 20000, 1);
		Cliente cli1 = new Cliente("Z� Carlos", 1234);
		locadora.inserir(carro1);
		locadora.inserir(cli1);
		
		locadora.registrarAluguel("A-100", 5, cli1);
		locadora.registrarDevolucao("A-100", cli1);
		try {
			// Testando registrar devolu��o de veiculo nao alugado
			locadora.registrarDevolucao("A-100", cli1);
			fail("Exce��o VeiculoNaoAlugado esperada");
		} catch (VeiculoNaoAlugado e) {
			// Ok, exce��o era esperada
		}
		
		try {
			// Testando registrar devolu��o de placa n�o cadastrada
			locadora.registrarDevolucao("X-999", cli1);
			fail("Exce��o VeiculoNaoCadastrado esperada");
		} catch (VeiculoNaoCadastrado e) {
			// Ok, exce��o era esperada
		}
		
		Cliente cli2 = new Cliente("Josu� Dutra", 5412);
		locadora.registrarAluguel("A-100", 5, cli1);
		try {
			// Testando registrar devolu��o para cliente n�o cadastrado
			locadora.registrarDevolucao("A-100", cli2);
			fail("Exce��o ClienteoNaoCadastrado esperada");
		} catch (ClienteNaoCadastrado e) {
			// Pk, exce��o era esperada
		}
	}
	
	@Test
	void testeDepreciarVeiculos() throws VeiculoJaCadastrado, VeiculoNaoCadastrado {
		MinhaLocadora locadora = new MinhaLocadora();
		Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, "X-911", 40, 15000, 50);
		Veiculo carro1 = new Carro("Estrela", "Antares", 1980, "A-100", 50, 20000, 1);
		Veiculo caminhao1 = new Caminhao("Estrela", "Betelgeuse", 1975, "S-123", 70, 30000, 200);
		Veiculo onibus1 = new Onibus("Estrela", "Aldebar�", 1975, "I-412", 60, 30000, 50);
		locadora.inserir(moto1);
		locadora.inserir(carro1);
		locadora.inserir(caminhao1);
		locadora.inserir(onibus1);
		
		locadora.depreciarVeiculos(1, 0.1);		// Depreciando motos em 10%
		locadora.depreciarVeiculos(2, 0.2);		// Depreciando carros em 20%
		locadora.depreciarVeiculos(3, 0.05);	// Depreciando caminh�es em 5%
		locadora.depreciarVeiculos(4, 0.15);	// Depreciando �nibus em 15%
		
		assertEquals(13500, locadora.pesquisar("X-911").getValorAvaliado(), 0.01);
		assertEquals(16000, locadora.pesquisar("A-100").getValorAvaliado(), 0.01);
		assertEquals(28500, locadora.pesquisar("S-123").getValorAvaliado(), 0.01);
		assertEquals(25500, locadora.pesquisar("I-412").getValorAvaliado(), 0.01);
		
		locadora.depreciarVeiculos(0, 0.1);		// Depreciando todos ve�culos em 10%
		
		assertEquals(12150, locadora.pesquisar("X-911").getValorAvaliado(), 0.01);
		assertEquals(14400, locadora.pesquisar("A-100").getValorAvaliado(), 0.01);
	}
	
	@Test
	void testeAumentarDiaria() throws VeiculoJaCadastrado, VeiculoNaoCadastrado {
		MinhaLocadora locadora = new MinhaLocadora();
		Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, "X-911", 40, 15000, 50);
		Veiculo carro1 = new Carro("Estrela", "Antares", 1980, "A-100", 50, 20000, 1);
		Veiculo caminhao1 = new Caminhao("Estrela", "Betelgeuse", 1975, "S-123", 70, 30000, 200);
		Veiculo onibus1 = new Onibus("Estrela", "Aldebar�", 1975, "I-412", 60, 30000, 50);
		locadora.inserir(moto1);
		locadora.inserir(carro1);
		locadora.inserir(caminhao1);
		locadora.inserir(onibus1);
		
		locadora.aumentarDiaria(1, 0.1);	// Aumentando di�ria de motos em 10%
		locadora.aumentarDiaria(2, 0.2);	// Aumentando di�ria de carros em 20%
		locadora.aumentarDiaria(3, 0.05);	// Aumentando di�ria de caminh�es em 5%
		locadora.aumentarDiaria(4, 0.15);	// Aumentando di�ria de �nibus em 15%
		
		assertEquals(44, locadora.pesquisar("X-911").getValorDiaria(), 0.01);
		assertEquals(60, locadora.pesquisar("A-100").getValorDiaria(), 0.01);
		assertEquals(73.5, locadora.pesquisar("S-123").getValorDiaria(), 0.01);
		assertEquals(69, locadora.pesquisar("I-412").getValorDiaria(), 0.01);
		
		locadora.aumentarDiaria(0, 0.1);	// Aumentando di�ria de todos ve�culos em 10%
		
		assertEquals(48.4, locadora.pesquisar("X-911").getValorDiaria(), 0.01);
		assertEquals(66, locadora.pesquisar("A-100").getValorDiaria(), 0.01);
	}
	
	@Test
	void testeFaturamentoTotal() throws VeiculoJaCadastrado, ClienteJaCadastrado, VeiculoNaoCadastrado, VeiculoAlugado, ClienteNaoCadastrado {
		MinhaLocadora locadora = new MinhaLocadora();
		Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, "X-911", 40, 15000, 50);
		Veiculo carro1 = new Carro("Estrela", "Antares", 1980, "A-100", 50, 20000, 1);
		Veiculo caminhao1 = new Caminhao("Estrela", "Betelgeuse", 1975, "S-123", 70, 30000, 200);
		Veiculo onibus1 = new Onibus("Estrela", "Aldebar�", 1975, "I-412", 60, 30000, 50);
		locadora.inserir(moto1);
		locadora.inserir(carro1);
		locadora.inserir(caminhao1);
		locadora.inserir(onibus1);
		
		Cliente cli1 = new Cliente("Z� Carlos", 1234);
		locadora.inserir(cli1);
		
		locadora.registrarAluguel("X-911", 5, cli1);	// Valor do aluguel = 222.6  (moto)
		locadora.registrarAluguel("A-100", 5, cli1);	// Valor do aluguel = 258.22 (carro)
		locadora.registrarAluguel("S-123", 5, cli1);	// Valor do aluguel = 382.88 (caminh�o)
		locadora.registrarAluguel("I-412", 5, cli1);	// Valor do aluguel = 382.19 (�nibus)
		
		assertEquals(222.6, locadora.faturamentoTotal(1), 0.01);	// Faturamento total de motos
		assertEquals(258.22, locadora.faturamentoTotal(2), 0.01);	// Faturamento total de carros
		assertEquals(382.88, locadora.faturamentoTotal(3), 0.01);	// Faturamento total de caminh�es
		assertEquals(382.19, locadora.faturamentoTotal(4), 0.01);	// Faturamento total de �nibus
		assertEquals(1245.89, locadora.faturamentoTotal(0), 0.01);	// Faturamento total
	}
	
	@Test
	void testeQuantidadeTotalDeDiarias() throws VeiculoJaCadastrado, ClienteJaCadastrado, VeiculoNaoCadastrado, VeiculoAlugado, ClienteNaoCadastrado {
		MinhaLocadora locadora = new MinhaLocadora();
		Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, "X-911", 40, 15000, 50);
		Veiculo carro1 = new Carro("Estrela", "Antares", 1980, "A-100", 50, 20000, 1);
		Veiculo caminhao1 = new Caminhao("Estrela", "Betelgeuse", 1975, "S-123", 70, 30000, 200);
		Veiculo onibus1 = new Onibus("Estrela", "Aldebar�", 1975, "I-412", 60, 30000, 50);
		locadora.inserir(moto1);
		locadora.inserir(carro1);
		locadora.inserir(caminhao1);
		locadora.inserir(onibus1);
		
		Cliente cli1 = new Cliente("Z� Carlos", 1234);
		locadora.inserir(cli1);
		
		locadora.registrarAluguel("X-911", 5, cli1);	// 5 di�rias de moto
		locadora.registrarAluguel("A-100", 10, cli1);	// 10 di�rias de carro
		locadora.registrarAluguel("S-123", 7, cli1);	// 7 di�rias de caminh�o
		locadora.registrarAluguel("I-412", 2, cli1);	// 2 di�rias de �nibus
		
		assertEquals(5, locadora.quantidadeTotalDeDiarias(1));	// Quantidade de di�rias de moto
		assertEquals(10, locadora.quantidadeTotalDeDiarias(2));	// Quantidade de di�rias de carro
		assertEquals(7, locadora.quantidadeTotalDeDiarias(3));	// Quantidade de di�rias de caminh�o
		assertEquals(2, locadora.quantidadeTotalDeDiarias(4));	// Quantidade de di�rias de �nibus
		assertEquals(24, locadora.quantidadeTotalDeDiarias(0));	// Quantidade de di�rias total
	}
}
