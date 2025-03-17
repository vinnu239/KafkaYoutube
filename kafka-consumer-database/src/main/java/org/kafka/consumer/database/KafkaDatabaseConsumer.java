package org.kafka.consumer.database;

import org.kafka.consumer.entity.WikimediaData;
import org.kafka.consumer.repository.WikiMediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
	
	@Autowired
	private WikiMediaRepository wikiMediaRepostiory;
	
	
	@KafkaListener(topics="Wikimedia_recentChange",groupId = "myGroup")
	
	public void consume(String eventMessage) {
		LOGGER.info(String.format("Event message received -> %s",eventMessage));
		
		WikimediaData wikimediaData = new WikimediaData();
		wikimediaData.setWikiEventData(eventMessage);
		
		// stroign in to db
		
		wikiMediaRepostiory.save(wikimediaData);
		
	}
	
	
}
