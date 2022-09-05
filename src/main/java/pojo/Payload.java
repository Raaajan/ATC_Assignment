package pojo;

public class Payload {

	public Create createpayload(String name, String job) {
		 
		Create cr = new Create();
		
		cr.setName(name);
		cr.setJob(job);
		
		return cr;
	}
}
