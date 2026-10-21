package br.com.saitodev.financetracker.repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Repository;

import br.com.saitodev.financetracker.model.Transacao;

@Repository
public class TransacaoRepository {

	private final List<Transacao> transacoes = new CopyOnWriteArrayList<>();
	
	public Transacao salvar(Transacao transacao) {
		transacoes.add(transacao);
		return transacao;
	}
	
	public List<Transacao> listarTodas() {
		return List.copyOf(transacoes);
	}
	
}
