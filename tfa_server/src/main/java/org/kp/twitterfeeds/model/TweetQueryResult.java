package org.kp.twitterfeeds.model;

public class TweetQueryResult {
	
	private String id;
	private String text;
	
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(id).append(":").append(text);
		return result.toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public TweetQueryResult(String id, String text) {
		this.id=id;
		this.text = text;
	}
}
