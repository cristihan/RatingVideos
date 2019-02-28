package com.ratingVideo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.ratingVideo.applicationDTO.VideoDTO;
import com.ratingVideo.utilities.InvalidParamException;

@Entity(name = "Video")
public class Video {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "video_Id")
	private Integer videoId;
	@Column(name = "nameVideo")
	private String nameVideo;
	
	@ManyToOne(targetEntity = Itinerario.class)
	private Itinerario itinerario;
	
//	@OneToMany(targetEntity = Rating.class)
//	@JoinColumn(name = "rating_id")
//	private List<Rating> allRatings = new ArrayList<Rating>();
	
	public Video() {
		
	}
	
	public Video(VideoDTO videoDto) throws InvalidParamException {
		if(videoDto == null)
			throw new InvalidParamException();
		
		this.videoId = videoDto.getVideoId();
		this.nameVideo = videoDto.getNameVideo();		
	}

	public Integer getVideoId() {
		return videoId;
	}

	public String getNameVideo() {
		return nameVideo;
	}

//	public List<Rating> getAllRatings() {
//		return allRatings;
//	}
//	
//	public void addRating(Rating rating) {
//		this.allRatings.add(rating);
//	}
//	
//	public void deleteRating() {
//		this.allRatings = new ArrayList<Rating>();
//	}

}
