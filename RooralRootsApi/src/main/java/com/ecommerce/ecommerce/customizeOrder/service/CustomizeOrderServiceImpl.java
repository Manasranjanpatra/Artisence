package com.ecommerce.ecommerce.customizeOrder.service;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.ecommerce.customizeOrder.model.CustomizeOrder;
import com.ecommerce.ecommerce.customizeOrder.model.CustomizeOrderDTO;
import com.ecommerce.ecommerce.customizeOrder.repository.CustomizeOrderRepo;
import com.ecommerce.ecommerce.global.Status;
import com.ecommerce.ecommerce.users.Entity.User;
import com.ecommerce.ecommerce.users.Entity.UserDTO;
import com.ecommerce.ecommerce.users.Repository.UserRepo;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomizeOrderServiceImpl implements CustomizeOrderService {

    @Autowired
    CustomizeOrderRepo cOrderRepo;

    @Autowired
    UserRepo userRepo;

    @Override
    public CustomizeOrderDTO findByProductId(Long id) {
        return cOrderRepo.findById(id).map(CustomizeOrderDTO::new)
                .orElseThrow(() -> new EntityNotFoundException("order not found with ID: " + id));
    }

    @Override
    public Status saveOrUpdate(CustomizeOrderDTO productDTO, MultipartFile file) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User user = userRepo.findByPhone(authentication.getName());

            if (!authentication.isAuthenticated()) {
                return new Status(false, "Login Before Order!");
            }
            CustomizeOrder order = new CustomizeOrder();
            if (productDTO.getId() == null) {
                order = new CustomizeOrder(productDTO);
                order.setOrderdate(new Date());
                order.setBuyer(user);
                String fileName = StringUtils.cleanPath(file.getOriginalFilename());
                if (!fileName.contains("..")) {

                    order.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
                }
            }
            cOrderRepo.save(order);
            return new Status(true, productDTO.getId() == null ? "successfuly receive order" : "update successfuly");
        } catch (Exception e) {
            return new Status(false, "An error occurred");
        }
    }

    @Override
    public List<CustomizeOrder> listByStoreId(Long ownerId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User seller = userRepo.findByPhone(authentication.getName());
        List<CustomizeOrder> productlist = cOrderRepo.findAllBySeller_id(seller.getId());
        return productlist;
    }

    @Override
    public List<CustomizeOrder> listByBuyerId(Long buyerid) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User buyer = userRepo.findByPhone(authentication.getName());
        return cOrderRepo.findAllByBuyer_id(buyer.getId());
    }

    @Override
    public Status updateStatus(Long id, String status) {
      CustomizeOrder order=cOrderRepo.findById(id).get();
      order.setStatus(status);
      cOrderRepo.save(order);
      return new Status(true,"Status Updated to "+status);
    }
    

}
