package member;

import java.util.Collection;

public class MemberListPrinter {
	private MemberDao md;
	private MemberPrinter printer;

	// DI 1방식 : 생성자 주입 방식
	public MemberListPrinter(MemberDao dao, MemberPrinter printer) {
		md = dao;
		this.printer = printer;
	}

	public void printAll() {
		Collection<Member> members = md.selectAll();
		for (Member m : members) {
			printer.print(m);
		}
		// members.forEach(m -> printer.print(m));
	}
}
