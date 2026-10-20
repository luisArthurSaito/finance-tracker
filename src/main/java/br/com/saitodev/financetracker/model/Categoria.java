package br.com.saitodev.financetracker.model;

public class Categoria {
	
	private final String nome;
	
	public Categoria(String nome) {
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("O nome da categoria é obrigatório!");
		}
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categoria outra)) return false;
        return nome.equalsIgnoreCase(outra.nome);
    }

    @Override
    public int hashCode() {
        return nome.toLowerCase().hashCode();
    }
    
    @Override
    public String toString() {
        return nome;
    }
    
}
