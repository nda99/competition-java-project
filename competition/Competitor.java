package competition;


public abstract class Competitor {
	
	protected int competitorNumber;
	protected Name competitorName;
	protected int[] score;
	protected String level;
	
	
	
	/** Constructs a competitor
	 * 
	 * @param competitorNumber Int containing the number of the competitor
	 * @param competitorName Name object containing the name details of competitor
	 * @param score Int array containing the scores of the competitor
	 * @param level String of the competitor's level
	 * @see Competitor
	 */
	public Competitor (int competitorNumber, Name competitorName, int[] score, String level)
	{
		this.competitorNumber = competitorNumber;
		this.competitorName = competitorName;
		this.score = score.clone();
		this.level = level;
	}
	
	
	
	/**
	 *  Calculates overall score for the competitor based on each score and level.
	 * @see getOverallScore 
	 * @see Competitor
	 * @return Overall score obtained by competitor
	 */
	
	public abstract double getOverallScore();
	
	/** Simple method to generate string for full details of the competitor
	 * @see getFullDetails
	 * @return String with full details of the competitor
	 */
	public abstract String getFullDetails() ;
	
	

	/** Simple method to generate short details of the competitor
	 * 
	 * @return String with short details of the competitor
	 */
	public String getShortDetails() 
	{
		
		return String.format("CN %d (%s) has overall score %1.1f.\n", competitorNumber, competitorName.getInitials(), getOverallScore());
	}
	
	
	/** Simple method to get the scores of the competitor
	 * 
	 * @return int [] array with all scores of the competitor
	 */
	public int[] getScoreArray() 
	{
		return score;
	}
	
	/** Simple method to get the name of the competitor name for report
	 * 
	 * @return String with full name of a competitor
	 */
	public String getCompetitorName() 
	{
	
		return competitorName.getFullName();
	}
	
	
	/** Simple method to get the level of the competitor 
	 * 
	 * @return String with level of competitor
	 */
	public String getLevel() 
	{
		return level;
	}
	
	/** Simple method to get the number of the competitor 
	 * 
	 * @return Integer containing the competitor's number
	 */
	public int getCompetitorNumber() 
	{
		return competitorNumber;
	}


	/** Simple method to set the number of the competitor 
	 * 
	 */
	public void setCompetitorNumber(int competitorNumber) {
		this.competitorNumber = competitorNumber;
	}


	/** Simple method to set the name of the competitor 
	 * 
	 */
	public void setCompetitorName(Name competitorName) {
		this.competitorName = competitorName;
	}


	/** Simple method to set the scorea of the competitor 
	 * 
	 */
	public void setScore(int[] score) {
		this.score = score;
	}


	/** Simple method to set the level of the competitor 
	 * 
	 */
	public void setLevel(String level) {
		this.level = level;
	}
	
	public String getCompetitorType()
	{
		String type = Manager.getType();
		//String type = "Hockey";

		return type;
	}
	
	


}
