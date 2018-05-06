package pt.ulisboa.tecnico.softeng.broker.services.local.dataobjects;

import java.util.ArrayList;
import java.util.List;

import pt.ulisboa.tecnico.softeng.broker.domain.Adventure;
import pt.ulisboa.tecnico.softeng.broker.domain.BulkRoomBooking;
import pt.ulisboa.tecnico.softeng.broker.domain.Client;
import pt.ulisboa.tecnico.softeng.broker.services.local.dataobjects.BrokerData.CopyDepth;

public class ClientData {	
	private String iban;
	private String nif;
	private String drivingLicense;
	private Integer age;

	private List<AdventureData> adventures = new ArrayList<>();

	public ClientData() {
	}

	public ClientData(Client client, CopyDepth depth) {
		this.iban = client.getIban();
		this.nif = client.getNif();
		this.drivingLicense = client.getDrivingLicense();
		this.age = client.getAge();
		
		switch (depth) {
		case ADVENTURES:
			for (Adventure adventure : client.getAdventureSet()) {
				this.adventures.add(new AdventureData(adventure));
			}
			break;
		default:
			break;
		}
		
	}
	
	public ClientData(String iban, String nif, String drivingLicense, int age) {
		this.iban = iban;
		this.nif = nif;
		this.drivingLicense = drivingLicense;
		this.age = age;
	}

	public String getIban() {
		return this.iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getNif() {
		return this.nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getDrivingLicense() {
		return this.drivingLicense;
	}

	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public List<AdventureData> getAdventures() {
		return this.adventures;
	}

	public void setAdventures(List<AdventureData> adventures) {
		this.adventures = adventures;
	}
}
