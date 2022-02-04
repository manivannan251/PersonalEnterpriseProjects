package com.example.com;

import java.util.Arrays;
import java.util.List;

import javax.jws.WebService;

@WebService
public class ProductCatalog {
	
	
	public List<String> getProductCategories() {
		List<String> cat = Arrays.asList("Books","Music","Movies");
		return cat;
	}
}
