package com;

public class ProductService {
	operation pd=new operation();
	public String storeProduct(product product) {
		   if(product.getPrice()<100) {
			   return "product price must be>100";
		   }else if(pd.storeProduct(product)>0) {
			   return "product stored successfully";
		   }else {
			   return"product didn't store id must be unique";
		   }
	   }
}
