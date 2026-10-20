package br.com.saitodev.financetracker.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transacao {

    private final String descricao;
    private final BigDecimal valor;
    private final LocalDate data;
    private final TipoTransacao tipoTransacao;
    private final Categoria categoria;

    public Transacao(String descricao, BigDecimal valor, LocalDate data,
                     TipoTransacao tipoTransacao, Categoria categoria) {
    	
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("A descrição é obrigatória.");
        }
        
        if (valor == null || valor.signum() <= 0) {
            throw new IllegalArgumentException("O valor deve ser maior que zero.");
        }
        
        if (data == null || tipoTransacao == null || categoria == null) {
            throw new IllegalArgumentException("Data, tipo e categoria são obrigatórios.");
        }
        
        this.descricao = descricao.trim();
        this.valor = valor;
        this.data = data;
        this.tipoTransacao = tipoTransacao;
        this.categoria = categoria;
    }

    public Transacao(String descricao, BigDecimal valor,
                     TipoTransacao tipoTransacao, Categoria categoria) {
        this(descricao, valor, LocalDate.now(), tipoTransacao, categoria);
    }
 
    public String getDescricao() {
		return descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public LocalDate getData() {
		return data;
	}

	public TipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public BigDecimal getValorComSinal() {
        return tipoTransacao == TipoTransacao.RECEITA ? valor : valor.negate();
    }

    @Override
    public String toString() {
        return data + " | " + tipoTransacao + " | " + categoria + " | " + descricao + " | R$ " + valor;
    }
}