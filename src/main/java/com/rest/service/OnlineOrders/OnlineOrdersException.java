package com.rest.service.OnlineOrders;

public class OnlineOrdersException extends Exception{
	
	public OnlineOrdersException(Long id){
		super("Could not found detais with "+id);
	}
}
