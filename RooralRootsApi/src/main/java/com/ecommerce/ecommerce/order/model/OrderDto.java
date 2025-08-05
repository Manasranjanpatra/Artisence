package com.ecommerce.ecommerce.order.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.ecommerce.ecommerce.users.Entity.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {
    
    private Long id;
     private UserDTO buyer;
    private UserDTO seller;
    private List<Orderproduct> orderProducts = new ArrayList<>();
    
    private Date orderdate;
    private Float finalprice;
    private String orderid;
    private String status="PENDING";
    private String locality;
    private String city;
    private String state;
    private String district;
    private String pincode;

    public OrderDto(Order order){
        this.id = order.getId();
        this.seller = new UserDTO(order.getSeller());
        this.buyer = new UserDTO(order.getBuyer());
        this.finalprice = order.getFinalprice();
        this.orderdate = order.getOrderdate();
        this.orderProducts = order.getOrderProducts();
        this.orderid = order.getOrderid();
        this.status = order.getStatus();
        this.state = order.getState();
        this.city = order.getCity();
        this.district = order.getDistrict();
        this.locality = order.getLocality();
        this.pincode = order.getPincode();
    }


}
