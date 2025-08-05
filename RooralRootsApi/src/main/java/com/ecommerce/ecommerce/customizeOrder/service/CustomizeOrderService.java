package com.ecommerce.ecommerce.customizeOrder.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.ecommerce.customizeOrder.model.CustomizeOrder;
import com.ecommerce.ecommerce.customizeOrder.model.CustomizeOrderDTO;
import com.ecommerce.ecommerce.global.Status;

public interface CustomizeOrderService {

    List<CustomizeOrder> listByStoreId(Long ownerId);

    CustomizeOrderDTO findByProductId(Long id);

    Status saveOrUpdate(CustomizeOrderDTO order, MultipartFile file);

    List<CustomizeOrder> listByBuyerId(Long buyerid);

    Status updateStatus(Long id, String status);

}
