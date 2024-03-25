package com.sapient.gotomovies.payment.data.helper;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.sapient.gotomovies.payment.data.helper.BaseEntity;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class Transaction extends BaseEntity{

	@Id
	@UuidGenerator
	private UUID id;
}
