package com.ecommerce.ecommerce.customizeOrder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.ecommerce.customizeOrder.model.CustomizeOrder;
import com.ecommerce.ecommerce.customizeOrder.model.CustomizeOrderDTO;
import com.ecommerce.ecommerce.customizeOrder.service.CustomizeOrderService;
import com.ecommerce.ecommerce.global.Status;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/v1/custom-order")
public class CustomizeOrderController {

    @Autowired
    private CustomizeOrderService cOService;

    @GetMapping(value = "/list/owner/{ownerId}")
    public List<CustomizeOrder> listByStoreId(@PathVariable Long ownerId) {
        return cOService.listByStoreId(ownerId);
    }
    
    @GetMapping(value = "/list/buyer/{buyerid}")
    public List<CustomizeOrder> listByBuyerId(@PathVariable Long buyerid) {
        return cOService.listByBuyerId(buyerid);
    }

    @GetMapping(value = "/id/{id}")
    public CustomizeOrderDTO getById(@PathVariable Long id) {
        return cOService.findByProductId(id);
    }

    @RequestMapping(value = "/saveorupdate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Status saveOrUpdateProduct(@RequestPart("product") CustomizeOrderDTO order,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        return cOService.saveOrUpdate(order, file);
    }

        @GetMapping(value = "/status/id/{id}/{status}")
    public Status updateStatus(@PathVariable Long id,@PathVariable String status) {
        return cOService.updateStatus(id,status);
    }

}
