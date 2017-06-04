package com.cheer.taishan.response;

import com.cheer.taishan.Taishan;
import com.cheer.taishan.define.Request;
import com.cheer.taishan.define.Response;
import com.cheer.taishan.entity.Student;

public class ViewResponse implements Response {

	@Override
	public void render(Request request) {
		System.out.println("当前总共有" +Taishan.data.size()+"条学生记录");
		System.out.println("id\t\t\tname\t\tsex\t\tbirthday\t\theight\t\tweight");
		for(int i=0;i<Taishan.data.size();i++){
			Student student = Taishan.data.get(i);
			System.out.println(student);
		}
	}

}
