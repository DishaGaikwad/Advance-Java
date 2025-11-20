package com.demo.Day2.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.demo.Day2.beans.Product;
import com.demo.Day2.dao.ProductDao;
import com.demo.Day2.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService{
	private ProductDao pdao;
	public ProductServiceImpl() {
		pdao=new ProductDaoImpl();
	}

	@Override
	public boolean addNewProduct() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter pid");
		int pid=sc.nextInt();
		System.out.println("enter product name");
		String pname=sc.next();
		System.out.println("enter qty");
		int qty=sc.nextInt();
		System.out.println("enter price");
		double price=sc.nextDouble();
		System.out.println("enter mgfdate(dd/mm/yyyy)");
		String dt=sc.next();
		LocalDate ldt=LocalDate.parse(dt,DateTimeFormatter.ofPattern("dd/mm/yyyy"));
		Product p=new Product(pid,pname,qty,price,ldt);
		
		return pdao.save(p);
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return pdao.findAllProduct();
	}

	@Override
	public Product getById(int id) {
		// TODO Auto-generated method stub
		return pdao.findById(id);
	}

	@Override
	public boolean modifyById(int id, int qty, double price) {
		// TODO Auto-generated method stub
		return pdao.updateById(id, qty, price);
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return pdao.removeById(id);
	}

	@Override
	public List<Product> sortByPrice() {
		// TODO Auto-generated method stub
		return pdao.arrangeByPrice();
	}

	@Override
	public void closeMyConnection() {
		// TODO Auto-generated method stub
		pdao.closeConnection();
	}

}
