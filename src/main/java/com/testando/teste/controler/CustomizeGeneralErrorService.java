package com.testando.teste.controler;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * @author berkson
 * @since 11 de mar de 2020
 * 
 */
@Service
public class CustomizeGeneralErrorService {

	public Map<String, Object> organize(HttpServletRequest req) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();

		// variáveis recebem os valores repassados
		Integer status = (Integer) req.getAttribute("javax.servlet.error.status_code");
		String title = HttpStatus.valueOf(status).getReasonPhrase();
		String detail = (String) req.getAttribute("javax.servlet.error.message");

		map.put("title", title);
		map.put("status", status);
		map.put("detail", detail);

		// verifica erro específico não capturável pelo ProblemHandler
		this.expiredJwtToken(map);
		this.invalidJwtToken(map);
		this.notExternalContextResource(map);

		return map;
	}

	private void expiredJwtToken(Map<String, Object> map) {
		String message = "erro.tokenexp";
		if (map.get("detail").toString().contains("Token Expirado")) {
			map.put("title", HttpStatus.UNAUTHORIZED);
			map.put("status", HttpStatus.UNAUTHORIZED.value());
			map.put("detail", message);
		}
	}

	private void invalidJwtToken(Map<String, Object> map) {
		String message = "erro.tokeninv";
		if (map.get("detail").toString().contains("Token Inválido")) {
			map.put("title", HttpStatus.PRECONDITION_FAILED);
			map.put("status", HttpStatus.PRECONDITION_FAILED.value());
			map.put("detail", message);
		}
	}

	// Verifica se foi feita uma query com uma barra no final ex:
	// https://localhost:8443/scc/api/query/cis/
	// resultando em um erro: Not Found in ExternalContext as a Resource e retorna
	// mensagem padrão
	private void notExternalContextResource(Map<String, Object> map) {
		String message = "erro.externalcontext";
		if (map.get("detail").toString().contains("Not Found in ExternalContext as a Resource")) {
			map.put("title", HttpStatus.NOT_FOUND);
			map.put("status", HttpStatus.NOT_FOUND.value());
			map.put("detail", message);
		}
	}

}
