package com.examples.initialization_types_examples;

import java.util.Set;
import java.util.function.Supplier;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InitilizationTypesDemo {

	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public static void main(String[] args) {
		
		Customers cust = createCustomersWithOrders("Mani","oneplus 7t","phone");
		Customers cust2 = createCustomersWithOrders("Indhu","rs agarwal","books");
		saveObject(cust);
		saveObject(cust2);
		Customers custfromdb = getObject(1);
		System.out.println("The name is "+custfromdb.getName());
		Set<Orders> ordersList = custfromdb.getOrdersList();
		ordersList.forEach(InitilizationTypesDemo::print);

	}
	
	static void print(Orders o) {
		System.out.println("Order for "+o.getName());
		System.out.println("Order type "+o.getType());
	}
	
	static Customers createCustomersWithOrders(String name,String product,String type) {
		Customers cust = new Customers();
		cust.setName(name);
		cust.getOrdersList().add(createOrder(product, type));
		cust.getOrdersList().add(createOrder("jbl", "headphones"));
		return cust;
	}
	
	static Orders createOrder(String name,String type) {
		Orders order = new Orders();
		order.setName(name);
		order.setType(type);
		return order;
	}
	
	static void saveObject(Customers custo) {
		SessionFactory sf = InitilizationTypesDemo.sessionFactory;
		Session ses = sf.openSession();
		ses.beginTransaction();
		ses.save(custo);
		ses.getTransaction().commit();
		ses.close();
	}
	
	static Customers getObject(int id) {
		SessionFactory sf = InitilizationTypesDemo.sessionFactory;
		Session ses = sf.openSession();
		ses.beginTransaction();
		Customers cust = ses.get(Customers.class, 1);
		ses.getTransaction().commit();
		ses.close();
		return cust;
	}
	
	
	
	

}
