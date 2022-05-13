package member;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}

	@Bean
	public MemberRegisterService memberMrs() {

		return new MemberRegisterService(memberDao());
	}

	@Bean
	public ChangePasswordService changeCps() {
		ChangePasswordService cps = new ChangePasswordService();
		cps.setMemberDao(memberDao());
		return cps;
	}

	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}

	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(memberDao(), memberPrinter());
	}

	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter ip = new MemberInfoPrinter();
		ip.setMemberDao(memberDao());
		ip.setMemberPrinter(memberPrinter());
		return ip;
	}

	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter vp = new VersionPrinter();
		vp.setMajorVersion(0);
		vp.setMinorVersion(1);
		return vp;
	}
}
