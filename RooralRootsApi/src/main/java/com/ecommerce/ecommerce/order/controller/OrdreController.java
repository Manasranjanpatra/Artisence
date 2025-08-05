package com.ecommerce.ecommerce.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.global.Status;
import com.ecommerce.ecommerce.order.model.Order;
import com.ecommerce.ecommerce.order.model.OrderDto;
import com.ecommerce.ecommerce.order.service.OrderService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/api/order")
public class OrdreController {

    @Autowired
    OrderService orderService;

    @GetMapping(value = "/list/user/id/{id}")
    public List<OrderDto> listByUserId(@PathVariable Long id) {
        return orderService.listByUserId(id);
    }

    @GetMapping(value = "/list/store/id/{id}")
    public List<OrderDto> listByStoreId(@PathVariable Long id) {
        return orderService.listByStoreId(id);

    }

    @GetMapping(value = "/id/{id}")
    public Order getById(@PathVariable Long id) {
        return orderService.findByOrderId(id);
    }

    @PostMapping(value = "/saveorupdate")
    public Status saveOrUpdate(@RequestBody OrderDto cartDTO) {
        return orderService.saveOrUpdate(cartDTO);
    }

    @DeleteMapping(value = "/delete/id/{id}")
    public Status deleteById(@PathVariable Long id) {
        return orderService.deleteOrderById(id);
    }

    @GetMapping(value = "/status/id/{id}/{status}")
    public Status updateStatus(@PathVariable Long id,@PathVariable String status) {
        return orderService.updateStatus(id,status);
    }
}
