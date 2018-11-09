package competition;

import java.util.Arrays;

/**
 * Class to build individual competitors and get their details.
 * @author Nathan
 * @version 1.0 15 Oct 2018 
 * @see getOverallScore 
 * @see ndaAssignment1.MainClass
 * @see ndaAssignment1.Name
 */
public class HaggisChef extends Competitor{
	private int competitorNumber;
	private Name competitorName;
	private int[] score;
	private String level;
	private String dish;
	
	/** Constructs a competitor
	 * 
	 * @param competitorNumber Int containing the number of the competitor
	 * @param competitorName Name object containing the name details of competitor
	 * @param score Int array containing the scores of the competitor
	 * @param level String of the competitor's level
	 * @param dish String containing the name of dish prepared by competitor
	 * @see HaggisChef
	 */
	public HaggisChef(int competitorNumber, Name competitorName, int[] score, String level, String dish) {
		super(competitorNumber, competitorName, score, level);
		this.competitorNumber = competitorNumber;
		this.competitorName = competitorName;
		this.score = Arrays.copyOf(score, score.length); //prevents modification of values in array
		this.level = level;
		this.dish = dish;
		
	}
	
	/**
	 *  Calculates overall score for the competitor based on each score and level.
	 * @see getOverallScore 
	 * @see HaggisChef 
	 * @return Overall score obtained by competitor
	 */
	public double getOverallScore() {
		double weight, overallScore;
		weight=0;
		overallScore = 0.0;
		
		switch (level) { /* adds extra weight according to professional level. Weight to be added to the 
		'professionalism score', which is the last one.*/
		case "MasterChef": weight=4;
			break;
		case "Chef": weight=2;
			break;
		case "Cook": weight=1;
			break;
		case "Amateur": weight=0;
			break;
		default: System.err.printf("ERROR: '%s' is an invalid competitor LEVEL. Please provide a valid competitor LEVEL!", level);
			break;
		}

		for (int i = 0; i < score.length; i++) {
			if(i==(score.length-1)) {
				overallScore = overallScore + weight*score[i]; /* Adds professional weight to professionalism score*/
			}			
			else {
				overallScore = overallScore + score[i];
			}
		}
		
		return overallScore/(score.length-1 + weight);
	}
	
	/** Simple method to generate string for full details of the competitor
	 * @see getFullDetails
	 * @return String with full details of the competitor
	 */
	public String getFullDetails() {

		return String.format("---------------\nFull Details:\nCompetitor number %d, name %s \n%s is a %s level chef, prepared the dish '%s' and got the scores: %s.\nThis gives him an "
				+ "overall score of %1.1f.\n\n", competitorNumber, competitorName.getFullName(), competitorName.getFirstName(), level, dish, Arrays.toString(score).replace("[","").replace("]",""), getOverallScore());
		

	}
	
	/** Simple method to generate short details of the competitor
	 * 
	 * @return String with short details of the competitor
	 */
	public String getShortDetails() {
		
		return String.format("CN %d (%s) has overall score %1.1f.\n", competitorNumber, competitorName.getInitials(), getOverallScore());
	}


	/** Simple method to get the name of the dish prepared by the competitor
	 * 
	 * @return String with the name of the dish
	 */
	public String getDish() {
		return dish;
	}
	


}
