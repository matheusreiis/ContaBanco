package entities;

public class Conta {

	private String titularDaConta;
	private String sobrenomeDoTitular;
	private int numeroDaConta;
	private int agenciaDaConta;
	protected double saldoDaConta;
	private String dataDeAberturaDaConta;

	public Conta(String titularDaConta, String sobrenomeDoTitular, int numeroDaConta, int agenciaDaConta,
			double saldoDaConta, String dataDeAberturaDaConta) {
		this.titularDaConta = titularDaConta;
		this.sobrenomeDoTitular = sobrenomeDoTitular;
		this.numeroDaConta = numeroDaConta;
		this.agenciaDaConta = agenciaDaConta;
		this.saldoDaConta = saldoDaConta;
		this.dataDeAberturaDaConta = dataDeAberturaDaConta;

	}

	public Conta() {
		this.saldoDaConta = 0;
	}

	public void setSobrenomeDoTitular(String sobrenomeDoTitular) {
		this.sobrenomeDoTitular = sobrenomeDoTitular;
	}

	public double getSaldoDaConta() {
		return saldoDaConta;
	}

	public void setSaldoDaConta(double saldoDaConta) {
		this.saldoDaConta = saldoDaConta;
	}

	public void setTitularDaConta(String titularDaConta) {
		this.titularDaConta = titularDaConta;
	}

	public void setNumeroDaConta(int numeroDaConta) {
		this.numeroDaConta = numeroDaConta;
	}

	public void setAgenciaDaConta(int agenciaDaConta) {
		this.agenciaDaConta = agenciaDaConta;
	}

	public void setdataDeAberturaDaConta(String dataDeAberturaDaConta) {
		this.dataDeAberturaDaConta = dataDeAberturaDaConta;
	}

	public void Sacar(double saque) {
		if (saque <= saldoDaConta) {
			this.saldoDaConta = saldoDaConta - saque;
		}

	}

	public void Depositar(double deposito) {
		this.saldoDaConta = deposito + saldoDaConta;

	}

	public String toString() {
		//@formatter:off
		return  "\n" +
				"\n" +
				"-------- DADOS DA CONTA -------- \n" + 
				"\n" + 
				"Nome do titular: " + 
				titularDaConta + 
				" " +
				sobrenomeDoTitular + 
				"\n" + 
				"Numero da conta: " + 
				numeroDaConta + 
				"\n" + 
				"Numero da agencia: " + 
				agenciaDaConta + 
				"\n" + "Data de abertura da conta: " + 
				dataDeAberturaDaConta + 
				"\n" + 
				"Saldo em conta:  " + 
				"R$ " + String.format("%.2f\n", saldoDaConta);
		//@formatter:on

	}
}
