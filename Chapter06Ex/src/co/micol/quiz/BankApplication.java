package co.micol.quiz;

import java.util.Scanner;

public class BankApplication {
	private static Account2[] accountArray = new Account2[100];
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean run = true;
		while(run) {
			System.out.println("-----------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("-----------------------------------------");
			System.out.print("<선택>");
			
			int selectNo = scanner.nextInt();
			
			switch (selectNo) {
			case 1:
				createAccount();
				break;
			case 2:
				accountList();
				break;
			case 3:
				deposit();
				break;
			case 4:
				withdraw();
				break;
			case 5:
				run = false;
				break;
			}
		}
		System.out.println("프로그램 종료");
	}
	
	private static void createAccount() {
		System.out.println("-----");
		System.out.println("계좌생성");
		System.out.println("-----");
		System.out.print("계좌번호 : ");
		String ano = scanner.next();
		scanner.nextLine();
		System.out.print("계좌주 : ");
		String owner = scanner.next();
		scanner.nextLine();
		System.out.print("초기입금액 : ");
		int balance = scanner.nextInt();
		
		Account2 newAccount = new Account2(ano, owner, balance);
		for(int i=0;i<accountArray.length;i++) {
			if(accountArray[i] == null) {
				accountArray[i] = newAccount;
				System.out.println("결과 : 계좌가 생성되었습니다.");
				break;
			}
		}
	}
	
	private static void accountList() {
		System.out.println("-----");
		System.out.println("계좌목록");
		System.out.println("-----");
		for(int i=0;i<accountArray.length;i++)
		{
			Account2 account = accountArray[i];
			if(account != null) {
				System.out.print(account.getAno());
				System.out.print("    ");
				System.out.print(account.getOwner());
				System.out.print("    ");
				System.out.println(account.getBalance());
				System.out.print("    ");
				System.out.println();
			}
		}
	}
	
	private static void deposit() {
		System.out.println("-----");
		System.out.println("예금");
		System.out.println("-----");
		System.out.print("계좌번호 : ");
		String ano = scanner.next();
		scanner.nextLine();
		System.out.print("예금액 : ");
		int balance = scanner.nextInt();
		scanner.nextLine();
		Account2 account = findAccount(ano);
		
		if(account==null) {
			System.out.println("해당 계좌번호가 없습니다.");
			return;
		}
		account.setBalance(account.getBalance()+balance);
		System.out.println("결과 : 예금이 성공되었습니다.");
	}
	
	private static void withdraw() {
		System.out.println("-----");
		System.out.println("출금");
		System.out.println("-----");
		System.out.print("계좌번호 : ");
		String ano = scanner.next();
		scanner.nextLine();
		System.out.print("예금액 : ");
		int balance = scanner.nextInt();
		scanner.nextLine();
		
		Account2 account = findAccount(ano);
		
		if(account==null) {
			System.out.println("해당 계좌번호가 없습니다.");
			return;
		}
		
		account.setBalance(account.getBalance()-balance);
		System.out.println("결과 : 출금이 성공되었습니다.");
	}
	
	private static Account2 findAccount(String ano) {
		Account2 account = null;
		for(int i=0;i<accountArray.length;i++) {
			if(accountArray[i] != null) {
				String useAno = accountArray[i].getAno();
				if(useAno.equals(ano)) {
					account = accountArray[i];
					break;
				}
			}
		}
		return account;
	}
}
