package competition;

import static java.lang.System.out;
import java.util.*;
/**
 * @author armandtene
 *
 */
public class DartCompetitor extends Competitor{
	
	private int age;	
	private int competitorNumber;
	private Name competitorName;
	private String level;
	private int levelWeight = 3;
	//Constructor
	public DartCompetitor(int competitorNumber, Name competitorName,  String level, int[] score, int age,String type) 
	{
		super(competitorNumber,competitorName,score,level,type);
		
		this.competitorNumber = competitorNumber;
		this.competitorName = competitorName;
		this.level = level;
		this.age = age;
		
		if (level == "1") {
			levelWeight = 1;
		}
		
		else if(level == "2") {
			levelWeight = 2;
		}
				
	}
	
		//method
		
		public  int getAge() {
			return age;
		}
		

		public String getFullDetails()  {
			
			int[] cscores = super.getScoreArray();
			double wscore  = getOverallScore();
			
			return 	String.format(competitorName.getFullName() + " is a level " + level + " aged %d has a score of: %f", age, wscore);
			}
			
		public  String getShortDetails() {
			return String.format(" CN %d (%s) has Overall score %2.2f", super.competitorNumber,super.competitorName.getInitials(),getOverallScore());}
		
		
		// Main Method
		@Override
		public double getOverallScore() {
			double w = 1.0/levelWeight;
			int sumall = 0;
			for(int i=0; i< 4; ++i) {
				sumall = sumall + super.score[i];
			}
			double wsumall = w*sumall;
			
			return wsumall;
		}
	
	//@Override
	//public String getFullDetails() {
	//int[] cscores = super.getScoreArray();
	//double wscore  = getOverallScore();
					
	//return 	super.getCompetitorName()+ " is a level " + level + " aged " + age + " has a score of: " + wscore;
				
	//}

	}

