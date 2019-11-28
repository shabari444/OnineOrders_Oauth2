package com.rest.service.OnlineOrders.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.service.OnlineOrders.Exception.OnlineOrdersException;
import com.rest.service.OnlineOrders.Repository.OnlineOrderRepository;
import com.rest.service.OnlineOrders.VO.OnlineOrder;

import lombok.extern.slf4j.Slf4j;

@RestController @Slf4j
public class OnlineOrdersController extends ResourceServerConfigurerAdapter{
	
	private final OnlineOrderRepository repository;
	
	private static final Logger LOG = LoggerFactory.getLogger(OnlineOrdersController.class);
	
	OnlineOrdersController(OnlineOrderRepository repository){
		this.repository = repository;
	}

	//private static final Class<Logger> log = Logger.class;
	@GetMapping("/getAllOrders")
	public List<OnlineOrder> getAllOrders() throws Exception{
		
		List<OnlineOrder> orders = repository.findAll();
		LOG.info("Fetched orders:"+orders);
		if(orders == null) {
			LOG.debug("No orders found");
			throw new Exception();
		}
		return orders;
	}
	
	@GetMapping("/sample")
	public String test() {
		return "Working";
	}
	
	@GetMapping("/getOrderById{id}")
	public Optional<OnlineOrder> getOrderById(@PathVariable Long id) throws OnlineOrdersException {
		LOG.info("Fetching the details with order id "+id);
		Optional<OnlineOrder> order = null;
		order = repository.findById(id);
		if(order == null) {
			throw new OnlineOrdersException(id);
		}
		return order;
	}
	
	@PostMapping("/CreateOrder")
	public OnlineOrder createOrder(@RequestBody OnlineOrder order) {
		LOG.info("Insertig the order with the details"+order);
		return repository.save(order);
		
	}
	@DeleteMapping("/detele{id}")
	public void delete(@PathVariable Long id){
		LOG.info("Deleting the details with order id "+id);
		if(null !=repository.findById(id)) {
			repository.deleteById(id);
		}
	}
	
}
