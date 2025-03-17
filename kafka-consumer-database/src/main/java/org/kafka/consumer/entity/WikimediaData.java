package org.kafka.consumer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="WikiMedia_recentChange")

public class WikimediaData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String wikiEventData;


	public WikimediaData() {
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getWikiEventData() {
		return wikiEventData;
	}


	public void setWikiEventData(String wikiEventData) {
		this.wikiEventData = wikiEventData;
	}
	
	

}
