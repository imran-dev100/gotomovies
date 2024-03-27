package com.sapient.gotomovies.theatre.data;

import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.sapient.gotomovies.theatre.data.helper.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "theatre_company")
public class TheatreCompany extends BaseEntity{
	
	@Id
	@UuidGenerator
	private UUID id;
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address headquarter;
	
	@OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
	private Set<Theatre> theatres;
}
