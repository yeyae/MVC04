package member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	private static ApplicationContext ctx;

	public static void main(String[] args) throws IOException {

		ctx = new AnnotationConfigApplicationContext(AppConfig1.class);

		// Assembler ass = new Assembler();

		// ChangePasswordService cps = ass.getChangePsswordSevice();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("명령어를 입력하세요.");
			// new : 새로운 회원 데이터 추가
			// change : 데이터 암호 변경
			// exit : 종료

			String cmd = br.readLine();

			if (cmd.equals("exit")) {
				System.out.println("프로그램 종료!");
				break;
			}
			if (cmd.startsWith("new ")) {
				String[] command = cmd.split(" ");
				processNewCommand(command);
				continue;
			}
			if (cmd.startsWith("change ")) {
				String[] command = cmd.split(" ");
				processChangeCommand(command);
				continue;
			}
			if (cmd.equals("list")) {
				processListCommand();
				continue;
			}
			if (cmd.startsWith("info ")) {
				String[] command = cmd.split(" ");
				processInfoCommand(command);
				continue;
			}
			if (cmd.equals("version")) {
				processVersionCommand();
				continue;
			}
			printHelp();
		}
	}

	private static void processVersionCommand() {
		// TODO Auto-generated method stub
		VersionPrinter vp = ctx.getBean("versionPrinter", VersionPrinter.class);
		vp.printVersion();
	}

	private static void processInfoCommand(String[] args) {
		if (args.length != 2) {
			printHelp();
			return;
		}
		MemberInfoPrinter ip = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		ip.printMemberInfo(args[1]);
	}

	private static void processListCommand() {
		// TODO Auto-generated method stub
		MemberListPrinter listPrinter = ctx.getBean("listPrinter", MemberListPrinter.class);
		listPrinter.printAll();
	}

	// 프로그램 실행에 필요한 객체들을 조립해주는 조립기 생성
	// private static Assembler assembler = new Assembler();

	// 실제로 command에 맞는 기능을 실행해주는 메소드 : new 명령어를 처리
	public static void processNewCommand(String[] args) {
		if (args.length != 5) {
			printHelp();
			return;
		}
		MemberRegisterService mrs =
				// assembler.getMemberRegisterService();
				ctx.getBean("memberMrs", MemberRegisterService.class);

		RegisterRequest req = new RegisterRequest();
		req.setEmail(args[1]);
		req.setName(args[2]);
		req.setPassword(args[3]);
		req.setConfirmPassword(args[4]);

		if (!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("비밀번호와 확인이 일치안함");
			return;
		}
		try {
			mrs.regist(req);
			System.out.println("등록 성공!!");
		} catch (DuplicateMemberException e) {
			System.out.println("이미 존재하는 이메일");
		}
	}

	// change 명령어
	public static void processChangeCommand(String[] args) {
		if (args.length != 4) {
			printHelp();
			return;
		}
		ChangePasswordService cps =
				// assembler.getChangePsswordSevice();
				ctx.getBean("changeCps", ChangePasswordService.class);

		try {
			cps.changePassword(args[1], args[2], args[3]);
			System.out.println("암호 변경 성공!");
		} catch (MemberNotFoundException e) {
			System.out.println("존재하지 않는 이메일");
		} catch (WrongPasswordException e) {
			System.out.println("이메일과 암호 일치 안함.");
		}
	}

	// 명령어 잘못 입력했을 때 도움말 출력해주는 메소드
	public static void printHelp() {
		System.out.println("잘못된 명령어 입니다. 아래 명령어 사용하십시오.");
		System.out.println("new (이메일 암호 암호_확인 이름), change (이메일 현재비번 변경비번), info (이메일) exit");
		System.out.println("------------------------");

	}
}
