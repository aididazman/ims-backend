package com.my.ims.repository;

import com.my.ims.domain.inventory.TbTInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<TbTInventory, Long> {
}
