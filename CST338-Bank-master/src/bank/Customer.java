package bank;

public class Customer implements Comparable<Customer> {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private int ssn;
	private String address;
	@Override
	public int compareTo(Customer o) {
		if(ssn < o.getSsn()){
			return -1;
		}
		else if (ssn > o.getSsn()){
			return 1;
		}
		else{
			return 0;
		}
		
	}
	
}
