package VO;

public class MessageVO {
	int message_id = 0; // 메세지 아이디
	String title; //메세지 제목
	String concent; //메세지 내용
	String send_id; //보낸사람 아이디
	String receive_id; //받는사람 아이디
	boolean limit = true;
	/*static int message_sq = 0;
	{
		message_id = message_sq;
		message_sq++;
	}*/
	
	public int getMessage_id() {
		return message_id;
	}
	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getConcent() {
		return concent;
	}
	public void setConcent(String concent) {
		this.concent = concent;
	}
	public String getSend_id() {
		return send_id;
	}
	public void setSend_id(String send_id) {
		this.send_id = send_id;
	}
	public boolean isLimit() {
		return limit;
	}
	public void setLimit(boolean limit) {
		this.limit = limit;
	}
	public String getReceive_id() {
		return receive_id;
	}
	public void setReceive_id(String receive_id) {
		this.receive_id = receive_id;
	}


}
