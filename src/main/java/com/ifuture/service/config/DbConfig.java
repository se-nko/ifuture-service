package com.ifuture.service.config;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

	@Bean
	@Primary
	public DataSource inMemoryDS() throws Exception {
		return EmbeddedPostgres.builder()
				.start().getPostgresDatabase();
	}

}
