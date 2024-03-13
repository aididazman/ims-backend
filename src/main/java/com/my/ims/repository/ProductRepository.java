package com.my.ims.repository;

import com.my.ims.domain.inventory.TbTProduct;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<TbTProduct, String> {

    TbTProduct findOneByPkProductId(String pkProductId);

    TbTProduct findByPkProductId(String pkProductId);

}
