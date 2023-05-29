package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class DemoApplicationTests {

	Calculator underTest = new Calculator();

	@Test
	void iShouldAddTwoNumbers() {
		//given
		int num1 = 20;
		int num2 = 30;

		//when
		int result = underTest.add(num1, num2);

		//then
		int expected = 50;
		assertThat(result).isEqualTo(expected);

	}

	}

class Calculator {
	int add(int num1, int num2) {
		return num1 + num2;
	}
}