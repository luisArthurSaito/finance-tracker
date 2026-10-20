package br.com.saitodev.financetracker;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.saitodev.financetracker.model.Categoria;
import br.com.saitodev.financetracker.model.TipoTransacao;
import br.com.saitodev.financetracker.model.Transacao;

public class demo {

    public static void main(String[] args) {
        Categoria salario = new Categoria("Salário");
        Categoria comida = new Categoria("Alimentação");

        List<Transacao> transacoes = new ArrayList<>();
        transacoes.add(new Transacao("Salário de outubro", new BigDecimal("2500.00"),
                LocalDate.of(2026, 10, 5), TipoTransacao.RECEITA, salario));
        transacoes.add(new Transacao("Mercado", new BigDecimal("100"),
                LocalDate.of(2026, 10, 8), TipoTransacao.DESPESA, comida));
        transacoes.add(new Transacao("Lanche", new BigDecimal("28.90"),
                LocalDate.of(2026, 10, 10), TipoTransacao.DESPESA, comida));

        BigDecimal saldo = BigDecimal.ZERO;
        for (Transacao t : transacoes) {
            System.out.println(t);
            saldo = saldo.add(t.getValorComSinal());
        }
        System.out.println("Saldo: R$ " + saldo);
    }
}
