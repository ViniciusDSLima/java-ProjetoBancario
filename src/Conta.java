
public class Conta {
	private static int contas = 1;
	
	private int numeroConta;
	private Double saldo = 0.0;
	private int agencia;
	private int numeroDeTransferencias = 0;
	private double valorSacado = 0.0;
	public Conta() {
		
	}
	
	public Conta( Cliente cliente, int numeroConta) {
		this.numeroConta = numeroConta;
		this.agencia = agencia;
		contas++;
		
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	
	public int getNumeroDeTransferencias() {
		return numeroDeTransferencias;
	}

	public void Depositar(Double valor) {
		if(valor > 0) {
			this.saldo = this.saldo + valor;	
		}
	}
	
	public void Sacar(Double valor) {
		this.saldo -= valor;
//		if(valor > 0 && this.saldo < valor) {
//			
//			System.out.println("Não é possivel sacar o valor desejado pois o saldo da conta é: " + this.saldo + "Que é inferior ao valor desejado");
//		}
		
//		else {
//			this.saldo -= valor;
//			System.out.println("saque realizado. seu saldo atual é de: " + this.saldo + "reais");
//			valorSacado += valor;
//		}
	}
	public void Transferir(Conta contaDepostsito, Double valor) {
		if(this.saldo < valor) {
			System.out.println("A transferencia não é possível ser realizada, pois o saldo é menor que o valor da tranferencia " + this.saldo);
		}
		else {
			this.saldo -= valor;
			contaDepostsito.saldo = contaDepostsito.getSaldo() + valor;
			System.out.println("A trasnferencia foi realizada e o seu saldo atual é de: " + this.getSaldo());
			numeroDeTransferencias++;
		}
	}
}
