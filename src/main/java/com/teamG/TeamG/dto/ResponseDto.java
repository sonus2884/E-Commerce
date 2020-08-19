package com.teamG.TeamG.dto;

import org.springframework.http.HttpStatus;

public class ResponseDto<T> {
	
	
	private T data; // template T r obj data
	private HttpStatus status;  //HttpStatus inbuild

	  public ResponseDto(HttpStatus status, T data){

	       this.status = status;
	       this.data  = data;
	  }

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	   
	   

}
