import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {

	// 스프링에게 객체를 생성하고 초기화해 달라고 알려주는 어노테이션
	@Bean
	public Greeter greeter() {
		Greeter g = new Greeter();
		g.setFormat("%s, 안녕!");
		return g;
	}
}
