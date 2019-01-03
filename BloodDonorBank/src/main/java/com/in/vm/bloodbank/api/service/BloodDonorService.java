package com.in.vm.bloodbank.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.vm.bloodbank.api.exception.BloodDonorNotFoundException;
import com.in.vm.bloodbank.api.model.BloodDonor;
import com.in.vm.bloodbank.api.repository.BloodDonorRepository;


/**
 * The Class BloodDonorService.
 */
@Service
public class BloodDonorService {


	@Autowired
	private BloodDonorRepository repository;

	/**
	 * Adds the blood donor.
	 *
	 * @param donor
	 *            the donor
	 * @return the string
	 */
	public String addBloodDonor(BloodDonor donor) {

		repository.save(donor);
		return "added successfully";
	}

	/**
	 * Update donor.
	 *
	 * @param donor
	 *            the donor
	 * @return the string
	 * @throws BloodDonorNotFoundException
	 *             the blood donor not found exception
	 */
	public String updateDonor(BloodDonor donor) throws BloodDonorNotFoundException {
		try {
			repository.save(donor);

		} catch (Exception ex) {
			throw new BloodDonorNotFoundException("user not updated");
		}
		return "updated sucessfully";
	}

	/**
	 * Gets the all blood donor.
	 *
	 * @return the all blood donor
	 */
	public List<BloodDonor> getAllBloodDonor() {

		return (List<BloodDonor>) repository.findAll();

	}

	/**
	 * Search blood donor with city.
	 *
	 * @param city
	 *            the city
	 * @return the list
	 * @throws BloodDonorNotFoundException
	 *             the blood donor not found exception
	 */
	public List<BloodDonor> searchBloodDonorWithCity(String city) throws BloodDonorNotFoundException {

		List<BloodDonor> list = repository.findByCity(city);
		if (list.size() == 0) {
			throw new BloodDonorNotFoundException("No Donor Found");
		}
		return list;
	}

	public List<BloodDonor> searchBloodDonorWithCityAndGroup(String city,String group) throws BloodDonorNotFoundException {

		List<BloodDonor> list = repository.findByCityAndBloodGroup(city, group);
		if (list.size() == 0) {
			throw new BloodDonorNotFoundException("No Donor Found");
		}
		return list;
	}

	
	/**
	 * Delete blood donor.
	 *
	 * @param donor
	 *            the donor
	 * @return the string
	 */
	public String deleteBloodDonor(BloodDonor donor) {
		repository.delete(donor);
		return "deleted sucessfully";
	}
}