package modelos;

public class Cliente {
	
	private String nome;
	private String cpf;
	private static int counter = 1;
	private int numeroPessoa;
	
	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public String toString() {
		System.out.println("\nDados do Cliente");
		return "\nNome: " + getNome() +
			   "\nCPF: " + getCpf();
	}
	
	
}
