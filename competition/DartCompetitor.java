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
	private int[] score;
	private String level;
	private int levelWeight = 3;
	//Constructor
	public DartCompetitor(int competitorNumber, Name competitorName,  String level, int[] score, int age) 
	{
		super(competitorNumber,competitorName,score,level);
		
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
		
		public  int getage() {
			return age;
		}
		

		public String getFullDetails()  {
			
			int[] cscores = super.getScoreArray();
			double wscore  = getOverallScore();
			
			return 	String.format(competitorName.getFullName() + " is a level " + level + " aged %d has a score of: %f", age, wscore);
			}
			
		public  String getShortDetails() {
			return " CN" + super.competitorNumber + " has Overall score 5" + "stands for Competitor's Number";}
		
		
		// Main Method
		@Override
		public double getOverallScore() {
			double w = 1/levelWeight;
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

