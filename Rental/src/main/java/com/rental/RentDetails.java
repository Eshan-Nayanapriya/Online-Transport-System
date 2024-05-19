package com.rental;

public class RentDetails {

	private int id;
	private String name;
	private String PickupLocation;
	private String DropLocation;
	private String email;
	private String phone;
	private String other;

	public RentDetails(int nid, String nname, String npickupLocation, String ndropLocation, String nemail,
			String nphone, String nother) {
		this.id = nid;
		this.name = nname;
		this.PickupLocation = npickupLocation;
		this.DropLocation = ndropLocation;
		this.email = nemail;
		this.phone = nphone;
		this.other = nother;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPickupLocation() {
		return PickupLocation;
	}

	public String getDropLocation() {
		return DropLocation;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getOther() {
		return other;
	}

}
