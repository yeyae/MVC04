package member;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemberDao {
	private static long nextId = 0;
	// map이 임시 db 역할
	private Map<String, Member> map = new HashMap<String, Member>();

	public Member selectByEmail(String email) {
		return map.get(email);
	}

	public void insert(Member member) {
		member.setId(++nextId);
		map.put(member.getEmail(), member);
	}

	public Collection<Member> selectAll() {
		return map.values();
	}

	public void update(Member member) {
		map.put(member.getEmail(), member);
	}
}
