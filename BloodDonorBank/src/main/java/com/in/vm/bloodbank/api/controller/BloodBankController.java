package com.in.vm.bloodbank.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.vm.bloodbank.api.exception.BloodDonorNotFoundException;
import com.in.vm.bloodbank.api.model.BloodDonor;
import com.in.vm.bloodbank.api.service.BloodDonorService;

/**
 * The Class BloodBankController.
 */

@RestController
@RequestMapping("/blood/api")
public class BloodBankController {

	/** The service. */
	@Autowired
	private BloodDonorService service;

	/**
	 * Register blood donor.
	 *
	 * @param donor
	 *            the donor
	 * @return the string
	 */
	@PostMapping("/register")
	public String registerBloodDonor(@RequestBody BloodDonor donor) {
		String msg = service.addBloodDonor(donor);
		return msg;
	}

	/**
	 * Gets the all donors.
	 *
	 * @return the all donors
	 */
	@GetMapping("/donors")
	public List<BloodDonor> getAllDonors() {
		return service.getAllBloodDonor();

	}

	/**
	 * Gets the all donors by city.
	 *
	 * @param city
	 *            the city
	 * @return the all donors by city
	 * @throws BloodDonorNotFoundException 
	 */
	@GetMapping("/donors/{city}")
	public List<BloodDonor> getAllDonorsByCity(@PathVariable String city) throws BloodDonorNotFoundException {

		return service.searchBloodDonorWithCity(city);
	}

	@GetMapping("/donors/{city}/{group}")
	public List<BloodDonor> getAllDonorsByCityAndGroup(@PathVariable String city,@PathVariable String group) throws BloodDonorNotFoundException {

		return service.searchBloodDonorWithCityAndGroup(city, group);
	}

	
	
	/**
	 * Delete blood donor.
	 *
	 * @param donor
	 *            the donor
	 * @return the string
	 */
	@DeleteMapping("/delete")
	public String deleteBloodDonor(@RequestBody BloodDonor donor) {
		return service.deleteBloodDonor(donor);
	}

	
	
	
}
