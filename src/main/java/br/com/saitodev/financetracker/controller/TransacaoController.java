package br.com.saitodev.financetracker.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.saitodev.financetracker.dto.TransacaoRequest;
import br.com.saitodev.financetracker.dto.TransacaoResponse;
import br.com.saitodev.financetracker.model.Transacao;
import br.com.saitodev.financetracker.service.TransacaoService;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {
	
	private final TransacaoService service;
	
	public TransacaoController(TransacaoService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<TransacaoResponse> cadastrar(@RequestBody TransacaoRequest request) {
		Transacao criada = service.cadastrar(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(TransacaoResponse.de(criada));
	}
	
	@GetMapping
	public List<TransacaoResponse> listar() {
		return service.listar().stream()
				.map(TransacaoResponse::de)
				.toList();
	}
}
