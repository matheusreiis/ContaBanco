package main;

import java.util.Scanner;

import entities.Conta;
import util.CriarDataEHorario;
import util.ValidadorDeAgencia;
import util.ValidadorDeConta;
import util.ValidadorDeDeposito;
import util.ValidadorDeSaque;

public class ContaMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Conta c1 = new Conta();
		ValidadorDeConta validaConta = new ValidadorDeConta();
		ValidadorDeAgencia validaAgencia = new ValidadorDeAgencia();
		ValidadorDeDeposito validaDeposito = new ValidadorDeDeposito();
		ValidadorDeSaque validaSaque = new ValidadorDeSaque();	
		CriarDataEHorario dataEHorario = new CriarDataEHorario();

		System.out.println("\n---------- BEM VINDO AO SISTEMA ---------");
		System.out.print("\nInforme o nome e sobrenome do titular: ");
		String titularDaConta = sc.next();
		String sobrenomeDoTitular = sc.next();
		titularDaConta = titularDaConta.substring(0,1).toUpperCase().concat(titularDaConta.substring(1));
		sobrenomeDoTitular = sobrenomeDoTitular.substring(0,1).toUpperCase().concat(sobrenomeDoTitular.substring(1));
		c1.setTitularDaConta(titularDaConta);
		c1.setSobrenomeDoTitular(sobrenomeDoTitular);
			
		int valor = 0;
		String mensagem = "\nInforme o numero da conta (9 digitos): ";
		c1.setNumeroDaConta(validaConta.valida(valor, mensagem));

		mensagem = "\nInforme o numero da agencia (4 digitos): ";
		c1.setAgenciaDaConta(validaAgencia.valida(valor, mensagem));

		String dateformart = null;
		String mensagemData = "\nData da abertura da conta: ";
		mensagemData = dataEHorario.valida(dateformart, mensagemData);
		c1.setdataDeAberturaDaConta(dataEHorario.valida(dateformart, mensagemData));

		System.out.println();
		System.out.println("\n-------- CONTA CRIADA COM SUCESSO, SEJA BEM VINDO! --------");

		System.out.print("Deseja realizar um primeiro deposito? (y/n): ");
		char acaoDepositarOuNaoDepositar = sc.next().charAt(0);
		System.out.println();

		if (acaoDepositarOuNaoDepositar == 'y') {

			mensagem = "\nQuanto deseja depositar? (LIMITE R$5000,00): ";
			String mensagemErroDepositoInvalido = "\n##### VALOR INVALIDO, por favor insira um valor valido (LIMITE R$5000,00) ##### ";
			String mensagemErroAcimaDoDeposito = "\n##### DEPOSITO ACIMA DO LIMITE, Entre em contato com o seu banco para solicitacao de depositos acima de R$ 5000,00. #####";
			String mensagemDepositoConcluido = "\n ---------- DEPOSITO CONCLUIDO ----------";
			c1.Depositar(
					validaDeposito.valida(valor, mensagem, mensagemErroDepositoInvalido, mensagemErroAcimaDoDeposito, mensagemDepositoConcluido ));

		} else if (acaoDepositarOuNaoDepositar == 'n') {
			System.out.println("Saldo atual: " + c1.getSaldoDaConta() + "\n");
		}
		System.out.print("\nDeseja ver seus dados bancarios? (y/n): ");

		char acaoVerDadosBancarios = sc.next().charAt(0);
		System.out.println();

		if (acaoVerDadosBancarios == 'y') {
			System.out.println(c1.toString());

		} else if (acaoVerDadosBancarios == 'n') {
		}
		for (char i = acaoVerDadosBancarios; i != 'y' && i != 'n';) {
			System.out.print("Por favor, insira 'y' ou 'n': ");
			acaoVerDadosBancarios = sc.next().charAt(0);
			if (acaoVerDadosBancarios == 'y') {
				System.out.println(c1.toString());
			}
			break;
		}
		int acaoLobbyConta = 0;

		System.out.println("-----------------------------------");
		System.out.println(
				" Deseja realizar mais alguma acao?\n \n 1.Deposito\n 2.Saque\n 3.Saldo\n 4.Dados Conta\n 5.Encerrar Sessao");
		System.out.println("-----------------------------------\n");
		acaoLobbyConta = sc.nextInt();

		for (int i = acaoLobbyConta; i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i > 5; i++) {

			if (acaoLobbyConta == 1) {
				mensagem = "\nQuanto deseja depositar? (LIMITE R$5000,00): ";
				String mensagemErroDepositoInvalido = "\n##### VALOR INVALIDO, por favor insira um valor valido (LIMITE R$5000,00) ##### ";
				String mensagemErroAcimaDoDeposito = "\n##### DEPOSITO ACIMA DO LIMITE, Entre em contato com o seu banco para solicitacao de depositos acima de R$ 5000,00. #####";
				String mensagemDepositoConcluido = "\n--------- DEPOSITO CONCLUIDO ---------";
				System.out.println();
				c1.Depositar(validaDeposito.valida(valor, mensagem, mensagemErroDepositoInvalido, mensagemErroAcimaDoDeposito, mensagemDepositoConcluido));
			} else if (acaoLobbyConta == 2) {
				mensagem = "Quanto deseja sacar? ";
				String mensagemErroSaqueInvalido = "\n##### VALOR INVALIDO, por favor insira um valor valido para saque. ##### ";
				String mensagemSemSaldo = "Saldo insuficiente!";
				String mensagemSaqueConcluido = "\n--------- SAQUE CONCLUIDO ---------";
				System.out.println();
				c1.Sacar(validaSaque.valida(valor, mensagem, mensagemErroSaqueInvalido, mensagemSemSaldo, mensagemSaqueConcluido ));

			} else if (acaoLobbyConta == 3) {
				System.out.println("SALDO ATUAL: R$" + c1.getSaldoDaConta());
			} else if (acaoLobbyConta == 4) {
				System.out.println(c1.toString());
			} else if (acaoLobbyConta == 5) {
				System.out.println("\nSessao Encerrada! ");
				break;
			} else if (acaoLobbyConta > 5) {
				System.out.println("## ACAO NAO ENCONTRADA EM NOSSO SISTEMA, POR FAVOR DIGITE UM VALOR VALIDO ##");
			}

			System.out.println("-----------------------------------");
			System.out.println(
					" \nDeseja realizar mais alguma acao?\n \n 1.Deposito\n 2.Saque\n 3.Saldo\n 4.Dados Conta\n 5.Encerrar Sessao\n");
			System.out.println("-----------------------------------");
			acaoLobbyConta = sc.nextInt();
		}
		sc.close();

	}

}
