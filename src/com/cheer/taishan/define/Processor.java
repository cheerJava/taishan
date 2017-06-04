package com.cheer.taishan.define;

import com.cheer.taishan.Taishan;

public class Processor {
	
	private Request request;
	private Response response;
	
	
	public Processor(Request request, Response response){
		this.request = request;
		this.response = response;
	}
	
	public void handle(){
		if(request.input()){
			response.render(request);
		}else{
			System.out.println("输入有误，返回主菜单");
			Taishan.commandMap.get(Taishan.DEFAULT_MENU_KEY).handle();
		}
	}
	
}
