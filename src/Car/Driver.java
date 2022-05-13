package Car;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {
	private static ApplicationContext ctx;

	public static void main(String[] args) {

		ctx = new AnnotationConfigApplicationContext(CarCtx.class);

//		Tire tire = new Tire();
		Car car = ctx.getBean("car", Car.class);

		car.drive();
	}
}
