package br.com.saitodev.financetracker.service;

import java.math.BigDecimal;
import java.util.List;

import br.com.saitodev.financetracker.model.Transacao;

public class RelatorioService {
	
	public BigDecimal calcularSaldo(List<Transacao> transacoes) {
		return transacoes.stream()
				.map(Transacao::getValorComSinal)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
	
	
}
