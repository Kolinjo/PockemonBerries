package test;
import static org.junit.Assert.*;

import static org.junit.Assume.assumeTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Test;

import marko.kozic.Berry;
import marko.kozic.BerryUtillities;

class BerryTest {

	@Test
	public void connectingTest() throws MalformedURLException, IOException {

		assertTrue(BerryUtillities.makingConnection("https://pokeapi.co/api/v2/berry/").contains("count"));
		assertFalse(BerryUtillities.makingConnection("https://pokeapi.co/api/v2/berry/").contains("size"));
	}
	
	
	@Test

	public void collectingBerries() throws MalformedURLException, IOException {		
		
		assertEquals(new Berry("cheri", 20, 3).toString(), BerryUtillities.collectingBerries().get(0).toString());
		assertNotEquals(new Berry("pecha", 40, 3).toString(), BerryUtillities.collectingBerries().get(10).toString());
	}
	
	@Test
	public void findMinGrowthTime () throws MalformedURLException, IOException {
		assertNotEquals(2, BerryUtillities.collectingBerries().get(0).toString());
		
	}
	
	@Test
	public void findBerryWithMaxSize () throws MalformedURLException, IOException{
		assertNotEquals(120, BerryUtillities.collectingBerries().get(5).toString());
	}
	

}
