package fr.apside.invoise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
@SpringBootApplication : inclus 3 annotations : @Configuration, @ComponentScan et @EnableConfiguration. C'est un raccourci vers ces 3 annotations
@EnableConfiguration va chercher dans les librairies de classes annotées @Configuration. Ces classes ne sont pas scanné par @ComponentScan
@Configuration utilise pour spring mais pris en compte pour par annotation @SpringBootApplication
@ComponentScan utilise pour spring mais pris en compte pour par annotation @SpringBootApplication
@ComponentScan(basePackages = {"fr.apside.demo.exerciceSpring.controller.web",
        "fr.apside.demo.exerciceSpring.service.prefix", "fr.apside.demo.exerciceSpring.repository.database"})
@PropertySource("classpath:application.properties") plus utile ici, car de based SpringBoot regarde s'il y a des fichiers .properties
@ImportResource("classpath:applicationContext.xml") si on veut passer par le fichier xml ici ne sert à rien.
*/
public class InvoiseWebApplication {

	public static void main(String[] args) {
		//si on veux utiliser applicationContext.xlm
		//ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//ApplicationContext context=new AnnotationConfigApplicationContext(App.class);
		SpringApplication.run(InvoiseWebApplication.class, args);

		//InvoiceControllerInterface invoiceController=context.getBean(InvoiceControllerInterface.class);
		//invoiceController.createInvoice();
	}
	// Dans une classe annoné @Configuration :
	// on peut créer des méthodes @Bean ces méthodes auront vocation à fournir des objets supplémentaires au conteneur légé
	// Exemple :
	// @Bean
	// public InvoiceServiceInterface configurationInvoiceService() {
	//     return new InvoicePrefixService();
	// }

}
