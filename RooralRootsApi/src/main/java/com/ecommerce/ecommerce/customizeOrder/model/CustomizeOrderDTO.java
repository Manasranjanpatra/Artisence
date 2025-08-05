package com.ecommerce.ecommerce.customizeOrder.model;

import java.util.Date;
import com.ecommerce.ecommerce.users.Entity.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomizeOrderDTO {
    
       private Long id;
    private UserDTO buyer;
    private UserDTO seller;
    private String name;
    private String image;
    private Integer qty;
    private Date orderdate;
    private Float totalprice;
    private String orderid;
    private String description;
    private String status="pending";

    private String locality;
    private String city;
    private String state;
    private String district;
    private String pincode;

        public CustomizeOrderDTO(CustomizeOrder order) {
        this.id = order.getId();
        this.seller = new UserDTO(order.getSeller());
        this.buyer = new UserDTO(order.getBuyer());
        this.totalprice = order.getTotalprice();
        this.orderdate = order.getOrderdate();
        this.orderid = order.getOrderid();
        this.status = order.getStatus();
        this.image=order.getImage();
        this.name=order.getName();
        this.qty=order.getQty();
        this.description=order.getDescription();
        this.locality=order.getLocality();
        this.city=order.getCity();
        this.state=order.getState();
        this.district=order.getDistrict();
        this.pincode=order.getPincode();

    }
}
