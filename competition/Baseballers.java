package competition;

public class Baseballers extends Competitor {

	//private int number;
	//private Name name;
	//private String category;
	//private int[] score = new int[5];
	private int age;
	private String nationality;
	private String FullDetails;
	private String ShortDetails;

	public Baseballers(int competitorNumber, Name competitorName, String level, int[] score,  String nationality, int age, String type) {
		super(competitorNumber,competitorName,score,level,type);
		this.competitorNumber = competitorNumber;
		this.competitorName = competitorName;
		this.level = level;
		// this.OverallScore = OverallScore;
		this.nationality = nationality;
		this.age = age;
		
	}

	public double getOverallScore() {
		// int[] myIntArray={ 5,4,4,5,3};
		int weight ;
		String cat = this.getLevel();


		if(cat .equals("Rookie"))
			{
			weight = 1;
			}
		else if( cat.equals("Advanced"))
		{
				 weight = 2;
		}else{
			weight = 3;
		}
			
		
		double overall = (double) 0.625*weight*(this.score[0] + this.score[1] + this.score[2] + this.score[3] + this.score[4])
				/ this.score.length;
		
		return overall;

	}
//		//scores array
//	public void setBaseballerScore(int scoreGained1, int scoreGained2, int scoreGained3, int scoreGained4,
//			int scoreGained5) {
//		score[0] = scoreGained1;
//		score[1] = scoreGained2;
//		score[2] = scoreGained3;
//		score[3] = scoreGained4;
//		score[4] = scoreGained5;
//
//
//
//	}
	

	
	

//	public void setName(String name) {
//		this.name.setName(name);
//	}
//
//	public String getName() {
//
//		if (this.name.getMiddleName() != "")
//			return this.name.getFirstName() + " " + this.name.getMiddleName() + " " + this.name.getLastName();
//		else
//			return this.name.getFirstName() + " " + this.name.getLastName();
//	}
//
//	public int getNumber() {
//		return this.number;
//	}
//
//	public String getCategory() {
//		return this.category;
//	}


	public String getNationality() {
		return this.nationality;
	}

	public void getDisplay() {
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("\n" + getFullDetails()+ "\n");
		System.out.println("Short Details: \n"+ getShortDetails());
		System.out.println("-----------------------------------------------------------------------------------\n");
		

	}

//	public void setNumber(int number) {
//		this.number = number;
//	}
//
//	public void setCategory(String category) {
//		this.category = category;
//	}
//
//	public int[] getScore() {
//		return score;
//	}
//
//	public void setScore(int[] score) {
//		this.score = score;
//	}
//
	public String getFullDetails() {
		return "Competitor number " + competitorNumber + ", name " + competitorName.getFullName() + ", category " + level +
				", country " + nationality + ".\n" + competitorName.getFirstName() + " aged " + age + " has received these scores: " +
				score[0] + ", " + score[1] + ", " + score[2] + ", " + score[3] + ", " + score[4] +
				".\nThis gives him/her an overall score of " + getOverallScore() + ".";
	}
//
	public void setFullDetails(String fullDetails) {
		FullDetails = fullDetails;
	}
//
//	public String getShortDetails() {
//		String shortDetails = "CN "+ this.getNumber()+" ("+name.shortName() +") has overall score " + this.getOverallScore() + ".";
//		return shortDetails;
//	}

	public void setShortDetails(String shortDetails) {
		ShortDetails = shortDetails;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getAttribute()
	{
		return this.nationality;
	}
}
