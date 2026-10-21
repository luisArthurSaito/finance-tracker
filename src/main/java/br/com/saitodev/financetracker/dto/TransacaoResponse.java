package br.com.saitodev.financetracker.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.saitodev.financetracker.model.TipoTransacao;
import br.com.saitodev.financetracker.model.Transacao;

public record TransacaoResponse(
		
		String descricao,
		BigDecimal valor, 
		LocalDate data,
		TipoTransacao tipoTransacao,
		String categoria) {

	public static TransacaoResponse de(Transacao t) {
		return new TransacaoResponse(
				t.getDescricao(),
				t.getValor(),
				t.getData(),
				t.getTipoTransacao(),
				t.getCategoria().getNome());		
	}

}
