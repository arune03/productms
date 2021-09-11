package com.infosys.infymarket.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.infosys.infymarket.product.dto.ProductDTO;
import com.infosys.infymarket.product.dto.SubscribedProdDTO;
import com.infosys.infymarket.product.entity.Product;
import com.infosys.infymarket.product.exception.InfyMarketException;
import com.infosys.infymarket.product.service.ProductService;
import com.infosys.infymarket.product.service.SubscribedProdService;


@CrossOrigin
@RequestMapping
public class ProductController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProductService productservice;
	@Autowired
	SubscribedProdService subproser;
	@Autowired
	Environment environment;



	// Get all products by product name
	@RequestMapping(value = "/api/product/{productname}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductDTO>> getProductByName(@PathVariable String productname) throws Exception {

		logger.info("product request with name {}", productname);
		List<ProductDTO> productDTO = productservice.getProductByName(productname);
		return new ResponseEntity<>(productDTO, HttpStatus.OK);

	}

	// Get all products by category
	@RequestMapping(value = "/api/products/{category}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductDTO>> getProductBycategory(@PathVariable String category) throws Exception {

		logger.info("product request with category {}", category);
		List<ProductDTO> productDTO = productservice.getProductBycategory(category);
		return new ResponseEntity<>(productDTO, HttpStatus.OK);

	}



	// Get all products
	@GetMapping(value = "/api/products", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductDTO>> getAllProduct() throws Exception {

		logger.info("Fetching all products");
		List<ProductDTO> buyerDTOs = productservice.getAllProduct();
		return new ResponseEntity<>(buyerDTOs, HttpStatus.OK);

	}


	


	// Get products by id
	@RequestMapping(value = "/api/verifyprod/{prodid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductDTO> getByProdid(@PathVariable String prodid) throws Exception {

		logger.info("productname request for product {}", prodid);
		System.out.println("product");
		ProductDTO product = productservice.getByProdid(prodid);
		return new ResponseEntity<>(product, HttpStatus.OK);

	}

	// Add product
	@PostMapping(value = "/api/product/addproduct", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createProduct(@Valid @RequestBody ProductDTO productDTO) throws Exception {

		String successMessage = environment.getProperty("API.INSERT_SUCCESS");
		logger.info("Product to be added {}", productDTO);
		productservice.saveProduct(productDTO);
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);

	}

	// Delete product
	@DeleteMapping(value = "/product/{productid}")
	public ResponseEntity<String> deleteProduct(@PathVariable String productid) throws Exception {

		productservice.deleteProduct(productid);
		String successMessage = environment.getProperty("API.DELETE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);

	}

//	@PostMapping(value = "/api/subscribedproduct/add", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<String> saveWishlist(@RequestBody SubscribedProdDTO subscribeDTO) throws InfyMarketException {
//		try {
//			logger.info("Creation request for customer {} with data {}", subscribeDTO);
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("buyerid", subscribeDTO.getBuyerid());
//			map.put("prodid", subscribeDTO.getProdid());
//			subscribeDTO.getQuantity();
//			// map.put("buyerid",wishlistDTO.getBuyerid());
//			System.out.println("adding map" + map);
//			BuyerDTO buyerDTOs = restTemplate.getForObject("http://localhost:8400/buyer/{buyerid}",
//					BuyerDTO.class, map);
////			System.out.println("adding subscribed product" + projectDTOs);
//			subproser.createSubscribedProduct(subscribeDTO);
//			String successMessage = environment.getProperty("API.WISHLIST_SUCCESS");
//			return new ResponseEntity<>(successMessage, HttpStatus.OK);
//		} catch (Exception exception) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(exception.getMessage()),
//					exception);
//
//		}
//
//	}

}
