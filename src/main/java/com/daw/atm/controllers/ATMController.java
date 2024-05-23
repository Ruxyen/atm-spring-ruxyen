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
import com.daw.atm.models.Compte;
import com.daw.atm.models.Operacio;
import com.daw.atm.models.Targeta;
import com.daw.atm.models.DTO.Credencials;
import com.daw.atm.models.DTO.Diners;
import com.daw.atm.models.DTO.Transfer;

@Controller
public class ATMController {

    @Autowired
    ATM atm; //crea un objecte ATM de forma automàtica

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
                Targeta targeta = atm.getBanc().getTargeta(credencials.getNumber());
                if (targeta != null && targeta.isBloqueada()) {
                    model.addAttribute("missatge", "La targeta està bloquejada, prova amb una altra");
                } else {
                    model.addAttribute("missatge", "Error en les credencials.");
                }
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
        // Obtener la información de la cuenta actual desde el ATM
        Compte compteActual = atm.getTargetaActual().getCompteCorrent();

        // Obtener todas las cuentas asociadas al cliente
        ArrayList<Compte> altresComptes = atm.getBanc().getLlistaComptesDelClient(compteActual.getPropietari());

        // Agregar los atributos al modelo
        model.addAttribute("nomCompte", compteActual.getPropietari().getNom());
        model.addAttribute("apellidos", compteActual.getPropietari().getCognom());
        model.addAttribute("numeroCompte", compteActual.getNumero());
        model.addAttribute("numeroTargeta", atm.getTargetaActual().getNumero());
        model.addAttribute("pin", atm.getTargetaActual().getPin());
        model.addAttribute("dataNaixement", compteActual.getPropietari().getDataNaixement());
        model.addAttribute("altresComptes", altresComptes);
        model.addAttribute("correo", compteActual.getPropietari().getEmail());

        return "operacions";
    }

    @GetMapping("/ingressar")
    public String ingressar(Model model) {
        model.addAttribute("diners", new Diners());
        return "ingressar";
    }

    @PostMapping("/ingressar")
    public String processarIngressar(@ModelAttribute Diners diners, Model model) {
        try {
            int quantitat = Integer.parseInt(diners.getQuantitat());
            if (quantitat % 10 == 0) {
                atm.ingressar(quantitat);
                model.addAttribute("missatge", "S'ha realitzat l'ingrés");
                return "ingressar";
            } else {
                model.addAttribute("missatge", "La quantitat ha de ser un múltiple de 10.");
            }
        } catch (Exception e) {
            model.addAttribute("missatge", "La quantitat ha de ser un enter.");
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
        try {
            int quantitat = Integer.parseInt(diners.getQuantitat());
            if (quantitat % 10 != 0) {
                model.addAttribute("missatge", "La quantitat ha de ser un múltiple de 10.");
            } else {
                boolean success = atm.retirar(quantitat);
                if (success) {
                    model.addAttribute("missatge", "S'ha fet l'extracció");
                    return "retirar";
                } else {
                    model.addAttribute("missatge", "No s'ha realitzat l'extracció. Vigila amb el saldo del compte.");
                }
            }
        } catch (Exception e) {
            model.addAttribute("missatge", "La quantitat ha de ser un enter.");
        }
        return "retirar";
    }

    @GetMapping("/transferencia")
    public String transferencia(Model model) {
        // Obtener la información de la cuenta actual desde el ATM
        Compte compteActual = atm.getTargetaActual().getCompteCorrent();

        // Obtener todas las cuentas asociadas al cliente
        ArrayList<Compte> altresComptes = atm.getBanc().getLlistaComptesDelClient(compteActual.getPropietari());

        // Agregar los atributos al modelo
        model.addAttribute("transfer", new Transfer());
        model.addAttribute("numeroCompte", compteActual.getNumero());
        model.addAttribute("altresComptes", altresComptes);

        return "transferencia";
    }

    @PostMapping("/transferencia")
    public String processarTransferencia(@ModelAttribute Transfer transf, Model model) {
        try {
            int Quantitat = Integer.parseInt(transf.getQuantitat());
            String numeroDestino = transf.getNumero();
            Compte compteActual = atm.getTargetaActual().getCompteCorrent();

            // Verificar si el número de cuenta de destino es igual al número de cuenta
            // actual
            if (numeroDestino.equals(compteActual.getNumero())) {
                model.addAttribute("missatge", "No puedes transferir a la misma cuenta de origen.");
                return "transferencia";
            }

            // Procesar la transferencia
            if (atm.transferencia(Quantitat, numeroDestino)) {
                model.addAttribute("missatge", "Operació efectuada");
                return "transferencia";
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
