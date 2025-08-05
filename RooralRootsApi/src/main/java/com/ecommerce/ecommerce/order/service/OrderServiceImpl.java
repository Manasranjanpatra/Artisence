package com.ecommerce.ecommerce.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.global.Status;
import com.ecommerce.ecommerce.order.model.Order;
import com.ecommerce.ecommerce.order.model.OrderDto;
import com.ecommerce.ecommerce.order.repository.OrderRepo;
import com.ecommerce.ecommerce.users.Entity.User;
import com.ecommerce.ecommerce.users.Repository.UserRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderServiceImpl implements OrderService{


    @Autowired
    OrderRepo orderRepo;
    @Autowired
    UserRepo userRepo;

    @Override
    public Status deleteOrderById(Long id) {
        orderRepo.findById(id).ifPresentOrElse(order->{
            orderRepo.deleteById(id);
        },()->{
            throw new EntityNotFoundException("Order not found with id "+id);
        });
        return new Status(true,"Delete successfuly");
    }

    @Override
    public Order findByOrderId(Long id) {
        return orderRepo.findById(id).orElseThrow(()->{
            throw new EntityNotFoundException("Order not found with id "+id);
        });
    }

    @Override
    public List<OrderDto> listByStoreId(Long id) {
        return orderRepo.findAllBySeller_idOrderByOrderdateDesc(id).stream().map(OrderDto::new).toList();
    }

    @Override
    public List<OrderDto> listByUserId(Long id) {
        return orderRepo.findAllByBuyer_id(id).stream().map(OrderDto::new).toList();
    }

    @Override
    public Status saveOrUpdate(OrderDto orderDto) {
        try {

            if (orderDto == null) {
                return new Status(false, "OrderDto cannot be null");
            }
    
            // Fetch the Store entity from the database to ensure it is managed by the current session
            User seller = userRepo.findById(orderDto.getSeller().getId()).orElse(null);
            if (seller == null) {
                return new Status(false, "seller not found");
            }
            User buyer=userRepo.findById(orderDto.getBuyer().getId()).orElse(null);
        

        Order order=new Order(orderDto);
        order.setBuyer(buyer); 
        order.setSeller(seller); 
        orderRepo.save(order);
        return new Status(true,orderDto.getId()==null?"Added Successfuly":"Update Successfuly");
        } catch (Exception e) {
            return new Status(false,orderDto.getId()==null?"Fail to Added":"Fail to Update");
        }
    }

    @Override
    public Status updateStatus(Long id, String status) {
      Order order=orderRepo.findById(id).get();
      order.setStatus(status);
      orderRepo.save(order);
      return new Status(true,"Status Updated to "+status);
    }


    
}
