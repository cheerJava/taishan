package com.cheer.taishan.request;

import java.lang.reflect.Field;
import java.util.UUID;

import com.cheer.taishan.Taishan;
import com.cheer.taishan.define.Request;
import com.cheer.taishan.entity.Student;

public class AddRequest implements Request {
	
	private Student fill; 
	
	public Student getFill(){
		return fill;
	}
	
	@Override
	public boolean input() {
		String [] fields = new String[]{
			"姓名",
			"性别",
			"出生日期",
			"身高",
			"体重"
		};
		String [] reflectFields = {
			"name",
			"sex",
			"birthday",
			"height",
			"weight"
		};
		
		fill = new Student();
		for(int i=0;i<fields.length;i++){
			System.out.print("请输入学生的"+fields[i]+":");
			String value = Taishan.scanner.nextLine();
			try{
				Field field = Student.class.getDeclaredField(reflectFields[i]);
				field.setAccessible(true);
				if(reflectFields[i].equals("birthday")){
					field.set(fill, Student.df.parse(value));
				}else{
					field.set(fill, value);
				}
				field.setAccessible(false);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		fill.setId(UUID.randomUUID().toString().replace("-", ""));
		return true;
	}

}
