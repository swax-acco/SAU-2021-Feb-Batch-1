package com.main;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Test;

public class PrimeNumberMockitoTest {
	
	CheckPrimeService checkPrimeService = mock(CheckPrimeService.class);
	PrimeNumber primeNumber = new PrimeNumber(checkPrimeService);
	
	@Test
	public void testPrimeNumber() {		
		when(checkPrimeService.getPrimeStatus(19)).thenReturn(true);
		assertEquals(true,primeNumber.getPrimeStatusByNumber(19));
	}

	@Test
	public void testPrimeNumber1() {		
		when(checkPrimeService.getPrimeStatus(4)).thenReturn(true);
		assertEquals(true,primeNumber.getPrimeStatusByNumber(4));
	}
}
