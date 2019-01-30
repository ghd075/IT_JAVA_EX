package co.micol.couse;

import java.util.*;
import java.sql.*;

public class Menu {
	private boolean b;
	private int choise;
	private CourseDTO dto;
	Scanner sc = new Scanner(System.in);
	
	private CourseDTO courseInput() {
		dto = new CourseDTO();
		
		System.out.print("학과코드를 입력하세요. : ");
		dto.setDeptcode(sc.nextLine());
		
		System.out.print("학번을 입력하세요 : ");
		dto.setStudentid(sc.nextLine());
		
		System.out.print("학과명을 입력하세요 : ");
		dto.setCourse(sc.nextLine());
		
		return dto;
	}
	
	private CourseDTO courseUpdate() {
		dto = new CourseDTO();
		
		System.out.print("학과명을 입력하세요 : ");
		dto.setCourse(sc.nextLine());
		
		System.out.print("학과코드를 입력하세요. : ");
		dto.setDeptcode(sc.nextLine());
		
		System.out.print("학번을 입력하세요 : ");
		dto.setStudentid(sc.nextLine());
		
		return dto;
	}
	
	private CourseDTO courseDelete() {
		dto = new CourseDTO();
		
		System.out.print("학과코드를 입력하세요. : ");
		dto.setDeptcode(sc.nextLine());
		
		System.out.print("학번을 입력하세요 : ");
		dto.setStudentid(sc.nextLine());
		
		return dto;
	}
	
	public void menuTest()
	{
		b = true;
		int n;
		CourseDAO dao = new CourseDAO();
		do
		{
			menu(); //메뉴 출력
			choise = sc.nextInt();
			sc.nextLine();
			switch (choise) {
			case 1:
				dto = courseInput();
				n = dao.input(dto);
				if(n != 0) {
					System.out.println("정상적으로 입력되었습니다.");
				}else {
					System.out.println("입력이 실패했습니다.");
				}
				System.out.println("작업을 종료합니다.");
				break;
			case 2:
				dto = courseUpdate();
				n = dao.update(dto);
				if(n != 0) {
					System.out.println("정상적으로 수정되었습니다.");
				}else {
					System.out.println("수정이 실패했습니다.");
				}
				System.out.println("작업을 종료합니다.");
				break;
			case 3:
				dto = courseDelete();
				n = dao.delete(dto);
				if(n != 0) {
					System.out.println("정상적으로 삭제되었습니다.");
				}else {
					System.out.println("삭제 실패!!!!");
				}
				System.out.println("작업을 종료합니다.");
				break;
			case 4:
				dao.selectAll();
				break;
			default:
				b = false; //프로그램 종료
				break;
			}
		}while(b);
	}
	
	public void menu() {
		System.out.println("----------------------");
		System.out.println("1. 입력");
		System.out.println("2. 수정");
		System.out.println("3. 삭제");
		System.out.println("4. 조회");
		System.out.println("----------------------");
		System.out.print("원하는 작업 번호를 입력하세요 : ");
		
	}
}
