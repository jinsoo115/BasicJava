package JinSoo;

import e_oop.ScanUtil;

public class Sign {
	boolean login; //로그인 확인
	String id; //아이디
	String password;//비밀번호
	int accountNumber;//계좌번호(001~999번까지)
	Member[] members;
	int memberNum;//로그인 넘버

	Sign(){
		this.login = false; //로그인 확인
		this.id = ""; //아이디
		this.password = "";//비밀번호
		this.accountNumber = 0;//계좌번호
		this.members = new Member[10];
		this.memberNum = 0;
	}

	void signIn(){//회원가입
		for(int i=0; i < members.length; i++){
			if(members[i] != null){
				memberNum=members[i].memberNum+1;	
			}
		}
		if(members[memberNum]==null){
			System.out.print("ID를 입력해주세요>");
			id = ScanUtil.nextLine();
			for(int i= 0; i <memberNum; i++){
				if(members[i].id.equals(id)){
					System.out.println("중복된 아이디입니다.");
					return;
				}
			}
			System.out.print("PassWord를 입력해주세요>");
			password = ScanUtil.nextLine();
			accountNumber = (int)(Math.random() * 999) + 1;
		}

		else if(members[9] != null){
			System.out.println("이미 회원가입된 아이디가 있습니다");
			return;
		}
		members[memberNum] = new Member(id, password, accountNumber, memberNum);
		memberNum++;
	}
	void showSign(){
		for(int i =0; i < members.length; i++){
			if(members[i] != null)
				System.out.println(members[i].memberInfo());
		}
	}
	int login(){//로그인

		lo : do{
			if(login){
				System.out.println("로그인 상태입니다.");
				break lo;
			}
			System.out.print("ID를 입력해주세요>");
			id = ScanUtil.nextLine();
			System.out.print("PassWord를 입력해주세요>");
			password = ScanUtil.nextLine();
			for(int i = 0; i < members.length; i++){
				if(members[i]!=null){
					if(members[i].id.equals(id) && members[i].password.equals(password)){
						login = !login;
						System.out.println("로그인 되었습니다.");
						memberNum=i;
						break;
					}				

				}
			}
			if(!login){
				System.out.println("아이디 및 비밀번호가 틀렸습니다.");
			}
		}while(!login);
	return memberNum;
	}
	void logout(){//로그아웃
		if(login){
			login = false;
			System.out.println("로그아웃 되었습니다.");
			return;
		}
	}
}
