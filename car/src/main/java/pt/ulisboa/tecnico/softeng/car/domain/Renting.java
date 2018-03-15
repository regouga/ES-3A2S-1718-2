package pt.ulisboa.tecnico.softeng.car.domain;

import org.joda.time.LocalDate;

import pt.ulisboa.tecnico.softeng.car.exception.CarException;

public class Renting{
	private static int counter = 0;

	private final String reference;
	private String drivingLicence;
	private String cancellation;
	private LocalDate cancellationDate;
	private final LocalDate arrival;
	private final LocalDate departure;
	private int kilometers;

	Renting(String drivingLicence, LocalDate arrival, LocalDate departure) {
		checkArguments(drivingLicence, arrival, departure);

		this.drivingLicence = drivingLicence;
		this.reference = Integer.toString(++Renting.counter);
		this.arrival = arrival;
		this.departure = departure;
		this.kilometers = 0;
	}

	private void checkArguments(String drivingLicence, LocalDate arrival, LocalDate departure) {
		if (drivingLicence == null || drivingLicence == ""  || arrival == null || departure == null) {
			throw new CarException();
		}

		if (departure.isBefore(arrival)) {
			throw new CarException();
		}
		
		if (invalidDrivingLicence(this.drivingLicence)) {
			throw new CarException();
		}
	}
	
	public boolean invalidDrivingLicence(String drivingLicence){
		if(drivingLicence == null || drivingLicence == "") {
			return true;
		}
		
		String[] servicoEmissor = drivingLicence.split("\\d+");
		String[] ordinal = drivingLicence.split("[a-zA-Z]+");
		if (servicoEmissor.length != 1 || ordinal.length != 1) {
			return true;
		}
		
		String checkDriving = servicoEmissor[0] + ordinal[0];
		if(checkDriving != drivingLicence) {
			return true;
		}
		
		return false;
	}

	public String getReference() {
		return this.reference;
	}

	public String getCancellation() {
		return this.cancellation;
	}

	public LocalDate getArrival() {
		return this.arrival;
	}

	public LocalDate getDeparture() {
		return this.departure;
	}

	public LocalDate getCancellationDate() {
		return this.cancellationDate;
	}


	public String cancel() {
		this.cancellation = this.reference + "CANCEL";
		this.cancellationDate = new LocalDate();
		return this.cancellation;
	}

	public boolean isCancelled() {
		return this.cancellation != null;
	}
}