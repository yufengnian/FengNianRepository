package ChatUdp;

public class ChatMain {
	
	public static void main(String[] args) {
		ChatReceive chatReceive = new ChatReceive();
		chatReceive.start();
		
		ChatSender chatSender = new ChatSender();
		chatSender.start();
	}
}
