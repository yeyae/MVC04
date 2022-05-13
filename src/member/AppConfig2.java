package member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig2 {
	@Autowired
	private MemberDao dao;

	@Autowired
	private MemberPrinter printer;

	@Bean
	public MemberRegisterService memberMrs() {
		return new MemberRegisterService(dao);
	}

	@Bean
	public ChangePasswordService cps() {
		ChangePasswordService cps = new ChangePasswordService();
		cps.setMemberDao(dao);
		return cps;
	}

	@Bean
	public MemberListPrinter mlp() {
		return new MemberListPrinter(dao, printer);
	}

	@Bean
	public MemberInfoPrinter mip() {
		MemberInfoPrinter mip = new MemberInfoPrinter();
//		mip.setMemberDao(dao);
//		mip.setMemberPrinter(printer);
		// setter 메소드로 의존주입 하지 않아도 스프링이 @Autowired 어노테이션을 붙인 필드에 자동으로 해당 타입의 빈 객체를
		// 주입해준다.
		return mip;
	}

	@Bean
	public VersionPrinter vp() {
		VersionPrinter vp = new VersionPrinter();
		vp.setMajorVersion(0);
		vp.setMinorVersion(1);
		return vp;
	}
}
