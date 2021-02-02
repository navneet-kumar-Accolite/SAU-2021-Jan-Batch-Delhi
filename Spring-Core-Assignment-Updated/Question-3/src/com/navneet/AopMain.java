package com.navneet;

import com.navneet.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class AopMain {
	
	public static void main(String[] args){
		ApplicationContext ctx = new FileSystemXmlApplicationContext("spring.xml");
		ShapeService shapeService = ctx.getBean("shapeService", ShapeService.class);

		shapeService.getCircle().setName("Circle");
		System.out.println(shapeService.getCircle().getName());
		try {
			shapeService.getTriangle().setName("");
			System.out.println(shapeService.getTriangle().getName());
		}
		catch (Exception e){
			System.out.println("Exception on Triangle");
		}
	}

}
