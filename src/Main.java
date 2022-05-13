import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		// 어노테이션 방식으로 설정해준 파일정보를 가져와서 빈 객체를 생성하고 관리
		// AppContext 클래스를 생성자의 파라미터로 전달해서 AppContext 클래스에서 정의한 설정정보를 읽어온 다음에 Greeter
		// 객체를 생성하고 초기화
		Greeter g = ctx.getBean("greeter", Greeter.class);

		String msg = g.greet("스프링");

		System.out.println(msg);
		ctx.close();
	}
}
