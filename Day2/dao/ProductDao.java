package com.demo.Day2.dao;

import java.util.List;

import com.demo.Day2.beans.Product;

public interface ProductDao {
	boolean save(Product p);
	List<Product> findAllProduct();
	Product findById(int id);
	boolean updateById(int id,int qty,double price);
	boolean removeById(int id);
	List<Product> arrangeByPrice();
	void closeConnection();

}
