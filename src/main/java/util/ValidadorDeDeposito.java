package util;

import java.util.InputMismatchException;
import java.util.Scanner;

import interfaces.IValidadorDeDepositos;

public class ValidadorDeDeposito implements IValidadorDeDepositos {

	Scanner sc = new Scanner(System.in);

	public double valida(double valor, String mensagem, String mensagemErroDepositoInvalido,
			String mensagemErroAcimaDoDeposito, String mensagemDepositoConcluido) {
		while (valor <= 0.00 || valor > 5000.00) {
			try {
				System.out.print(mensagem);
				valor = sc.nextDouble();
				if (valor <= 0.00) {
					System.out.println(mensagemErroDepositoInvalido);
				} else if (valor > 5000.00) {
					System.out.println(mensagemErroAcimaDoDeposito);
				} else if (valor > 0.00 || valor <= 5000.00) {
					System.out.println(mensagemDepositoConcluido);
				}

			} catch (InputMismatchException e) {
				System.out.println(mensagemErroDepositoInvalido);
				System.out.println();
				sc.nextLine();
			} catch (Exception e) {
				System.out.println(mensagemErroAcimaDoDeposito);
				System.out.println();
				sc.nextLine();
			}
		}
		return valor;
	}

}
