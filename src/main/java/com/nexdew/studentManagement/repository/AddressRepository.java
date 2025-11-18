package com.nexdew.studentManagement.repository;

import com.nexdew.studentManagement.entity.Address;
import com.nexdew.studentManagement.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    @Query("SELECT DISTINCT s FROM Students s JOIN s.addresses a WHERE a.addressId = :addressId")
    List<Students> findAllStudentsByAddressId(@Param("addressId") Long addressId);
}