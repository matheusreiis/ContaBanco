package util;

import java.util.InputMismatchException;
import java.util.Scanner;

import interfaces.IValidadorDeInteiros;

public class ValidadorDeAgencia implements IValidadorDeInteiros {

	Scanner sc = new Scanner(System.in);

	public int valida(int valor, String mensagem) {
		while (valor <= 0) {
			try {
				System.out.print(mensagem);
				String valueOf = "";
				valor = sc.nextInt();
				valueOf = extracted(valor);
				while (valueOf.length() != 4) {
					System.out.println("\n##### Por favor insira 4 digitos para validar sua agencia. #####");
					System.out.print(mensagem);
					valor = sc.nextInt();
					valueOf = extracted(valor);
				}
			} catch (InputMismatchException e) {
				System.out.print("\n##### AGENCIA INVALIDA ##### ");
				System.out.println();
				sc.nextLine();
			}
		}
		return valor;
	}

	private String extracted(int valor) {
		String valueOf;
		valueOf = String.valueOf(valor);
		valueOf.length();
		return valueOf;
	}
}
