
public class ContaCorrente extends Conta{
	private Double taxaDesaque ;
	private Double taxaDeTransferencia;
	
	public ContaCorrente() {
		
	}
	
	public ContaCorrente(Double saldo, Double taxaDesaque, Double taxaDeTransferencia) {
		super();
		this.taxaDesaque = taxaDesaque;
		this.taxaDeTransferencia = taxaDeTransferencia;
	}
	
	
	public Double getTaxaDesaque() {
		return taxaDesaque;
	}

	public void setTaxaDesaque(Double taxaDesaque) {
		this.taxaDesaque = taxaDesaque;
	}

	public Double getTaxaDeTransferencia() {
		return taxaDeTransferencia;
	}

	public void setTaxaDeTransferencia(Double taxaDeTransferencia) {
		this.taxaDeTransferencia = taxaDeTransferencia;
	}

	@Override
	public void Sacar(Double valor) {
		Double valorComTaxa = valor + taxaDesaque;
		super.Sacar(valorComTaxa);
		System.out.println("O saque foi realizado e seu saldo atual é" + this.getSaldo());
	}
	
	@Override
	public void Transferir(Conta contaDepostsito, Double valor) {
		Double valorComTaxaDeTransferencia = valor + taxaDeTransferencia;
		super.Transferir(contaDepostsito, valorComTaxaDeTransferencia);
		System.out.println("A transferencia foi realizada e seu saldo atual é " + this.getSaldo());
	}
}
