package com.sapient.gotomovies.user.data.entity;

import java.sql.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class BaseEntity {

	@CreatedBy
	@Column(name = "created_by")
	private String createdBy;

	@LastModifiedBy
	@Column(name = "updated_by")
	private String updatedBy;

	@CreatedDate
	@Column(name = "created_at", nullable = false)
	private Date createdAt;

	@LastModifiedDate
	@Column(name = "updated_at", nullable = false)
	private Date updatedAt;
}
