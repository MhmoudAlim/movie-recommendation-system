
/**
 * Write a description of MinutesFilter here.
 * 
 * @author (Mahmoud Alim) 
 * @version (a version number or a date)
 */
public class MinutesFilter implements Filter{
	private int myMinMinutes;
	private int myMaxMinutes;

	public MinutesFilter(int minMinutes,int maxMinutes){
		myMinMinutes = minMinutes;
		myMaxMinutes = maxMinutes;
	}

	@Override
	public boolean satisfies(String id){
		int time =Moviedatabase.getMinutes(id);
		if(time >= myMinMinutes && time <= myMaxMinutes){
			return true;
		}

		else{
			return false;
		}
	}
}