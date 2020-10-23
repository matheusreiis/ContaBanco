package interfaces;

public interface IValidadorDeDepositos {

	public double valida(double valor, String mensagem, String mensagemErroDepositoInvalido, String mensagemErroAcimaDoDeposito, String mensagemDepositoConcluido);
}
