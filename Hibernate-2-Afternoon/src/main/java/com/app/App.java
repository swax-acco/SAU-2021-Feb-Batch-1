package com.app;

import com.app.entities.Category;
import com.app.entities.Product;
import com.app.entities.Supplier;
import java.util.Scanner;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;

public class App 
{
	static Scanner s = new Scanner(System.in);
	static SessionFactory sessionfactory =  new Configuration().configure()
	.addAnnotatedClass(Product.class)
	.addAnnotatedClass(Supplier.class)
	.addAnnotatedClass(Category.class)
	.buildSessionFactory();

	public static void main(String[] args) {
		{
			Product product1 = new Product(1, "product1");
			Product product2 = new Product(2, "product2");
			Product product3 = new Product(3, "product3");
			Product product4 = new Product(4, "product4");
			Product product5 = new Product(5, "product5");
			
			Supplier supplier1 = new Supplier(1, "supplier1");
			Supplier supplier2 = new Supplier(2, "supplier2");
			Supplier supplier3 = new Supplier(3, "supplier3");
			Supplier supplier4 = new Supplier(4, "supplier4");
			Supplier supplier5 = new Supplier(5, "supplier5");
			
			
			Category category1 = new Category(1, "category1");
			Category category2 = new Category(2, "category2");
			Category category3 = new Category(3, "category3");
			Category category4 = new Category(4, "category4");
			Category category5 = new Category(5, "category5");
			Category category6 = new Category(6, "category6");
			Category category7 = new Category(7, "category7");
			Category category8 = new Category(8, "category8");
			Category category9 = new Category(9, "category9");
			Category category10 = new Category(10, "category10");
			
			
			product1.setCategory(category1);product2.setCategory(category5);
			product3.setCategory(category10);product4.setCategory(category8);
			product5.setCategory(category3);
	
			
			category1.addProduct(product1);category5.addProduct(product2);
			category10.addProduct(product3);category8.addProduct(product4);
			category3.addProduct(product5);
			
			
			supplier1.addCategory(category1);supplier1.addCategory(category9);
			supplier2.addCategory(category2);supplier2.addCategory(category5);
			supplier3.addCategory(category10);supplier3.addCategory(category4);
			supplier4.addCategory(category8);supplier4.addCategory(category6);
			supplier5.addCategory(category7);supplier5.addCategory(category3);
			
			category1.addSupplier(supplier1);category2.addSupplier(supplier2);category3.addSupplier(supplier5);
			category4.addSupplier(supplier3);category5.addSupplier(supplier2);category6.addSupplier(supplier4);
			category7.addSupplier(supplier5);category8.addSupplier(supplier4);category9.addSupplier(supplier1);
			category10.addSupplier(supplier3);
			
			
			Session session = sessionfactory.openSession();
			Transaction trx = session.beginTransaction();
			
			session.save(product1);session.save(product2);session.save(product3);session.save(product4);session.save(product5);
			session.save(supplier1);session.save(supplier2);session.save(supplier3);session.save(supplier4);session.save(supplier5);
			session.save(category1);session.save(category2);session.save(category3);session.save(category4);session.save(category5);
			session.save(category6);session.save(category7);session.save(category8);session.save(category9);session.save(category10);
			
			trx.commit();
			session.close();
		}
	}
}
