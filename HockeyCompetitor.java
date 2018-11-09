
public class HockeyCompetitor extends Competitor{

	private String country;
	
	public HockeyCompetitor(int comptNo,Name comptName,String comptLevel,int[] score,String nationality) {
		
		super(comptNo,comptName,score,comptLevel);
		this.country=nationality;
	}
	

	@Override
	public String getFullDetails() {
		String details= "Competitor number "+super.competitorNumber+", name "+getCompetitorName()+" country "+country+ "\n"+getCompetitorName()+ " is a "+level+ " and received these super.score "+super.score[0]+","+super.score[1]+","+super.score[2]+","+super.score[3]+","+super.score[4]+" and This gives him an an overall score of "+ getOverallScore(); 
	     return details;
	}
	
	@Override
	public String getShortDetails() {
    String details= "CN "+super.competitorNumber+", name "+super.competitorName.getInitials()+" has an overall score of "+ getOverallScore(); 
    return details;
	}
	
	public int getLevelWeight(String level)
	{
		
		int weight = 0;
		switch (level)
		{
			case "Novice" : weight =1;break;
			case "Expert": weight = 2;break;
			default : weight =1;
		}
		return weight;
	}
	
	@Override
	public double getOverallScore() 
	{ 
		double overall = getLevelWeight(getLevel())*(getFirstMatchScore()+getSecondMatchScore()+getThirdMatchScore()+getFourthMatchScore()+getFifthMatchScore())/super.score.length;
		return (overall); 
	}
	
	public void setFirstMatchScore(int score)
	{
		super.score[0]=score;
	}
	public int getFirstMatchScore()
	{
		return super.score[0];
	}
	public void setSecondMatchScore(int score)
	{
		super.score[1]=score;
	}
	public int getSecondMatchScore()
	{
		return super.score[1];
	}
	public void setThirdMatchScore(int score)
	{
		super.score[2]=score;
	}
	public int getThirdMatchScore()
	{
		return super.score[2];
	}
	public void setFourthMatchScore(int score)
	{
		super.score[3]=score;
	}
	public int getFourthMatchScore()
	{
		return super.score[3];
	}
	public void setFifthMatchScore(int score)
	{
		super.score[4]=score;
	}
	public int getFifthMatchScore()
	{
		return super.score[4];
	}

}
