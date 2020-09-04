package org.dxc.shopping.dao;

import java.util.List;


import org.dxc.shopping.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
	}	

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
    Query<Product> query=sessionFactory.getCurrentSession().createQuery("from Product");		
	return query.getResultList();
	}
		
	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Product product=session.get(Product.class, id);
		
		return product;
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		Query<Product> query=sessionFactory.getCurrentSession().createQuery("delete from Product where id=:productId");
		query.setParameter("productId", id);
		query.executeUpdate();
	}

	
	

}
