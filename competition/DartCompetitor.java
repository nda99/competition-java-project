package competition;

import static java.lang.System.out;
import java.util.*;
/**
 * @author armandtene
 *
 */
public class DartCompetitor extends Competitor{
	
	private String age;	
	private float OverallScore;
	private  String Competitor;
	private int level;
	
	//Constructor
	public DartCompetitor(int num, Name fullname,  String lv, String dob, int[] mScore) 
	{
		super(num,fullname,mScore,lv);
		
	
		
	}
	
		//method
		
		public  String getage() {
			return age;
		}
		

		public String getFullDetails(int cnumber, String firstName, String middleName, String lastName, int age, int clevel ) {
			
			int[] cscores = super.getScoreArray();
			double wscore  = getOverallScore();
			
			return 	firstName + " " + middleName + " " + lastName + " is a level " + clevel + " aged " + age + " has a score of: " + wscore;
			}
			
		public  String getShortDetails() {
			return " CN" + super.competitorNumber + " has Overall score 5" + "stands for Competitor's Number";}
		
		
		// Main Method
		@Override
		public double getOverallScore() {
			double w = 1/level;
			int sumall = 0;
			for(int i=0; i< 4; ++i) {
				sumall = sumall + super.score[i];
			}
			double wsumall = w*sumall;
			
			return wsumall;
		}
	
	@Override
	public String getFullDetails() {
	int[] cscores = super.getScoreArray();
	double wscore  = getOverallScore();
					
	return 	super.getCompetitorName()+ " is a level " + level + " aged " + age + " has a score of: " + wscore;
				
	}

	}

