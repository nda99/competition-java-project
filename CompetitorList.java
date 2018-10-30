package ndaAssignment1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class to hold and handle details and statistics of an ArrayList of HaggisChef competitors. 
 * Performs operations on the list, but not on individual competitors.
 * @author Nathan
 * @see ndaAssignment1.HaggisChef
 * @see ndaAssignment1.Manager
 */
public class CompetitorList {

	private ArrayList<HaggisChef> competitors = new ArrayList<HaggisChef>();

	/**
	 * Constructor for Competitor List object, which holds a list of all competitors.
	 * @param competitor is an ArrayList of all the competitor objects (HaggisChef).
	 */
	public CompetitorList(ArrayList<HaggisChef> competitor) {
		this.competitors = competitor;
	}
	
	/**
	 * Method to get a competitor of choice based on his/her Competitor Number (CN)
	 * @param CN competitor number
	 * @return HaggisChef object holding the information of the competitor of choice.
	 * @see CompetitorList
	 * @see HaggisChef 
	 */
	public HaggisChef getCompetitor(int CN) {

		HaggisChef choice = null;

		for (HaggisChef h : this.competitors) {
			if (h.getCN() == CN) {
				choice = h;
				break;
			}
		}

		if (choice == null) {
			System.out.format("ERROR: Competitor number %d does not exist. Please enter an existing Competitor Number\n", CN);
		}

		return choice;

	}

    /**
     * Method which loops through list to find competitor with HIGHEST SCORE.
     * @return HaggisChef object holding the details of the competitor with highest score.
     * @see ndaAssignment1.HaggisChef
     * @see ndaAssignment1.CompetitorList
     */
	public HaggisChef getBestCompetitor() {
		double score = -1;
		HaggisChef best = null;
		for (HaggisChef h : this.competitors) {
			if (h.getOverallScore() > score) {
				score = h.getOverallScore();
				best = h;
			}
		}

		return best;
	}

	/**
	 * Method to build the report based on the list of competitors.
	 * @return String variable containing report information based on the list.
	 * @see ndaAssignment1.Manager
	 * @see getFreq
	 * @see getStats
	 */
	public String getReport() {
		String rep = String.format("--------\nREPORT:\n%20.50s %18.10s %18.30s %26.6s %15.8s\n", "Competitor", "Level", "Dish", "Scores",
				"Overall");

		for (HaggisChef h : competitors) {

			// rep = String.format(rep + "%1.20s %10.10s %2.5d %2.5d %2.5d %2.5d %2.5d
			// %10.8f\n",h.getName(),h.getLevel(),h.getScoreArray()[0],h.getScoreArray()[1],h.getScoreArray()[2],h.getScoreArray()[3],h.getScoreArray()[4],h.getOverallScore());

			rep = String.format(rep + "%3.3s %25.25s %10.10s %31.31s %15.20s %10.1f\n", h.getCN(), h.getName(),
					h.getLevel(), h.getDish(),
					Arrays.toString(h.getScoreArray()).replace("[", "").replace("]", "").replace(",", " "),
					h.getOverallScore());

		}
		return rep;
	}

	 /**
	  * Method to compute Frequency of scores: [ 0 1 2 3 4 5] 
	  * @return int[] array with frequency of each score on the list
	  */
	public int[] getFreq() {
		int[] freq = new int[6];

		for (HaggisChef h : competitors) {
			for (int i = 0; i < 5; i++) {
				if (h.getScoreArray()[i] == 0) {
					freq[0]++;
				} else if (h.getScoreArray()[i] == 1) {
					freq[1]++;
				} else if (h.getScoreArray()[i] == 2) {
					freq[2]++;
				} else if (h.getScoreArray()[i] == 3) {
					freq[3]++;
				} else if (h.getScoreArray()[i] == 3) {
					freq[3]++;
				} else if (h.getScoreArray()[i] == 4) {
					freq[4]++;
				} else if (h.getScoreArray()[i] == 5) {
					freq[5]++;
				}
			}
		}

		return freq;
	}
	
	/**
	 * Method to get STATISTICS for the Haggis Competition.
	 * @return String variable holding statistical details of the competition.
	 */
	public String getStats() {
		
		int total;
		double maxScore, avgScore = 0, minScore = 999; 
		String winner;
		
		//get total number of competitors.
		total = competitors.size();
		
		//get Average score;		
		for (HaggisChef h : competitors) {
			avgScore += h.getOverallScore();
		}
		avgScore /= total;
		
		//get number of competitors
		
		int masterChef = 0, amateur = 0, cook = 0, chef = 0;
		for (HaggisChef c : competitors) {
			switch (c.getLevel()){
			case "MasterChef": masterChef++;
			break;
			case "Chef": chef++;
			break;
			case "Cook": cook++;
			break;
			case "Amateur": amateur++;
			break;
			}
		}
		
		//get Max score
		maxScore = getBestCompetitor().getOverallScore();
		winner = getBestCompetitor().getName();
		//getMinScore
		for (HaggisChef h : competitors) {
			if (h.getOverallScore() < minScore) {
				minScore = h.getOverallScore();
			}
		}
			
		String stats = String.format("-------------\nSTATISTICS:\nWinner of Haggis Competition is %s with an overall score of %1.1f \nTotal number of competitors: %d, Min score: %1.1f, Max score: %1.1f, Avg score: %1.1f\nScore:     0  1   2   3   4   5\nFrequency: %s\nAmateurs: %d, Cooks: %d, Chefs: %d, Master Chefs: %d", winner, maxScore, total, minScore, maxScore, avgScore, Arrays.toString(getFreq()).replace("[", "").replace("]", "").replaceAll(","," "),amateur,cook,chef,masterChef);
		
		return stats;
	}
}
