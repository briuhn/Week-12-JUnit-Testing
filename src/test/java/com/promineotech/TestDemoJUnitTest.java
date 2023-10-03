package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach; 
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

class TestDemoJUnitTest {

	private TestDemo testDemo;
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.addPositive(a,b)).isEqualTo(expected);
		}else {
			assertThatThrownBy(() -> testDemo.addPositive(a,b)).isInstanceOf(IllegalArgumentException.class);
		} 
	}
	
	public static Stream<Arguments> argumentsForAddPositive(){
		return Stream.of(
			arguments(2,6,8, false),
			arguments(4,2,6, false),
			arguments(-2,2,0, true),
			arguments(-3,3,0, true),
			arguments(4,-7,-3, true),
			arguments(10,-4,6, true)
			
		);
	}
	
	
	
	//Check to see if a number is divisible by ten
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForIsDivisbleByTen")
	void assertThatNumberIsDivisibleByTen(int number, boolean expectedResult) {
		assertThat(testDemo.isDivisibleByTen(number)).isEqualTo(expectedResult);
	}
	
	public static Stream<Arguments> argumentsForIsDivisbleByTen(){
		return Stream.of(
				arguments(20, true),
				arguments(15, false),
				arguments(0, true),
				arguments(-10, true),
				arguments(7, false)
				);
	}
	
	
	
	
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		
		assertThat(fiveSquared).isEqualTo(25);
	}

}
