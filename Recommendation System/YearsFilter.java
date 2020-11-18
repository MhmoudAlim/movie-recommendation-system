
/**
 * Write a description of YearsFilter here.
 * 
 * @author (Mahmoud Alim) 
 * @version (a version number or a date)
 */
public class YearsFilter implements Filter {
	private int myYear;
	
	public YearsFilter(int year) {
		myYear = year;
	}
	
	@Override
	public boolean satisfies(String id) {
		return Moviedatabase.getYear(id) >= myYear;
	}


}

