package com.my.ims.inventory.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<TbTProduct, String> {

    TbTProduct findOneByPkProductIdAndStatus(String pkProductId, Integer status);

    TbTProduct findByPkProductIdAndStatus(String pkProductId, Integer status);

    List<TbTProduct> findAllByStatus(Integer status);

    @Query("SELECT p FROM TbTProduct p WHERE p.status = :status")
    Page<TbTProduct> findAllByStatus(@Param("status") Integer status, Pageable productPageable);

    @Modifying
    @Query("UPDATE TbTProduct p SET p.status = :status WHERE p.pkProductId IN (:pkProductIds)")
    void deleteByPkProductIds(@Param("status") Integer status, @Param("pkProductIds") List<String> pkProductIds);

}
