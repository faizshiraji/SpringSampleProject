package com.doller.vendor.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.doller.vendor.entities.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {

}
