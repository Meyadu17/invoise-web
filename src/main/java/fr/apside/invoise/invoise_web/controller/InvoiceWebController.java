package fr.apside.invoise.invoise_web.controller;

import fr.apside.invoise.core.controller.InvoiceControllerInterface;
import fr.apside.invoise.core.entity.Invoice;
import fr.apside.invoise.core.service.InvoiceServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// @Component indique que c'est une composant de l'application. Ici on utilise l'annotation fille :
@Controller// On par de stereotype
@RequestMapping("/invoice")
public class InvoiceWebController implements InvoiceControllerInterface {

	// @Autowired permmet l'injection de dépendance sans passer par le setter
	// @Resource est l'équivalent JEE
	// @Inject est l'équivalent JEE 6
	private final InvoiceServiceInterface invoiceServiceInterface;

	// Constructeur : en passant InvoiceServiceInterface en final et en ajoutant le constructeur, l'application ne pourras démmarrer QUE si TOUTES les
	// dépendances sont satisfaites.@Autowired deviens inutile.
	public InvoiceWebController(InvoiceServiceInterface invoiceServiceInterface) {
		this.invoiceServiceInterface = invoiceServiceInterface;
	}

	public void createInvoice(){
		//Ici, on fait comme si on avait une interface graphique avec déjà les infos sais dans l'interface.
		String customerName = "Tesla";

		Invoice invoice=new Invoice();
		invoice.setCustomerName(customerName);

		invoiceServiceInterface.createInvoice(invoice);
	}

	/*
	Une méthode, mais peu courante :
	@RequestMapping("/invoice-home")
	public String displayHome(HttpServletRequest request) {
		System.out.println("La méthode display Home a été invoquée");
		List<Invoice> invoices = invoiceServiceInterface.getInvoiceList();
		request.setAttribute("invoices", invoices);
		return "index";
	}
	 */


	//Une autre méthode :
	//Si je laisse comme ça je suis obligé d'avoir invoice-home comme nom de fichier html. et
	// Plus proche des standards actuels
	@RequestMapping("/home")
	public String displayHome(Model model) {
		System.out.println("La méthode display Home a été invoquée");

		model.addAttribute("invoices", invoiceServiceInterface.getInvoiceList());
		return "invoice-home";
	}

	@RequestMapping("/{id}")
	public String displayInvoice(@PathVariable("id") String number, Model model) {
		System.out.println("La méthode display Invoice a été invoquée");

		model.addAttribute("invoice", invoiceServiceInterface.getInvoiceByNumber(number));
		return "invoice-details";
	}


}
