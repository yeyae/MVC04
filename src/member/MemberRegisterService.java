package member;

import java.util.Date;

public class MemberRegisterService {
	private MemberDao md;

	// DI 방식 1 번, 생성자 통해 의존 객체 주입받기
	public MemberRegisterService(MemberDao memberDao) {
		this.md = memberDao;
	}

	public long regist(RegisterRequest req) {
		Member member = md.selectByEmail(req.getEmail());
		if (member != null) {
			throw new DuplicateMemberException("이메일 중복 : " + req.getEmail());
		}
		Member newMember = new Member(new Date(), req.getEmail(), req.getPassword(), req.getName());
		md.insert(newMember);
		return newMember.getId();
	}
}
