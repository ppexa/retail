package com.demo.myretail.service;

import com.demo.myretail.dao.ProductRepository;
import com.demo.myretail.domain.CurrentPrice;
import com.demo.myretail.domain.Product;
import org.assertj.core.util.Lists;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest  {

	@Mock
	private ProductRepository productRepository;

	@InjectMocks
	private ProductServiceImpl productService;



//	@Autowired
//	private ProductRepository productRepository;

//	private ProductServiceImpl productService= new ProductServiceImpl();

//	@Autowired
//	private ProductRepository productRepository;
//	private ProductRepository productRepository = new ProductRepository();

	public ProductServiceImplTest() {

	}

	@Before
	public void setUp() {
//		productService = new ProductServiceImpl();
//		productRepository = new ProductRepository();
	}

	@After
	public void tearDown() {

	}

	@Test
	public void testCreateProduct() {
		productService.createProduct( "Test Test", "12.34", "USD","misc");
		verify(productRepository).save(new Product("20100001", "Test Test", new CurrentPrice("12.34","USD"), "misc"));
	}

	@Test
	public void testCreateProductWithProductExisting() {
		when(productRepository.findAll()).thenReturn(Lists.newArrayList(new Product("20100001", "Test Test", new CurrentPrice("12.34","USD"), "misc")));
		productService.createProduct( "TesTesTest", "12.45", "USD","misc");
		verify(productRepository).save(new Product("20100002", "TesTesTest", new CurrentPrice("12.45","USD"), "misc"));
	}

	@Test
	public void getProductById() {
		productService.getProductById("10100001");
		verify(productRepository).findById("10100001");
	}

	@Test
	public void deleteProductById() {
		productService.deleteProductById("10100001");
		verify(productRepository).deleteById("10100001");
	}

}