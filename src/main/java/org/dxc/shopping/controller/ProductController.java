package org.dxc.shopping.controller;
import java.util.List;


import java.util.logging.Logger;

import org.dxc.shopping.entity.Product;
import org.dxc.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class ProductController {
	public Logger	logger=Logger.getLogger(ProductController.class.getName());
	
	@Autowired
    private ProductService productService;
	private Product product;
	@RequestMapping("/")
	public String showIndexPage() {
		logger.info("=========showIndexPage()called=============="); 
		return "index";
	}
	@RequestMapping("/addproduct")
	public String showAddProductPage(@ModelAttribute("product")Product product) {
		logger.info("=========addProduct==============");
		return "add-product";
	}
	@RequestMapping(value="/addnewproduct",method=RequestMethod.POST)
	public String addNewProduct(@ModelAttribute("product")Product product,BindingResult result) {
		logger.info("=========addNewProduct==============");
		if(result.hasErrors()) {
			logger.info("=========BindingError=============="); 
			return "add-product";
		}else {
			logger.info("=========BindingSuccess==============");
			productService.saveProduct(product);
			return "success";
		}
	}
	@RequestMapping("/displayProduct")
	public String dispalyProduct(ModelMap map) {		
		List<Product> productList=productService.getProducts();
		map.addAttribute("productList", productList);
		return "view-product";
	}
	@RequestMapping("/update")
	public String updateProduct(@RequestParam("productId")int id,Model model) {
		Product product=productService.getProduct(id);
		model.addAttribute("product", product);
		return "add-product";
	}
	@RequestMapping("/delete")
	   public String deleteProduct(@RequestParam("productId")int id) {
		   logger.info("============deleteproduct called");
		   
		  productService.deleteProduct(id);
		  
		   return "redirect:/displayProduct";
		   
	   }	
}
