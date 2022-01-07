package org.sid.web;

import org.sid.metier.IBanqueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BanqueController {
	@Autowired
	private IBanqueMetier banqueMetier;
	@RequestMapping("/operations") // lors de la saisie dans la barre de recherche on aura la page html comptes generer
	public String index() {
		return "comptes";
	}
	

}
