package com.in.vm.bloodbank.api.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.in.vm.bloodbank.api.model.BloodDonor;

public interface BloodDonorRepository extends PagingAndSortingRepository<BloodDonor, Integer>{

	public List<BloodDonor> findByCity(String city);
	public List<BloodDonor> findByCityAndBloodGroup(String city, String bloodGroup);
	
}
