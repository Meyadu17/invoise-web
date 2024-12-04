package fr.apside.invoise.invoise_web.api;

import fr.apside.invoise.core.entity.Invoice;
import fr.apside.invoise.core.service.InvoiceServiceInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// @Component indique que c'est un composant de l'application. Ici on utilise l'annotation fille :
// @Controller On parle de stereotype
@RestController // permmet d'enlever les anorations @ResponseBody dans les méthodes
@RequestMapping("/invoice")
public class InvoiceResource {

	private final InvoiceServiceInterface invoiceServiceInterface;

	public InvoiceResource(InvoiceServiceInterface invoiceServiceInterface) {
		this.invoiceServiceInterface = invoiceServiceInterface;
	}

	// @ResquesBody va nous permettre de récupérer un JSON de l'objet. Il fait l'inverse de @ResponseBody
	@PostMapping
	public Invoice create(@RequestBody Invoice invoice){

		return invoiceServiceInterface.createInvoice(invoice);
	}

	@GetMapping
	public List<Invoice> list() {
		System.out.println("La méthode display Home a été invoquée");

		return invoiceServiceInterface.getInvoiceList();
	}

	// En retournant l'objet l'idée est de convertir celui-ci en XML ou en JSON ou autre afin que l'émetteur en reçoive une représentation textuelle qu'il
	// exploitera à sa guise. Pour cela, il faut rajouter @ResponseBoby
	/*
	deux façons de faire :
	1.
	@GetMapping("/{id}")
	public @ResponseBody Invoice get(@PathVariable("id") String number) {code ici}
	2.
	@GetMapping("/{id}")
	@ResponseBody
	public Invoice get(@PathVariable("id") String number) {code ici}
	 */
	// Avec cette annotation, Spring MVC va convertir la facture en Texte
	// Dans la librairie spring-boot-starter-web, il y a la lib spring-boot-starter-json qui contient la lib jackson. Il sait ainsi que l'on aura du format
	// JSON
	@GetMapping("/{id}")
	public Invoice get(@PathVariable("id") String number) {
		System.out.println("La méthode display Invoice a été invoquée");

		return invoiceServiceInterface.getInvoiceByNumber(number);
	}

	/*@GetMapping("/create-form")
	public String displayInvoiceCreateForm(@ModelAttribute InvoiceForm invoice) {
		return "invoice-create-form";
	}*/

}
