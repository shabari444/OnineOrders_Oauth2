package com.rest.service.OnlineOrders.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.service.OnlineOrders.VO.OnlineOrder;

//import com.rest.service.Entity.Order;

public interface OnlineOrderRepository extends JpaRepository<OnlineOrder, Long> {

}
