
public class Name {

private String name;
	
	/**
	 * Constructor of Name object from an input String (name of competitor). 
	 * @param name String variable holding the name of a competitor.
	 * @see Name
	 */
	public Name(String name) {
		this.name = name;
	}
	
	/**
	 * Simple method to get the full name of the competitor.
	 * @return String variable holding the full name of the competitor.
	 */
	public String getFullName() {
		return name;
	}
	/**
	 * Method to get the first name of the competitor.
	 * @return String variable holding the first name of the competitor.
	 */
	public String getFirstName() {
		String fname;
		fname="";
		String[] names = name.split(" ");
		for (int i=0; i < names.length; i++) {
			if (names[i].length() !=0) {
				fname = names[i];
				break;
			}
		}
		

		
		
		return fname;
	}
	
	/**
	 * Method to get initials of the competitor.
	 * @return String variable holding the initials of the competitor.
	 */
	public String getInitials() {
		String init;
		init="";
		String[] names = name.split(" ");
		for (int i=0; i < names.length; i++) {
			if(names[i].length() != 0) {
			init= init  + names[i].charAt(0);	
			}
		}
		return init;
}
}
