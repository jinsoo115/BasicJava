package g_oop2;

public class Time {

	private int hour;
	private int minute;
	private int second;

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
	
		if(hour <0 || 24 < hour){
			this.hour = 0;
		}else if(hour == 24){
			this.hour = 0;
		}else{
			this.hour = hour;
		}
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
	
		if(minute <0 || 60 < minute){
			this.minute = 0;
		}else if(minute == 60){
			setHour(hour+1);
			this.minute = 0;
		}else{
			this.minute = minute;
		}
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		if(second <0 || 60 < second){
			this.second = 0;
		}else if(second == 60){
			setMinute(minute+1);
			this.second = 0;
		}else{
			this.second = second;
		}
	}

	String getTime(){
		return hour + ":" + minute + ":" + second;
	}
	
	void clock(){
		int tempS = 1;
		int tempM = 1;
		int tempH = 1;
		while(true){
			System.out.println(getTime());
			stop(1000);
			setSecond(second + 1);
//			tempS = getSecond();
//			if(tempS==0){
//				setMinute(minute + 1);
//				tempM = getMinute();
//				tempS=1;
//			}
//			if(tempM==0){
//				setHour(hour + 1);
//				tempH = getHour();
//				tempM=1;
//			}
		}
	}
	
	private void stop(int interval){
		try {
			Thread.sleep(interval);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
