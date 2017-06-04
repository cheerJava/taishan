package com.cheer.taishan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.cheer.taishan.define.Processor;
import com.cheer.taishan.define.Request;
import com.cheer.taishan.define.Response;
import com.cheer.taishan.entity.Student;
import com.cheer.taishan.request.AddRequest;
import com.cheer.taishan.request.ViewRequest;
import com.cheer.taishan.response.AddResponse;
import com.cheer.taishan.response.ViewResponse;

public class Taishan {
	
	public static List<Student> data = new ArrayList<Student>();
	
	public static Map<String,Processor> commandMap = new HashMap<String,Processor>();
	
	public static Scanner scanner = new Scanner(System.in);
	
	public static final String DEFAULT_MENU_KEY = "M";
	
					
	
	public static void main(String[] args) {
		System.out.println("------------------");
		System.out.println("|欢迎来到泰山系统！ |");
		System.out.println("------------------");
		init();
		Processor processor = new Processor(new Request(){
			@Override
			public boolean input() {
				return true;
			}
		},new Response(){
			@Override
			public void render(Request request) {
				System.out.println("在这里你可以输入以下命令");
				System.out.println("V - 查看学生信息");
				System.out.println("A - 增加一个学生信息");
				//System.out.println("O - 导出学生信息");
				//System.out.println("I - 导入学生信息");
				System.out.println("E - 退出系统");
				while(scanner.hasNextLine()){
					String command = scanner.nextLine();
					command = command.toUpperCase();
					Processor p = commandMap.get(command);
					if(p != null){
						p.handle();
					}else{
						System.out.println("输入的命令不存在！系统退到主菜单");
						commandMap.get(DEFAULT_MENU_KEY).handle();
					}
				}
			}});
		commandMap.put(DEFAULT_MENU_KEY, processor);
		processor.handle();
		
	}
	
	
//	V   processor
//				view			viewRequest |	viewResponse
//				A	processor
//				add				addRequest | addResponse
//				E	processor
//								exitRequest | exitResponse
	
	private static void init() {
		Processor v = new Processor(new ViewRequest(),new ViewResponse());
		commandMap.put("V", v);
		Processor a = new Processor(new AddRequest(),new AddResponse());
		commandMap.put("A", a);
		Processor e = new Processor(null,null);
		commandMap.put("E", e);
		
		
	}

}
