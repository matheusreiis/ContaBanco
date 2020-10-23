package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import interfaces.IDatasEHorarios;

public class CriarDataEHorario implements IDatasEHorarios {

	public String valida(String dateFormart, String mensagemData) {
		System.out.print(mensagemData);
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

}
