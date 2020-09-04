package org.dxc.shopping.service;
import java.util.List;

import javax.transaction.Transactional;

import org.dxc.shopping.dao.ProductDao;

import org.dxc.shopping.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService{


	@Autowired
	private ProductDao productDao;

	@Transactional
	@Override
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.saveProduct(product);
	}	

	@Transactional
	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		List<Product> productList=productDao.getProducts();
		return productList;
	}

	@Transactional
	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		Product product=productDao.getProduct(id);
		return product;
	}

	@Transactional
	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		productDao.deleteProduct(id);
	}



	
	
	
	
}
