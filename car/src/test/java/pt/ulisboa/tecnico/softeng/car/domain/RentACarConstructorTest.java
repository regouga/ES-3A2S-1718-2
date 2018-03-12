package pt.ulisboa.tecnico.softeng.car.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pt.ulisboa.tecnico.softeng.car.exception.CarException;
import pt.ulisboa.tecnico.softeng.tax.domain.Buyer;
import pt.ulisboa.tecnico.softeng.tax.exception.CarException;

public class RentACarConstructorTest {
	private final String NAME = "João Siva";
	
	@Test
	public void sucess() {
		RentACar rentacar = new RentACar(NAME);
		assertEquals(NAME, rentacar.getName());
	}
}