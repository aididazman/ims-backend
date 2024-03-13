package com.my.ims.repository;

import com.my.ims.domain.inventory.TbTSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SupplierRepository extends JpaRepository<TbTSupplier, String> {

    TbTSupplier findByPkSupplierId(String pkSupplierId);

    @Query(value = "select s.* " +
            "from tb_t_supplier s " +
            "left join tb_m_productsupply ps on ps.supply_id = s.pk_supplierid " +
            "left join tb_t_product p on p.pk_productid = ps.product_id " +
            "where p.pk_productid = ?1",
            nativeQuery = true)
    List<TbTSupplier> findByPkProductId(String pkProductId);

}
