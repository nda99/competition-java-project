
import java.util.ArrayList;
import java.util.Arrays;

public abstract class CompetitorList {
	
	
	private ArrayList<Competitor> competitors = new ArrayList<Competitor>();
	
	/**
	 * Constructor for Competitor List object, which holds a list of all competitors.
	 * @param competitor is an ArrayList of all the competitor objects (Competitor).
	 */
	public CompetitorList(ArrayList<Competitor> competitor) 
	{
		this.competitors = competitor;
	
	}
	

	/**
	 * Method to get a competitor of choice based on his/her Competitor Number (CN)
	 * @param CN competitor number
	 * @return Competitor object holding the information of the competitor of choice.
	 * @see CompetitorList
	 * @see Competitor 
	 */
	public Competitor getCompetitor(int CN) {

		Competitor choice = null;

		for (Competitor c : this.competitors) {
			if (c.getCompetitorNumber() == CN) {
				choice = c;
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
     * @return Competitor object holding the details of the competitor with highest score.
     */
	
	public Competitor getBestCompetitor() {
		double score = -1;
		Competitor best = null;
		for (Competitor c : this.competitors) {
			if (c.getOverallScore() > score) {
				score = c.getOverallScore();
				best = c;
			}
		}

		return best;
	}
	
	
	 /**
	  * Method to compute Frequency of scores: [ 0 1 2 3 4 5] 
	  * @return int[] array with frequency of each score on the list
	  */
	public int[] getFreq() {
		int[] freq = new int[6];

		for (Competitor c : competitors) {
			for (int i = 0; i < 5; i++) {
				if (c.getScoreArray()[i] == 0) {
					freq[0]++;
				} else if (c.getScoreArray()[i] == 1) {
					freq[1]++;
				} else if (c.getScoreArray()[i] == 2) {
					freq[2]++;
				} else if (c.getScoreArray()[i] == 3) {
					freq[3]++;
				} else if (c.getScoreArray()[i] == 3) {
					freq[3]++;
				} else if (c.getScoreArray()[i] == 4) {
					freq[4]++;
				} else if (c.getScoreArray()[i] == 5) {
					freq[5]++;
				}
			}
		}

		return freq;
}
	
	/**
	 * Method to get STATISTICS for the Competition.
	 * @return String variable holding statistical details of the competition.
	 */
	public String getStats() {
		
		int total;
		double maxScore, avgScore = 0, minScore = 999; 
		String winner;
		
		//get total number of competitors.
		total = competitors.size();
		
		//get Average score;		
		for (Competitor h : competitors) {
			avgScore += h.getOverallScore();
		}
		avgScore /= total;
		
			
		//get Max score
		maxScore = getBestCompetitor().getOverallScore();
		winner = getBestCompetitor().getCompetitorName();
		//getMinScore
		for (Competitor c : competitors) {
			if (c.getOverallScore() < minScore) {
				minScore = c.getOverallScore();
			}
		}
			
		String stats = String.format("-------------\nSTATISTICS:\nWinner of "
				+ "Haggis Competition is %s with an overall score of %1.1f \nTotal number of competitors: "
				+ "%d, Min score: %1.1f, Max score: %1.1f, Avg score: %1.1f\nScore:"
				+ "     0  1   2   3   4   5\nFrequency: %s", 
				winner, maxScore, total, minScore, maxScore, avgScore, Arrays.toString(getFreq()).replace("[", "").replace("]", "").replaceAll(","," "),getLevelFreq());
		
		return stats;
}
	
	/**
	 * Method to build the report based on the list of competitors.
	 * @return String variable containing report information based on the list.
	 * @see getFreq
	 * @see getStats
	 */
public abstract String getReport();

/**
 * Method to get frequency of competitor levels.
 */
public abstract String getLevelFreq();

	
}
