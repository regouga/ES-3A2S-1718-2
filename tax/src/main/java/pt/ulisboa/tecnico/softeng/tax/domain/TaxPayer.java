package pt.ulisboa.tecnico.softeng.tax.domain;

import pt.ulisboa.tecnico.softeng.tax.exception.TaxException;

public abstract class TaxPayer {
	private String nif;
	private String name;
	private String address;
	private IRS irs;
	
	public TaxPayer(String nif, String name, String address){
		checkArguments(nif, name, address);
		
		this.nif = nif;
		this.name = name;
		this.address = address;
		this.irs = IRS.getInstance();
		
		irs.addTaxPayer(this);
	}
	
	private void checkArguments(String nif, String name, String address){
		checkNif(nif);
		checkName(name);
		checkAddress(address);
	}
	
	private void checkNif(String nif) {
		if(nif == null || nif.equals("") || (nif.trim()).equals("")){
			throw new TaxException();
		}
		if(nif.length() != 9){
			throw new TaxException();
		}
		if(!nif.matches("[0-9]+")){
			throw new TaxException();
		}
		if(irs.getTaxPayer(nif) != null){
			throw new TaxException();
		}
	}

	private void checkName(String name) {
		if(name == null || name.equals("") || (name.trim()).equals("")){
			throw new TaxException();
		}		
	}

	private void checkAddress(String address) {
		if(address == null || address.equals("") || (address.trim()).equals("")){
			throw new TaxException();
		}		
	}

	public String getNif() {
		return nif;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	
	
}
