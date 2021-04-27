package org.kp.twitterfeeds.model;

import java.util.List;

public class TweetSearchResponse {
	
	private String status;
	private String errorMessage;
	private List<TweetQueryResult> data;
	
	public TweetSearchResponse(String status, List<TweetQueryResult> data) {
		this.status=status;
		this.data=data;
	}
	
	public TweetSearchResponse(String status, String errorMessage) {
		this.status=status;
		this.errorMessage=errorMessage;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public List<TweetQueryResult> getData() {
		return data;
	}
	public void setData(List<TweetQueryResult> data) {
		this.data = data;
	}
	
	

}
