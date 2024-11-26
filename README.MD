Deux façons de faire le lien entre le controller et la page qui doit être affiché :
### Première méthode avec ModelAndView
````java
@RequestMapping("/home")
public ModelAndView displayHome() {
	
	ModelAndView mv = new ModelAndView("invoice-home");
	mv.addObject("invoices", invoiceServiceInterface.getInvoiceList());
	
	return mv;
}

@RequestMapping("/{id}")
public ModelAndView displayInvoice(@PathVariable("id") String number) {
	
	ModelAndView mv = new ModelAndView("invoice-details");
	mv.addObject("invoice", invoiceServiceInterface.getInvoiceByNumber(number));
	
	return mv;
}
````
### Deuxièle méthode avec Model
Attention la variable model doit être à la fin de la signature !
````java
@RequestMapping("/home")
	public String displayHome(Model model) {
		model.addAttribute("invoices", invoiceServiceInterface.getInvoiceList());
		
		return "invoice-home";
	}

	@RequestMapping("/{id}")
	public String displayInvoice(@PathVariable("id") String number, Model model) {
		model.addAttribute("invoice", invoiceServiceInterface.getInvoiceByNumber(number));
		
		return "invoice-details";
	}
````