import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Testes {

	static Scanner input = new Scanner(System.in);

	static ArrayList<Conta> contasBancarias = new ArrayList<>();
	
	private static Conta ContaCorrente;

	public static void main(String[] args) {
		
		transacoes();
	}

	public static void transacoes() {
		System.out.println();
		mensagem("Selecione uma opção para realizar operações com sua conta bancaria. ");
		mensagem("operacao 1: Criar conta ");
		mensagem("operacao 2: Depositar ");
		mensagem("operacao 3: Sacar ");
		mensagem("operacao 4: Trasnferir");

		int Transacao = input.nextInt();

		switch (Transacao) {
		case 1:
			criarConta();
			break;
		case 2:
			depositar();
			break;
		case 3:
			sacar();
			break;
		case 4:
			transferir();
			break;
		default:
			mensagem("Opção invalida, selecione uma das opces listadas abaixo: ");
			transacoes();
			break;
		}
	}

	private static void criarConta() {
		mensagem("Nome:");
		String nome = input.nextLine();

		mensagem("Registro: ");
		String registro = input.nextLine();
		
		mensagem("Digite o numero da conta");
		int numeroConta = input.nextInt();
		
		Cliente cliente = new Cliente(nome, registro);
		
		Conta conta = new Conta(cliente, numeroConta);
		

		contasBancarias.add(conta);
		mensagem("sua conta foi criada com sucesso! ");
		
		

		transacoes();
	}

	private static Conta encontrarConta(int numeroConta) {
		if (contasBancarias.size() > 0) {
			for (Conta c : contasBancarias) {
				if (c.getNumeroConta() == numeroConta) {
					return c;
				}
			}
		}
		return null;
	}
	
	private static void mensagem(String mensagem) {
		System.out.println(mensagem);
	}

	public static void depositar() {
		
		mensagem("Numero da conta: ");
		
		int numeroConta = input.nextInt();

		Conta conta = encontrarConta(numeroConta);
		if (conta != null) {
			mensagem("Qual o valor desejado para o deposito? ");
			Double valorDeposito = input.nextDouble(); 
			conta.Depositar(valorDeposito);
			
			
			mensagem("Qual o valor desejado para o saque? "+ conta.getSaldo());
		} else {
			mensagem("Conta não encontrada");
		}
		transacoes();
	}

	public static void sacar() {
		
		mensagem("Numero da conta: ");
		
		int numeroConta = input.nextInt();

		Conta conta = encontrarConta(numeroConta);
		mensagem("a conta é uma conta corrente? ");
		char caractere = input.next().charAt(0);
		if (caractere == 'y') {
			conta = ContaCorrente;
			if (conta != null) {
				mensagem("Qual o valor desejado para o saque? ");
				Double valorSaque = input.nextDouble();
				ContaCorrente.Sacar(valorSaque);
				
				
				mensagem("o valor do saque foi realizado e seu saldo atual é: " + conta.getSaldo());
			} else {
				mensagem("conta nao encontrada");
			}
		} else if (caractere == 'n') {
			Conta contaPoupanca = encontrarConta(numeroConta);
			if (contaPoupanca != null) {
				mensagem("Qual o valor desejado para o saque? ");
				Double valorSaque = input.nextDouble();
				contaPoupanca.Sacar(valorSaque);
				
				
				System.out.println("o valor do saque foi realizado e seu saldo atual é: " + contaPoupanca.getSaldo());
			} else {
				System.out.println("conta nao encontrada");
			}

		}
	}

	public static void transferir() {
		System.out.println("Numero da conta de origem: ");
		int numeroContaOrigem = input.nextInt();

		Conta contaDeOrigem = encontrarConta(numeroContaOrigem);
		System.out.println("a conta de origem é uma conta corrente? ");
		char caractere = input.next().charAt(0);
		if (caractere == 'y') {
			contaDeOrigem = ContaCorrente;
			if (contaDeOrigem != null) {
				System.out.println("qual o numero da conta de destino: ");
				int numeroContaDestino = input.nextInt();

				Conta contaDeDestino = encontrarConta(numeroContaDestino);

				if (contaDeDestino != null) {
					System.out.println("Qual o valor a ser transferido: ");
					Double valorDeTransferencia = input.nextDouble();
					ContaCorrente.Transferir(contaDeDestino, valorDeTransferencia);
					System.out.println("A transferencia foi realizada com sucesso e seu saldo atual é "
							+ ContaCorrente.getSaldo());
				} else {
					System.out.println("A conta de destino nao encontrada");
				}

			}
		} else {
			if (contaDeOrigem != null) {
				System.out.println("qual o numero da conta de destino: ");
				int numeroContaDestino = input.nextInt();

				Conta contaDeDestino = encontrarConta(numeroContaDestino);

				if (contaDeDestino != null) {
					System.out.println("Qual o valor a ser transferido: ");
					Double valorDeTransferencia = input.nextDouble();
					contaDeOrigem.Transferir(contaDeDestino, valorDeTransferencia);
					System.out.println("A transferencia foi realizada com sucesso e seu saldo atual é "
							+ contaDeOrigem.getSaldo());
				} else {
					System.out.println("A conta de destino encontrada");
				}

			} else {
				System.out.println("conta de origem nao encontrada");
			}
		}

		transacoes();
	}

}
