package competition;
import java.util.Comparator;

/**@author alaat**/

public class CompetitorScoresComparator implements Comparator<Competitor>{

	//Class to compare to competitors based on overalls

	@Override
	public int compare(Competitor c1, Competitor c2) {
		
		if(c2.getOverallScore() > c1.getOverallScore())
		{
			return 1;
		}
		else if (c2.getOverallScore() < c1.getOverallScore())
		{
			return -1;
		}
		else
		{
			return 0;
		}		
	}
}

