package util;

import java.util.InputMismatchException;
import java.util.Scanner;

import entities.Conta;
import interfaces.IValidadorDeSaques;

public class ValidadorDeSaque extends Conta implements IValidadorDeSaques {

	Scanner sc = new Scanner(System.in);

	public double valida(double valor, String mensagem, String mensagemErroSaqueInvalido, String mensagemSemSaldo,
			String mensagemSaqueConcluido) {

		while (valor <= 0.00) {
			try {
				System.out.print(mensagem);
				valor = sc.nextDouble();
				if (valor > saldoDaConta) {
					System.out.println(mensagemSemSaldo);
				}
				if (valor <= 0.00) {
					System.out.println(mensagemErroSaqueInvalido);
				} else if (valor <= saldoDaConta) {
					System.out.println(mensagemSaqueConcluido);
				}

			} catch (InputMismatchException e) {
				System.out.println(mensagemErroSaqueInvalido);
				System.out.println();
				sc.nextLine();
			} catch (Exception e) {
				System.out.println(mensagemSemSaldo);
				System.out.println();
				sc.nextLine();
			}
		}
		return valor;
	}
}
