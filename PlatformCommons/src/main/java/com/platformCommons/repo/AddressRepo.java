package com.platformCommons.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platformCommons.model.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{

}
