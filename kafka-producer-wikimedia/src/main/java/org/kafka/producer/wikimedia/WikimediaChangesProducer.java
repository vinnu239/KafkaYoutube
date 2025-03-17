package org.kafka.producer.wikimedia;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;

@Service
public class WikimediaChangesProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesProducer.class);
	private KafkaTemplate<String, String> kafkaTemplate;

	public WikimediaChangesProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage() {
		String topic = "Wikimedia_recentChange";
		EventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate, topic);
		String filePath = "C:\\Users\\10828446\\git\\KafkaYoutube\\kafka-producer-wikimedia\\src\\main\\java\\org\\kafka\\producer\\wikimedia\\KafkaDummyData.txt";

		try {
			// Read data from file
			String data = new String(Files.readAllBytes(Paths.get(filePath)));
			// Create a MessageEvent object
			MessageEvent messageEvent = new MessageEvent(data, null, null);
			// Process the data
			eventHandler.onMessage(null, messageEvent);

			// Below is for reading real time data because of proxy issues
//            I created txt file and add small amount of data
			
			// use this for reading live stream url
//    		String url = "https://opensky-network.org/api/states/all";
			// the below eventsource if for reading live stream data because of proxy issues
			// I am pasting the data
			// in one of the file and use it here instead of live stream
			
//         			 EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url))
//         		                .connectTimeout(Duration.ofSeconds(30)) // Increase connection timeout
//         		                .reconnectTime(Duration.ofSeconds(10));

			// here source will connect to the wiwkmedia and get trigger the handler
//			EventSource eventSource = builder.build();
//			eventSource.start();

			// Pause execution for 10 minutes
			TimeUnit.MINUTES.sleep(10);
		} catch (IOException e) {
			// Handle the exception
			e.printStackTrace();
		} catch (InterruptedException e) {
			// Handle the exception
			e.printStackTrace();
		} catch (Exception e) {
			// Handle the exception
			e.printStackTrace();
		}
	}
}