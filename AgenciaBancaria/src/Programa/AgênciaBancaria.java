package Programa;

import java.util.ArrayList;


import javax.swing.JOptionPane;

public class AgênciaBancaria {

	static ArrayList<Conta> ContasBancarias;

	public static void main(String[] args) {
		ContasBancarias = new ArrayList<Conta>();
		operacoes();
	}

	public static void operacoes() {

		int operacao = Integer.parseInt(JOptionPane.showInputDialog("---Selecione uma Operação ---"
				+"| Opção 1 - Criar conta" + "| Opção 2 - Depositar" + "| Opção 3 - Sacar" +
				"| Opção 4 - Transferir"+ "| Opção 5 - Listar" + "| Opção 6 - Sair"));
		
		switch (operacao) {
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
		case 5:
			listarContas();
			break;
		case 6:
			JOptionPane.showMessageDialog(null, "Obrigado por usar a nossa agência!");
			System.exit(0);

		default:
			JOptionPane.showMessageDialog(null, "Opção invalida!");

			operacoes();

		}

	}

	public static void criarConta() {
		Pessoa pessoa = new Pessoa();

		pessoa.setNome(JOptionPane.showInputDialog("Nome"));
		pessoa.setCpf(JOptionPane.showInputDialog("Cpf"));
		pessoa.setEmail(JOptionPane.showInputDialog("Email"));

		Conta conta = new Conta(pessoa);

		ContasBancarias.add(conta);
		JOptionPane.showMessageDialog(null, "Sua conta foi criada com sucesso");
		operacoes();

	}

	private static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		if (ContasBancarias.size() > 0) {
			for (Conta c : ContasBancarias) {
				if (c.getNumeroConta() == numeroConta)
					;
				{
					conta = c;
				}
			}
		}
		return conta;
	}

	public static void depositar() {

		int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Número da Conta para depósito: "));

		Conta conta = encontrarConta(numeroConta);

		if (conta != null) {
			Double ValorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja depósitar?: "));
			conta.depositar(ValorDeposito);

			JOptionPane.showInputDialog(null, "Número da Conta para depósito: ");
		} else {

			JOptionPane.showInputDialog(null, "Valor depositado com sucesso!: ");

		}
		operacoes();
	}

	public static void sacar() {
		int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Número da Conta para saque: "));
		
		Conta conta = encontrarConta(numeroConta);

		if (conta != null) {
			Double ValorSaque = Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja sacar?: "));
			conta.sacar(ValorSaque);

		} else {
			JOptionPane.showInputDialog(null, "Conta não encontrada: ");
		}
		operacoes();

	}

	public static void transferir() {
		int numeroContaRemetente = Integer.parseInt(JOptionPane.showInputDialog("Número da Conta do Remetente: "));

		Conta contaRemetente = encontrarConta(numeroContaRemetente);

		if (contaRemetente != null) {
			int numeroContaDestinatario = Integer.parseInt(JOptionPane.showInputDialog("Número da Conta do Destinatário: "));

			Conta ContaDestinatario = encontrarConta(numeroContaDestinatario);

			if (ContaDestinatario != null) {
				Double valor = Double.parseDouble(JOptionPane.showInputDialog("valor da trânsferência"));
				
				contaRemetente.transferir(ContaDestinatario, valor);
			} else {
				JOptionPane.showInputDialog(null, " Conta para depósito não foi encontrada: ");
			}
		} else {
			JOptionPane.showInputDialog(null, ": Conta para transferência não encontrada");
		}
		operacoes();
	}

	public static void listarContas() {
		if (ContasBancarias.size() > 0) {
			for (Conta conta : ContasBancarias) {
				JOptionPane.showMessageDialog(null, conta);
			}
		} else {
			JOptionPane.showInputDialog(null, "Não há Contas cadastradas:");
		
		}
		operacoes();
	}

}
