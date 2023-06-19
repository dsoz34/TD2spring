package com.inti;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.TraitementBDD;

@Controller
@RequestMapping("produit")
public class ProduitController {

	
	@GetMapping("affichage")
	public String affichageNomProduit(@RequestParam(value = "nom", required = false, defaultValue = "Produit_par_Defaut") String n, Model m) {
		
		m.addAttribute("nomP", n);
		return "affiche";
	}
	
	
	@GetMapping("affichagePrix")
	public String affichagePrixProduit(@RequestParam(value = "nom", required = false, defaultValue = "Produit_par_Defaut") String n, Model m) {
		
		
		m.addAttribute("nomP", n);
		TraitementBDD tbdd = new TraitementBDD();
		Produit P = tbdd.chercherProduit(n);
		
		m.addAttribute("prixP", P.getPrix());
		
		return "affichePrix";
	}
	
	
	@GetMapping("calcul")
	public String affichageAllProduit(@RequestParam(value = "nom", required = false, defaultValue = "Produit_par_Defaut") String n, Model m) {
		
		
		m.addAttribute("nomP", n);
		TraitementBDD tbdd = new TraitementBDD();
		Produit P = tbdd.chercherProduit(n);
		
		m.addAttribute("prixTTCP", P.getPrix());
		
		m.addAttribute("prixHTP", P.calculHT());
		
		return "afficheAll";
	}
	
	
	
	
	
	
	
	
}
