package interfaces;

public interface IValidadorDeSaques {

	public double valida(double valor, String mensagem, String mensagemErroSaqueInvalido, String mensagemSemSaldo, String mensagemSaqueConcluido);

}
