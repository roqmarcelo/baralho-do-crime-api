package com.github.roqmarcelo.baralhodocrimeapi;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.lang.NonNull;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BaralhoDoCrimeApiApplication implements InitializingBean {

	private final CardRetrieverJob cardRetrieverJob;

	public BaralhoDoCrimeApiApplication(@NonNull final CardRetrieverJob cardRetrieverJob) {
		this.cardRetrieverJob = cardRetrieverJob;
	}

	public static void main(String[] args) {
		SpringApplication.run(BaralhoDoCrimeApiApplication.class, args);
	}

	@Override
	public void afterPropertiesSet() {
		cardRetrieverJob.execute();
	}
}