import java.util.Calendar;
import java.util.Date;


public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello, world!");
		Calendar cal = Calendar.getInstance();
		cal.set(2000,0,1);
		java.util.Date time = cal.getTime();
		Date date = new Date(time.getTime());
		System.out.println(date);
	}

}
