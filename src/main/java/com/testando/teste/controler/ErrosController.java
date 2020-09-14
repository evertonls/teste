/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testando.teste.controler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * @author berkson
 * @since 27 de fev de 2020
 *
 */
@Controller
public class ErrosController /* implements ErrorController */ {

//	@Autowired
//	private CustomizeGeneralErrorService cges;
//
//	@RequestMapping(path = "/error")
//	public String handleXhtmlError() {
//
//		return "/erros/msgpadrao";
//
//	}
//
//	@RequestMapping(path = "/error", produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public Map<String, Object> handleJsonError(HttpServletRequest req) {
//
//		return cges.organize(req);
//	}
//
//	@Override
//	public String getErrorPath() {
//		return "/error";
//	}

}
