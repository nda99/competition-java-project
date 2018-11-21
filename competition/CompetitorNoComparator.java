package competition;
import java.util.Comparator;

/**@author alaat**/
public class CompetitorNoComparator implements Comparator<Competitor>{

	//Class to compare to competitors based on numbers

	@Override
	public int compare(Competitor c1, Competitor c2) {
		
		if(c1.getCompetitorNumber() > c2.getCompetitorNumber())
		{
			return 1;
		}
		else if (c1.getCompetitorNumber() < c2.getCompetitorNumber())
		{
			return -1;
		}
		else
		{
			return 0;
		}		
	}
}

