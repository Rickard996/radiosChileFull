package com.Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.Application.model.Radio;
import com.Application.repositories.RadioRepository;


//in this spring boot app I am going to build a back with Rest Controllers
//to be requested by the front with JS for the behavior 
//I expect to use images, and make a loop for create all the radio elements and not 
//have to hardcode every html radio tag

//A MySql Database will be added. I must search the configurations for developing and production

@SpringBootApplication
public class RadiosChileApplication {

	//RadiosChileApplication HAS-A RadioRepository which i will use to preload the initial data
	public final RadioRepository repo;
	
	//lets add a log
	private static final Logger logger = LoggerFactory.getLogger(RadiosChileApplication.class);
	
	//the constructor to wire
	public RadiosChileApplication(RadioRepository repo) {
		super();
		this.repo = repo;
	}

	public static void main(String[] args) {
		SpringApplication.run(RadiosChileApplication.class, args);
	}
	
	//here a will preload all the data of the initial radios to my in memory DB
	
	@Bean
	CommandLineRunner preloadRadios() {
		
		//this method expects a CommandLineRunner as a return type
		//so now lets use a lambda function
		return (args)->{
			repo.deleteAll();  //dangerous but fine for this app
			repo.save(new Radio("Radio Bio bio Puerto Montt", "https://unlimited11-cl.dps.live/biobiopuertomontt/aac/icecast.audio", "biobio.png"));
			repo.save(new Radio("Radio Imagina", "https://19293.live.streamtheworld.com/IMAGINAAAC.aac?csegid=12000&dist=imagina_cl-web-live_streaming_play&tdsdk=js-2.9&swm=false&pname=TDSdk&pversion=2.9&banners=none&gdpr=0&burst-time=15&sbmid=38bdb308-d666-4828-eb39-fe0586d72be7", "imagina.png"));
			repo.save(new Radio("Radio Pudahuel", "https://20823.live.streamtheworld.com/PUDAHUELAAC.aac?csegid=12000&dist=pudahuel_cl-web-live_streaming_play&tdsdk=js-2.9&swm=false&pname=TDSdk&pversion=2.9&banners=none&gdpr=0&burst-time=15&sbmid=98ead5b7-f47b-42b7-c83c-6e02c8324bb9", "radio-pudahuel.png"));
			repo.save(new Radio("Radio BioBio Concepcion", "https://unlimited11-cl.dps.live/biobioconcepcion/aac/icecast.audio", "biobio.png"));
			repo.save(new Radio("Radio BioBio Santiago", "https://unlimited3-cl.dps.live/biobiosantiago/aac/icecast.audio", "biobio.png"));
			repo.save(new Radio("Radio Los 40 Chile", "https://24083.live.streamtheworld.com/LOS40_CHILEAAC.aac?csegid=12000&dist=los40-web-live_streaming_play&tdsdk=js-2.9&swm=false&pname=TDSdk&pversion=2.9&banners=none&gdpr=0&burst-time=15&sbmid=3b5e2d33-7abc-45a6-b7b9-5f321376df67", "los-40.png"));
			repo.save(new Radio("Radio ADN", "https://24073.live.streamtheworld.com/ADNAAC.aac?csegid=12000&dist=adn_cl-web-live_streaming_play&tdsdk=js-2.9&swm=false&pname=TDSdk&pversion=2.9&banners=none&gdpr=0&burst-time=15&sbmid=d8b605da-20fe-4ace-9912-39a1556504fa", "adn-radio.png"));
			repo.save(new Radio("Radio FM DOS", "https://24483.live.streamtheworld.com/FMDOSAAC.aac?csegid=12000&dist=fmdos_cl-web-live_streaming_play&tdsdk=js-2.9&swm=false&pname=TDSdk&pversion=2.9&banners=none&gdpr=0&burst-time=15&sbmid=43e388fe-d76c-4a24-f28b-aabe0d607df2", "fmdos.png"));
			repo.save(new Radio("Radio Digital", "https://unlimited11-cl.dps.live/digitalfm/aac/icecast.audio", "radio-digital.png"));
			//this is not icecast format but will work fine
			repo.save(new Radio("Radio El Conquistador", "https://stream10.usastreams.com:10998/;", "el-conquistador.png"));
			logger.info("all the Radios have been preloaded!! in the production DB");
			
		};
	}
	
	
	

}
