package member;

public class ChangePasswordService {

	private MemberDao memberDao;

	// memberDao 객체 생성
	// DI 방식 2, setter 메소드 통해 주입
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void changePassword(String email, String op, String np) {
		Member member = memberDao.selectByEmail(email);
		if (member == null)
			throw new MemberNotFoundException();

		member.changePassword(op, np);
		memberDao.update(member);
	}
}
