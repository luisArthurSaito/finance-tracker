package br.com.saitodev.financetracker.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.saitodev.financetracker.model.Categoria;
import br.com.saitodev.financetracker.model.TipoTransacao;
import br.com.saitodev.financetracker.model.Transacao;

class RelatorioServiceTest {

    private RelatorioService service;
    private List<Transacao> transacoes;

    @BeforeEach
    void preparar() {
        service = new RelatorioService();

        Categoria salario = new Categoria("Salário");
        Categoria comida = new Categoria("Alimentação");
        Categoria contas = new Categoria("Contas");

        transacoes = List.of(
                new Transacao("Salário", new BigDecimal("2500.00"),
                        LocalDate.of(2026, 10, 5), TipoTransacao.RECEITA, salario),
                new Transacao("Mercado", new BigDecimal("320.50"),
                        LocalDate.of(2026, 10, 8), TipoTransacao.DESPESA, comida),
                new Transacao("Lanche", new BigDecimal("28.90"),
                        LocalDate.of(2026, 10, 10), TipoTransacao.DESPESA, comida),
                new Transacao("Padaria", new BigDecimal("15.00"),
                        LocalDate.of(2026, 10, 12), TipoTransacao.DESPESA, new Categoria("ALIMENTAÇÃO")),
                new Transacao("Conta de luz", new BigDecimal("150.00"),
                        LocalDate.of(2026, 9, 20), TipoTransacao.DESPESA, contas));
        
    }
    
    @Test
    void calculaSaldoSomandoReceitasEDescontandoDespesas() {
        assertThat(service.calcularSaldo(transacoes)).isEqualByComparingTo("1985.60");
    }
    
    @Test
    void agrupaDespesasPorCategoriaIgnorandoMaiusculas() {
    	Map<Categoria, BigDecimal> total = service.totalPorCategoria(transacoes);
    	
    	assertThat(total).hasSize(2);
    	assertThat(total.get(new Categoria("Alimentação"))).isEqualByComparingTo("364.40");
    	assertThat(total.get(new Categoria("Contas"))).isEqualByComparingTo("150.00");
    }
    
    @Test
    void encontraMaiorDespesa() {
    	Optional<Transacao> maior = service.maiorDespesa(transacoes);
    	
    	assertThat(maior).isPresent();
        assertThat(maior.get().getDescricao()).isEqualTo("Lanche");
    }
    
}
    
    
    