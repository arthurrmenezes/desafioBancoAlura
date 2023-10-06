package desafioBancoAlura;

import java.util.ArrayList;
import java.util.Scanner;

import modelos.Cliente;
import modelos.Conta;

public class Main {
	
	static Scanner le = new Scanner(System.in);
	static ArrayList<Conta> listaDeContas;
	
	public static void main(String[] args) {
		
		listaDeContas = new ArrayList<Conta>();
		
		System.out.println("Seja bem-vindo(a) ao banco!");
		menuOperacoes();
	}
	
	public static void menuOperacoes() {
		System.out.println("\nOperações disponíveis: ");
		System.out.println("1 - Criar Conta");
		System.out.println("2 - Depósito");
		System.out.println("3 - Saque");
		System.out.println("4 - Transferência");
		System.out.println("5 - Listar contas");
		System.out.println("6 - Sair");
		System.out.print("\nDigite a opção desejada: ");
		
		int operacoes = le.nextInt();
		
		switch (operacoes) {
		
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
			System.out.println("Obrigado por utilizar nossos serviços!");
			System.exit(0);
		default:
			System.out.println("\nErro! Número Inválido.\nDigite uma opção válida.");
			menuOperacoes();
			break;			
		}
	}
	
	public static void criarConta() {
		System.out.print("\nNome: ");
		String nome = le.next();
		System.out.print("CPF: ");
		String cpf = le.next();
		
		Cliente cliente = new Cliente(nome, cpf);
		Conta conta = new Conta(cliente);
		
		listaDeContas.add(conta);
		
		System.out.println("\nConta criada com sucesso! Seja bem-vindo!");
		
		menuOperacoes();
	}
	
	private static Conta encontrarConta(int numeroDaConta) {
		Conta conta = null;
		if (listaDeContas.size() > 0) {
			for (Conta c : listaDeContas) {
				if (c.getNumeroDaConta() == numeroDaConta) {
					conta = c;
					break;
				}
			} 
		} else {
			System.out.println("Não há contas registradas no momento. Seja o primeiro e crie já sua conta!");
		} return conta;
	}
	
	public static void depositar() {
		System.out.print("Número da Conta: ");
		int numeroDaConta = le.nextInt();
		
		Conta conta = encontrarConta(numeroDaConta);
		
		if (conta != null) {
			System.out.print("Valor que deseja depositar: ");
			double valorDeposito = le.nextDouble();
			conta.deposita(valorDeposito);
		} else {
			System.out.println("Erro! A Conta não foi encontrada.");
		}
		menuOperacoes();
	}
	
	public static void sacar() {
		System.out.print("Número da Conta: ");
		int numeroDaConta = le.nextInt();
		
		Conta conta = encontrarConta(numeroDaConta);
		
		if (conta != null) {
			System.out.print("Valor que deseja sacar: ");
			double valorSaque = le.nextDouble();
			conta.saca(valorSaque);
		} else {
			System.out.println("Erro! A Conta não foi encontrada.");
		}
		menuOperacoes();	
	}
	
	public static void transferir() {
		System.out.print("\nNúmero da Conta remetente: ");
		int numeroDaContaRemetente = le.nextInt();
		
		Conta contaRemetente = encontrarConta(numeroDaContaRemetente);
		
		if (contaRemetente != null) {
			System.out.print("Número da conta do destinatário: ");
			int numeroDaContaDestinatario = le.nextInt();
			
			Conta contaDestinatario = encontrarConta(numeroDaContaDestinatario);
			
			if (contaDestinatario != null) {
				System.out.print("Valor que deseja transferir: ");
				double valorTransferencia = le.nextDouble();
				contaRemetente.transfere(contaDestinatario, valorTransferencia);
			} 
		} else {
			System.out.println("Erro! A Conta não foi encontrada.");
		}
		menuOperacoes();	
	}
	
	public static void listarContas() {
		if (listaDeContas.size() > 0) {
			for (Conta conta : listaDeContas) {
				System.out.println(conta);
			} 
		} else {
			System.out.println("Erro! Não há contas registradas no momento.");
		}
		menuOperacoes();
	}
	

}
