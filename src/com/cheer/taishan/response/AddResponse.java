package com.cheer.taishan.response;

import com.cheer.taishan.Taishan;
import com.cheer.taishan.define.Request;
import com.cheer.taishan.define.Response;
import com.cheer.taishan.entity.Student;
import com.cheer.taishan.request.AddRequest;

public class AddResponse implements Response {

	@Override
	public void render(Request request) {
		AddRequest addRequest = (AddRequest) request;
		Student student = addRequest.getFill();
		Taishan.data.add(student);
		System.out.println("学生信息增加成功！");
		Taishan.commandMap.get(Taishan.DEFAULT_MENU_KEY).handle();
	}

}
