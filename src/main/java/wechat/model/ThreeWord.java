package wechat.model;

public class ThreeWord extends BaseRestElement {
	
	private String three_word_content;

	public ThreeWord(int status_code, String status_message, String three_word_content) {
		super(status_code, status_message);
		this.three_word_content = three_word_content;
	}

	public String getThree_word_content() {
		return three_word_content;
	}

	public void setThree_word_content(String three_word_content) {
		this.three_word_content = three_word_content;
	}
	
	

}
