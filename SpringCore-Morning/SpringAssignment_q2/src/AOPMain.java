import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import service.ShapeService;

public class AOPMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("spring.xml");
		ShapeService shapeService = ctx.getBean("shapeservice", ShapeService.class);
		try {
			System.out.println(shapeService.getCircle().getName());
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(shapeService.getTriangle().getName());
		((AbstractApplicationContext) ctx).close();
	}
}
