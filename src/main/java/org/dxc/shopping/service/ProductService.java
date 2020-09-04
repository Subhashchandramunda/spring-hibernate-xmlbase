package org.dxc.shopping.service;

import java.util.List;

import org.dxc.shopping.entity.Product;

public interface ProductService {

	public void saveProduct(Product product);

	public List<Product> getProducts();	

	public Product getProduct(int id);

	public void deleteProduct(int id);

	

		
	
}
