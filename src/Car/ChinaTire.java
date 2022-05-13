package Car;

import org.springframework.stereotype.Component;

@Component
public class ChinaTire extends Tire {

	/*
	 * (non-Javadoc)
	 * 
	 * @see Car.Tire#roll()
	 */
	@Override
	public void roll() {
		// TODO Auto-generated method stub
		System.out.println("중국산 타이어가 굴러갑니다.");
	}

}
