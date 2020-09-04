package org.dxc.shopping.dao;

import java.util.List;

import org.dxc.shopping.entity.Product;

public interface ProductDao {

	public void saveProduct(Product product);
	public List<Product> getProducts();	
	public Product getProduct(int id);
	public void deleteProduct(int id);

	
}
