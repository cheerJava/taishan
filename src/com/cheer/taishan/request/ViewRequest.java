package com.cheer.taishan.request;

import com.cheer.taishan.Taishan;
import com.cheer.taishan.define.Request;

public class ViewRequest implements Request {

	@Override
	public boolean input() {
		if(Taishan.data==null || 
				Taishan.data.isEmpty()){
			System.out.println("当前没有学生记录，请先增加学生信息！");
			return false;
		}else{
			return true;
		}
		
	}

}