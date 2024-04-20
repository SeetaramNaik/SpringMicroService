package com.productservice.inventoryservice.service.impl;

import com.productservice.inventoryservice.dto.InventoryResponse;
import com.productservice.inventoryservice.repository.InventoryRepository;
import com.productservice.inventoryservice.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;


    @Override
    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        return inventoryRepository.findBySkucodeIn(skuCode)
                .stream().map(inventory ->
                    InventoryResponse.builder()
                            .skuCode(inventory.getSkucode())
                            .isInStock(inventory.getQuantity() > 0)
                            .build()
                ).toList();

    }
}
