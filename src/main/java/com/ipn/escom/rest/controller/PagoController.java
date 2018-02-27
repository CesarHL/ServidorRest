package com.ipn.escom.rest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ipn.escom.rest.model.Pago;

@Controller
@RequestMapping("/pago")
public class PagoController {

	/**
	 * 
	 * */
	@RequestMapping("/getAll")
	@ResponseBody
	public Map<String, Map<String, Pago>> getAllPagos() {
		
		Map<String, Pago> pagos = new HashMap<>();
		Pago pagoServicioMedico = new Pago(1, 430.5, "000002", "Bancomer", "ESCOM");
		Pago pagoIdiomaIngles = new Pago(2, 480.5, "000003", "Bancomer", "ESCOM");
		Pago pagoServicioFotocopiado = new Pago(3, 30.3, "000004", "Bancomer", "ESCOM");
		
		pagos.put("000002", pagoServicioMedico);
		pagos.put("000003", pagoIdiomaIngles);
		pagos.put("000004", pagoServicioFotocopiado);
		
		Map<String, Map<String, Pago>> pagoDePagos = new HashMap<>();
		pagoDePagos.put("000001", pagos);

		
		return pagoDePagos;
	}

	/**
	 * 
	 * */
	@RequestMapping("/getFirstOne")
	@ResponseBody
	public void getFirstOne() {

	}

	/**
	 * 
	 * */
	@RequestMapping("/getById/{id}")
	@ResponseBody
	public void getById(@PathVariable(value = "id") Integer id) {

	}

	/**
	 * 
	 * */
	public void insertPago() {

	}

	/**
	 * 
	 * */
	public void updatePago() {

	}

	/**
	 * 
	 * */
	public void deletePago() {

	}
}
