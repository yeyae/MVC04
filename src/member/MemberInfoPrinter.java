package member;

public class MemberInfoPrinter {
	private MemberDao memberDao;
	private MemberPrinter printer;

	// DI 2번 째 방식인 setter 메소드를 통해 의존성 주입
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void setMemberPrinter(MemberPrinter printer) {
		this.printer = printer;
	}

	// member의 정보를 출력하는데, 지정한 email을 갖는 member를 찾아서
	// 정보를 콘솔에 출력

	public void printMemberInfo(String email) {
		Member member = memberDao.selectByEmail(email);
		if (member == null) {
			System.out.println("데이터 없음!");
			return;
		}
		printer.print(member);
		System.out.println("");
	}
}
