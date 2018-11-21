package competition;
import java.util.Comparator;

/**@author alaat**/
public class CompetitorNameComprator implements Comparator<Competitor>
{
	public int compare(Competitor c1, Competitor c2) {
		return c1.getCompetitorName().compareTo(c2.getCompetitorName());
	}
	

	
}


	

