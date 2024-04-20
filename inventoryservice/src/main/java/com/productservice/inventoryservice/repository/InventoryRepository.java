package com.productservice.inventoryservice.repository;

import com.productservice.inventoryservice.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findBySkucodeIn(List<String> skuCode);
}
