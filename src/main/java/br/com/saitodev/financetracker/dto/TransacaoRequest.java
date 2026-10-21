package br.com.saitodev.financetracker.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.saitodev.financetracker.model.TipoTransacao;

public record TransacaoRequest (
		
		String descricao,
		BigDecimal valor,
		LocalDate date,
		TipoTransacao tipoTransacao,
		String categoria) {

}
