package br.com.saitodev.financetracker.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.saitodev.financetracker.dto.TransacaoRequest;
import br.com.saitodev.financetracker.model.Categoria;
import br.com.saitodev.financetracker.model.Transacao;
import br.com.saitodev.financetracker.repository.TransacaoRepository;

@Service
public class TransacaoService {
	
	private final TransacaoRepository repository;
	
	public TransacaoService(TransacaoRepository repository) {
		this.repository = repository;
	}
	
	public Transacao cadastrar(TransacaoRequest request) {
		LocalDate data = request.date() != null ? request.date() : LocalDate.now();
		
		Transacao transacao = new Transacao(
				request.descricao(),
				request.valor(),
				data,
				request.tipoTransacao(),
				new Categoria(request.categoria()));
		
		return repository.salvar(transacao);
	}
	
	public List<Transacao> listar() {
		return repository.listarTodas();
	}
	
}
