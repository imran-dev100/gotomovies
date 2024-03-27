package com.sapient.gotomovies.theatre.data;

import com.sapient.gotomovies.theatre.data.helper.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address extends BaseEntity {

	@Id
	private String id;
	@Column(name = "street_address")
	private String streetAddress;

	private String city;
	private String state;

	@Column(name = "zip_code")
	private String zipCode;
	private String country;
}
