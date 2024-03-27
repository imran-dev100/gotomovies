package com.sapient.gotomovies.movies.dto;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class MovieDto extends BaseAuditDto{

	private String id;
	private String title;
    private String description;
    
    @JsonProperty("duration_in_mins")
    private int durationInMins;
    private String language;
    
    @JsonProperty("release_date")
    private Date releaseDate;
    private String genre;
    private List<String> reviews;
}