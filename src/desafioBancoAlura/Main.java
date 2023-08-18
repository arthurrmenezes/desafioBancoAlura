package desafioBancoAlura;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner le = new Scanner (System.in);
		
		String nome = "Arthur";
		double saldo = 500, valorDeposito = 0, valorReceber;
		int operacao = 0, contador = 1;
		
		System.out.println("*************************************************");
		System.out.println("Bem-vindo ao banco, " + nome + "!");
		System.out.printf("Seu saldo atual é de R$ %.2f", saldo);
		System.out.println("\n*************************************************");
		
		while (contador > 0) {
			System.out.println("\n--- Operações disponíveis:");
			System.out.println("1 - Consultar saldo\n2 - Receber valor\n3 - Transferência\n4 - Sair");
			System.out.print("\nDigite a opção desejada: ");
			operacao = le.nextInt();
			
			if (operacao == 1) {
				System.out.printf("\nSeu saldo atual é de R$ %.2f \n", saldo);
				contador++;
			} else if (operacao == 2) {
				System.out.println("Digite o valor que você deseja receber.");
				System.out.print("R$ ");
				valorReceber = le.nextDouble();
				saldo = saldo + valorReceber;
				System.out.printf("Saldo atualizado! %.2f \n", saldo);
				contador++;
			} else if (operacao == 3) {
				System.out.println("Digite o valor que você deseja transferir.");
				System.out.print("R$ ");
				valorDeposito = le.nextDouble();
				if (valorDeposito > saldo) {
					System.out.println("O valor da transferência é maior que o seu saldo.");
					System.out.println("Pagamento recusado.");
					contador++;
				} else {
					System.out.printf("Você depositou R$ %.2f \n", valorDeposito);
					saldo = saldo - valorDeposito;
					System.out.printf("Seu saldo atual é de R$ %.2f \n", saldo);
					contador++;
				} 
			} else if (operacao == 4) {
				System.out.println("\nObrigado por usar nossos serviços.");
				System.out.println("Volte sempre!");
				break;
			} else if (operacao < 1 || operacao > 4) {
				System.out.println("Ops... Opção inválida!");
				System.out.println("Tente novamente.");
				contador++;
			}
		}
		
		
		le.close();
		
	}

}
