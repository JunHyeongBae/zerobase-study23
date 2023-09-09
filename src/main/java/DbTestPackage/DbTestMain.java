package DbTestPackage;

import java.util.Scanner;

public class DbTestMain {
    public static void main(String[] args) {
        MemberService memberService = new MemberService();
//        dbTest.dbSelect();
//        dbTest.dbInsert();
//        dbTest.dbUpdate();
//        dbTest.dbDelete();

        Scanner sc = new Scanner(System.in);

        String memberType = "email";
        System.out.println("아이디 입력 : ");
        String userId = sc.next();
        System.out.println("비밀번호 입력 : ");
        String password = sc.next();
        System.out.println("이름 입력 : ");
        String name = sc.next();

        Member member = new Member();
        member.setMemberType(memberType);
        member.setUserId(userId);
        member.setPassword(password);
        member.setName(name);

        memberService.dbInsert(member);


    }
}
