package com.daw.atm.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.daw.atm.models.ATM;
import com.daw.atm.models.CanviarPIN;
import com.daw.atm.models.Operacio;
import com.daw.atm.models.DTO.Credencials;
import com.daw.atm.models.DTO.Diners;
import com.daw.atm.models.DTO.Transfer;



@Controller
public class ATMController {

	@Autowired
	ATM atm;

	@GetMapping("/")
	public String mostrarFormulariLogin(Model model) {
		model.addAttribute("credencials", new Credencials());
		return "login";
	}

	@PostMapping("/login")
	public String obtenirDadesLogin(@ModelAttribute Credencials credencials, Model model) {
		System.out.println(credencials.getNumber());
		System.out.println(credencials.getPIN());

		try {
			int PIN = Integer.parseInt(credencials.getPIN());
			boolean ok = atm.assignarTargeta(credencials.getNumber(), PIN);

			if (!ok) {
				model.addAttribute("missatge", "Error en les credencials");
				return "login";
			}
		} catch (Exception e) {
			model.addAttribute("missatge", "Error el PIN ha de ser numeric");
			return "login";
		}

		return "redirect:/operacions";
	}

	@GetMapping("/operacions")
	public String operacions(Model model) {
		return "operacions";
	}

	@GetMapping("/ingressar")
	public String ingressar(Model model) {
		model.addAttribute("diners", new Diners());
		return "ingressar";
	}

	@PostMapping("/ingressar")
	public String processarIngressar(@ModelAttribute Diners diners, Model model) {

		// if(!atm.isLogged()){
		// return "redirect:";
		// }

		try {
			int quantitat = Integer.parseInt(diners.getQuantitat());
			atm.ingressar(quantitat);
			model.addAttribute("missatge", "S'ha realitzat l'ingrés");

		} catch (Exception e) {
			model.addAttribute("missatge", "Quantitat ha de ser enter");
		}
		return "ingressar";
	}

	@GetMapping("/retirar")
	public String treure(Model model) {
		model.addAttribute("diners", new Diners());
		return "retirar";
	}

	@PostMapping("/retirar")
	public String processarTreure(@ModelAttribute Diners diners, Model model) {

		// if(!atm.isLogged()){
		// return "redirect:";
		// }

		try {
			int quantitat = Integer.parseInt(diners.getQuantitat());
			atm.retirar(quantitat);
			model.addAttribute("missatge", "S'ha fet l'extracció");

		} catch (Exception e) {
			model.addAttribute("missatge", "Quantitat ha de ser enter");
		}
		return "retirar";
	}

	@GetMapping("/transferencia")
	public String transferencia(Model model) {
		model.addAttribute("transfer", new Transfer());
		return "transferencia";
	}

	@PostMapping("/transferencia") // Numero CC == ES102500000001
	public String processarTransferencia(@ModelAttribute Transfer transf, Model model) {
		try {
			int Quantitat = Integer.parseInt(transf.getQuantitat());
			if (atm.transferencia(Quantitat, transf.getNumero())) {
				model.addAttribute("missatge", "Operació efectuada");
			} else {
				model.addAttribute("missatge", "Operació incorrecta");
			}

		} catch (Exception e) {
			model.addAttribute("missatge", "Error en la quantitat");

		}
		return "transferencia";
	}

	@GetMapping("/moviments")
	public String moviment(Model model) {
		ArrayList<Operacio> operacions = atm.getTargetaActual().getCompteCorrent().getLlistaMoviments();
		model.addAttribute("operacions", operacions);
		return "moviments";
	}

	@GetMapping("/canviarPIN")
	public String getCanviarPIN(Model model) {
		model.addAttribute("changePIN", new CanviarPIN());
		return "canviarPIN";
	}

	@PostMapping("/canviarPIN")
	public String postCanviarPIN(@ModelAttribute CanviarPIN changePIN, Model model) {
		if (changePIN.getNewPIN() != changePIN.getConfirmNewPIN()) {
			model.addAttribute("errorMessage", "El nou PIN i la confirmació no coincideixen");
			return "canviarPIN";
		}

		boolean result = atm.canviarPIN(changePIN.getCurrentPIN(), changePIN.getNewPIN());
		if (!result) {
			model.addAttribute("errorMessage", "El PIN actual no és correcte");
			return "canviarPIN";
		}

		return "redirect:/operacions";
	}



}
