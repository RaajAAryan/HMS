package genericUtility;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Formatter;
import java.util.Random;



public class JavaUtility {

	public int getRandomNom()
	{
		Random ran=new Random();
		int random= ran.nextInt(500);
		return random;
	}
	
	public String getSystemDate()
	{
		Date dt=new Date();
		String date=dt.toString();
		return date;
	}
	
	public String getSystemDateinFormat()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-mm-ss");
		Date dt=new Date();
		String systemDateFormat = dateFormat.format(dt);
		return systemDateFormat;
	}
	
	public String getTimeStamp()
	{
		 LocalDateTime currentTime = LocalDateTime.now();
		 DateTimeFormatter Formatter = DateTimeFormatter.ofPattern(getSystemDate());
		 String formattedTimeStamp = currentTime.format(Formatter);
		 return formattedTimeStamp;
	}
	public String getSystemDateAndTime() {
		String timestamp = LocalDateTime.now().toString().replace(':', '-');
		return timestamp;
	}
	
}
