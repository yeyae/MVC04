package Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

//	Tire tire;
//
//	public Car(Tire tire) {
//		this.tire = tire;
//	}
	@Autowired
	private KoreaTire koreaTire;
	@Autowired
	private ChinaTire chinaTire;
	@Autowired
	private Tire tire;

	public void drive() {
//		Tire tire = new Tire();
		koreaTire.roll();
		chinaTire.roll();
		tire.roll();
	}
}
