package com.naz.walletSystemApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "com.naz.walletSystemApi.entity")
@EnableJpaRepositories(basePackages = "com.naz.walletSystemApi.repository")
@EnableTransactionManagement
public class WalletSystemApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalletSystemApiApplication.class, args);
	}

}
