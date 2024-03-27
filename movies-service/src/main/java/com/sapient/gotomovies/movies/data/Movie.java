package com.sapient.gotomovies.movies.data;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.sapient.gotomovies.movies.data.helper.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Movie")
public class Movie extends BaseEntity{

	@Id
	private String id;
	private String title;
    private String description;
    
    @Field(name = "duration_in_mins")
    private int durationInMins;
    private String language;
    
    @Field(name = "release_date")
    private Date releaseDate;
    private String genre;
    
    private List<String> reviews;
}
