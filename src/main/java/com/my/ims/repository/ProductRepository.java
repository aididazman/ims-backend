package com.my.ims.repository;

import com.my.ims.domain.inventory.TbTProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProductRepository extends JpaRepository<TbTProduct, String> {

    TbTProduct findOneByPkProductIdAndStatus(String pkProductId, Integer status);

    TbTProduct findByPkProductIdAndStatus(String pkProductId, Integer status);

    List<TbTProduct> findAllByStatus(Integer status);

    @Modifying
    @Query("UPDATE TbTProduct p SET p.status = :status WHERE p.pkProductId IN (:pkProductIds)")
    void deleteByPkProductIds(@Param("status") Integer status, @Param("pkProductIds") List<String> pkProductIds);

}
