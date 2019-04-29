package co.micol.quiz.exam01;

import java.util.*;

public class ListMain {

	public static void main(String[] args) {
		BoardDao dao = new BoardDao();
		List<Board> list = dao.getBoardList();
		for(Board board : list){
			System.out.println(board.getTitle() + "-" + board.getContent());
		}
	}

}
