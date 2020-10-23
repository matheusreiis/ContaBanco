package util;

import java.util.InputMismatchException;
import java.util.Scanner;

import interfaces.IValidadorDeInteiros;

public class ValidadorDeConta implements IValidadorDeInteiros {

	Scanner sc = new Scanner(System.in);

	public int valida(int valor, String mensagem) {
		while (valor <= 0) {
			try {
				System.out.print(mensagem);
				String valueOf ="";
				valor = sc.nextInt();
				valueOf = extracted(valor);
				while (valueOf.length() != 9) {
					System.out.println("\n##### Por favor insira 9 digitos para validar sua conta. #####");
					System.out.print(mensagem);
					valor = sc.nextInt();
					valueOf = extracted(valor);
				}  	
			} catch (InputMismatchException e) {
				System.out.print("\n##### CONTA INVALIDA ##### ");
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
