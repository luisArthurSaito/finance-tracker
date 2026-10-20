package br.com.saitodev.financetracker.service;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.saitodev.financetracker.model.Categoria;
import br.com.saitodev.financetracker.model.TipoTransacao;
import br.com.saitodev.financetracker.model.Transacao;


public class RelatorioService {
	
	public BigDecimal calcularSaldo(List<Transacao> transacoes) {
		return transacoes.stream()
				.map(Transacao::getValorComSinal)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
	
	public Map<Categoria, BigDecimal> totalPorCategoria(List<Transacao> transacoes) {
		return transacoes.stream()
				.filter(t -> t.getTipoTransacao() == TipoTransacao.DESPESA)
				.collect(Collectors.groupingBy(
						Transacao::getCategoria,
						Collectors.reducing(BigDecimal.ZERO, Transacao::getValor, BigDecimal::add)));
	}
	
	public Optional<Transacao> maiorDespesa(List<Transacao> transacoes) {
		return transacoes.stream()
				.filter(t -> t.getTipoTransacao() == TipoTransacao.DESPESA)
				.max(Comparator.comparing(Transacao::getValor));
	}
	
	
	public Map<YearMonth, BigDecimal> gastoPorMes(List<Transacao> transacoes) {
		return transacoes.stream()
				.filter(t -> t.getTipoTransacao() == TipoTransacao.DESPESA)
				.collect(Collectors.groupingBy(
						t -> YearMonth.from(t.getData()),
						Collectors.reducing(BigDecimal.ZERO, Transacao::getValor, BigDecimal::add)));
					
	}
	
	
}
