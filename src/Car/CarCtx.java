package Car;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "Car" })
public class CarCtx {

//	@Bean
//	public KoreaTire kt() {
//		return new KoreaTire();
//	}
//
//	@Bean
//	public ChinaTire ct() {
//		return new ChinaTire();
//	}
//
//	@Bean
//	public Tire t() {
//		return new Tire();
//	}
//
//	@Bean
//	public Car car() {
//		return new Car();
//	}
}
