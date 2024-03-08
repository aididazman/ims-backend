package com.my.ims.repository;

import com.my.ims.domain.inventory.TbTProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<TbTProduct, Long> {
}
