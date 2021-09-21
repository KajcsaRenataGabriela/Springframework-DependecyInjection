package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controller.*;
import guru.springframework.sfgdi.services.PrototypeBean;
import guru.springframework.sfgdi.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackages = {"guru.springframework.sfgdi", "com.springframework.pets"})
@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SfgDiApplication.class, args);

		System.out.println("----Dogs vs Cats----");
		PetController petController = (PetController) context.getBean("petController");
		System.out.println(petController.tellTheTruth());

		I18nController i18nController = (I18nController) context.getBean("i18nController") ;
		System.out.println(i18nController.sayHello());

		MyController myController = (MyController) context.getBean("myController");

		System.out.println("-----------Primary Bean");
		System.out.println(myController.sayHello());

		// required @autowired
		System.out.println("--------------- Property");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController)  context.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		// required @autowired
		System.out.println("--------------- Setter");
		SetterBasedController setterBasedController = (SetterBasedController)  context.getBean("setterBasedController");
		System.out.println(setterBasedController.getGreeting());

		System.out.println("--------------- Constructor");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) context.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());

		System.out.println("-----------------Bean Scopes-----------------");
		SingletonBean singletonBean1 = context.getBean(SingletonBean.class);
		System.out.println(singletonBean1.getMyScope());
		SingletonBean singletonBean2 = context.getBean(SingletonBean.class);
		System.out.println(singletonBean2.getMyScope());

		PrototypeBean prototypeBean1 = context.getBean(PrototypeBean.class);
		System.out.println(prototypeBean1.getMyScope());
		PrototypeBean prototypeBean2 = context.getBean(PrototypeBean.class);
		System.out.println(prototypeBean2.getMyScope());

	}

}
