package com.sapient.gotomovies.theatre.data;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.sapient.gotomovies.theatre.data.helper.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "shows")
public class Show extends BaseEntity {

	@Id
	@UuidGenerator
	private UUID id;
	private String startTime;
	private int durationInMin;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "theatre_id", referencedColumnName = "id")
	private Theatre theatre;
	
	@Column(name="movie_id")
	private String movieId;
}
