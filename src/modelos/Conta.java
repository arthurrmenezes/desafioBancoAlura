package modelos;

import utils.FormataValor;

public class Conta {
	
	private double saldo = 0;
	private int numeroDaConta = 1;
	private Cliente cliente;
	private static int contadorDeContas = 1;
	
	public Conta(Cliente cliente) {
		this.numeroDaConta = contadorDeContas;
		this.cliente = cliente;
		contadorDeContas++;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public int getNumeroDaConta() {
		return this.numeroDaConta;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public String toString() {
		return  "\n Nome: " + cliente.getNome() +
				"\n CPF: " + cliente.getCpf() +
				"\n Número da Conta: " + getNumeroDaConta() +
				"\n Saldo atual: " + FormataValor.DoubleToString(getSaldo());	   
	}
	
	public void deposita(double valor) {
		if (valor > 0) {
			saldo = saldo + valor;
			System.out.println("Depósito realizado com sucesso!");
			System.out.println("Saldo atual: " + FormataValor.DoubleToString(saldo));
		} else {
			System.out.println("Valor inválido. Por favor, tente novamente.");
		}
	}
	
	public void saca(double valor) {
		if (valor > 0 && valor <= saldo) {
			saldo = saldo - valor;
			System.out.println("Saque realizado com sucesso!");
			System.out.println("Saldo atual: " + FormataValor.DoubleToString(saldo));
		} else if (valor < 0) {
			System.out.println("Erro! Saque cancelado.\nPor favor, insira um valor válido.");
		} else if (valor > saldo) {
			System.out.println("Erro! Saque cancelado.\nNão foi possível realizar o saque. O valor inserido é maior que"
					+ " o saldo disponível na conta.");
		} else {
			System.out.println("Não foi possível realizar o saque. Por favor, confira os dados inseridos e tente novamente.");
		}
	}
	
	public void transfere(Conta conta, double valor) {
		if (valor > 0 && valor <= saldo) {
			saldo = saldo - valor;
			conta.saldo = conta.saldo + valor;
			System.out.println("Transferência realizada com sucesso!");
			System.out.println("Saldo atual: " + FormataValor.DoubleToString(saldo));
		} else if (valor < 0) {
			System.out.println("Erro! Transferência cancelada.\n Por favor, insira um valor válido.");
		} else if (valor > saldo) {
			System.out.println("Erro! Transferência cancelada.\n Não foi possível realizar a transferência, o valor inserido é"
					+ " maior que o saldo disponível na conta.");
		} else {
			System.out.println("Não foi possível realizar a transferência. Por favor, confira os dados inseridos e tente novamente.");
		}
	}
	
}
