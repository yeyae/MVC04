package member;

public class Assembler {
	private MemberDao memberDao;
	private MemberRegisterService mrs;
	private ChangePasswordService cps;

	public Assembler() {
		memberDao = new MemberDao();
		mrs = new MemberRegisterService(memberDao);
		cps = new ChangePasswordService();
		cps.setMemberDao(memberDao);
	}

	public ChangePasswordService getChangePsswordSevice() {
		// TODO Auto-generated method stub
		return this.cps;
	}

	/**
	 * @return the memberDao
	 */
	public MemberDao getMemberDao() {
		return memberDao;
	}

	/**
	 * @param memberDao the memberDao to set
	 */
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	/**
	 * @return the mrs
	 */
	public MemberRegisterService getMrs() {
		return mrs;
	}

	/**
	 * @param mrs the mrs to set
	 */
	public void setMrs(MemberRegisterService mrs) {
		this.mrs = mrs;
	}

	public MemberRegisterService getMemberRegisterService() {
		// TODO Auto-generated method stub
		return mrs;
	}

}
