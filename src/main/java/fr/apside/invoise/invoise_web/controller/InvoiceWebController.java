package fr.apside.invoise.invoise_web.controller;

import fr.apside.invoise.core.service.InvoiceServiceInterface;
import fr.apside.invoise.invoise_web.form.InvoiceForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

// @Component indique que c'est un composant de l'application. Ici on utilise l'annotation fille :
@Controller// On par de stereotype
@RequestMapping("/invoice")
public class InvoiceWebController {

	// @Autowired permet l'injection de dépendance sans passer par le setter
	// @Resource est l'équivalent JEE
	// @Inject est l'équivalent JEE 6
	private final InvoiceServiceInterface invoiceServiceInterface;

	// Constructeur : en passant InvoiceServiceInterface en final et en ajoutant le constructeur, l'application ne pourra démarrer QUE si TOUTES les
	// dépendances sont satisfaites.@Autowired devient inutile.
	public InvoiceWebController(InvoiceServiceInterface invoiceServiceInterface) {
		this.invoiceServiceInterface = invoiceServiceInterface;
	}

	/*@PostMapping
	// ModelAttribute va permettre d'instancier l'objet Invoice et de le fournir en entrée (équivaut à Invoice invoice=new Invoice();)
	// ModelAttribute va donner un id à l'objet
	// BindingResult doit être placé dans la signature après le dernier @ModelAttribute)
	public String createInvoice(@Valid @ModelAttribute InvoiceForm invoiceForm, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "invoice-create-form";
		}
		Invoice invoice = new Invoice();
		invoice.setCustomerName(invoiceForm.getCustomerName());
		invoice.setOrderNumber(invoiceForm.getOrderNumber());

		invoiceServiceInterface.createInvoice(invoice);

		return "invoice-created";
	}*/
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
	@GetMapping("/home")
	public String displayHome(Model model) {
		System.out.println("La méthode display Home a été invoquée");

		model.addAttribute("invoices", invoiceServiceInterface.getInvoiceList());
		return "invoice-home";
	}

	/*@GetMapping("/{id}")
	public String displayInvoice(@PathVariable("id") String number, Model model) {
		System.out.println("La méthode display Invoice a été invoquée");

		model.addAttribute("invoice", invoiceServiceInterface.getInvoiceByNumber(number));
		return "invoice-details";
	}*/

	@GetMapping("/create-form")
	public String displayInvoiceCreateForm(@ModelAttribute InvoiceForm invoice) {
		return "invoice-create-form";
	}

}
