package com.rest.service.OnlineOrders.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.service.OnlineOrders.VO.MyUser;

public interface UserRepository extends JpaRepository<MyUser,String>{

}
