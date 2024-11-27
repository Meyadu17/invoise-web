package fr.apside.invoise.invoise_web.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class InvoiceForm {
	private String number;

	// @NotBlank permet de vérifier que l'élément n'est ni null, ni vide, ni rempli seulement d'espaces.
	@NotBlank(message="Le nom du client est obligatoire.")
	private String customerName;

	@Size(min = 10, max = 13, message = "le numéro de commande doit être compris entre 10 et 13 caractères.")
	private String orderNumber;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
}
