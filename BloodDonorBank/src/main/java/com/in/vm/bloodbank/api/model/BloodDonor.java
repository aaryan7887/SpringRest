package com.in.vm.bloodbank.api.model;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@Document(collection="BloodBank")
public class BloodDonor {
	
	/** The id. */
	@Id
	@Indexed
	private int id;
	
	/** The name. */
	private String name;
	
	/** The city. */
	private String city;
	
	/** The country. */
	private String country;
	
	/** The mobile. */
	
	private String mobi;
	
	/** The blood group. */
	private String bloodGroup;
	
	
	
}
