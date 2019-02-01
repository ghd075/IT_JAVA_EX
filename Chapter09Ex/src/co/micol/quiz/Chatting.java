package co.micol.quiz;

public class Chatting {
	void startChat(String chatId) {
//		String nickName = null; //자바8 이후에는 익명 클래스 사용시 자동으로 final키워드가 붙여서 변수 선언과 동시에 값을 넣어줘야 한다.
//		nickName = chatId;      //(그래서 컴파일 에러가 발생함)
		String nickName = chatId; //해결방법 
		Chat chat = new Chat() {
			@Override
			public void start() {
				while(true) {
					String inputData = "안녕하세요";
					String message = "[" + nickName + "] " + inputData;
					sendMessage(message);
				}
			}
		};
	}
	
	//익명 클래스
	class Chat {
		void start() {}
		void sendMessage(String message) {}
	}
}
