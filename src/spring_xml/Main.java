package spring_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// 스프링 설정 파일 불러오고
		// 스프링 설정 파일을 불러오는 것 자체를 스프링 컨테이너를 만든다고 한다.
		// 스프링 컨테이너 자체도 객체
		ApplicationContext context = new GenericXmlApplicationContext("spring_xml/ApplicationContext.xml");

		Hello h = context.getBean("hello", Hello.class);
		Hello h2 = context.getBean("hello", Hello.class);
		h.sayHello();
		System.out.println("(h == h2) = " + (h == h2));
		// 싱글톤 패턴
		// 여러분들이 별도의 설정을 하지 않은 경우 스프링은 한 개의 빈 객체만 생성
		// 힌 개의 @Bean 이노테이션 또는 설정에 대해 한 개의 객체만 생성
		// "hello" 라는 이름을 가진 빈 객체는 1개 밖에 없다는 것을 의미
	}

}
