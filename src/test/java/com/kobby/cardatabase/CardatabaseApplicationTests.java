package com.kobby.cardatabase;

import com.kobby.cardatabase.web.CarController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CardatabaseApplicationTests {

	@Autowired
	private CarController carController;

	@Test
	@DisplayName("My first test example")
	void contextLoads() {
		assertThat(carController).isNotNull();
	}

}
