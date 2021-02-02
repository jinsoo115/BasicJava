package e_oop;



public class TV {

	public static void main(String[] args) {
		TV tv = new TV();
		
		while(true){
			System.out.println("--------------------------");
			System.out.println("1.전원 2.채널변경 3.채널업 4.채널다운");
			System.out.println("5.볼륨업 6.볼륨다운 0.종료");
			System.out.println("--------------------------");
			System.out.print("번호 입력>");
			int input = ScanUtil.nextInt();
			
			switch (input){
			case 1: tv.power(); break;
			case 2:
				System.out.print("변경할 채널 입력>");
				int ch = ScanUtil.nextInt();
				tv.changeChannel(ch);
				break;
			case 3: tv.channelUp(); break;
			case 4: tv.channelDown(); break;
			case 5: tv.volumeUp(); break;
			case 6: tv.volumeDown(); break;
			case 0:
				System.out.println("종료되었습니다.");
				System.exit(0);
			}
			
		}
		
//		tv.channelDown();
//		tv.TvOn();
//		tv.VolumeUp();
//		tv.channelUp();
//		tv.channelDown();
//		tv.VolumeDown();
//		tv.TvOff();
//		tv.VolumeDown();
	}
	//전원 on/off
	//볼륨 up/down
	//채널 up/down
	boolean power=false;
	int volume = 1;
	int channel = 5;
	
	final int MIN_CHANNEL = 1;
	final int MAX_CHANNEL = 100;
	final int MIN_VOLUME = 0;
	final int MAX_VOLUME = 10;
	
	void power(){
		power = !power;
		System.out.println(power ? "TV 켜짐" : "TV 꺼짐");
	}
	
	void changeChannel(int channel){
		if(power){
			if(MIN_CHANNEL <= channel && channel <= MAX_CHANNEL){
				this.channel = channel;
			}
			System.out.println("채널: " + this.channel);
		}
	}
	
	void channelUp(){
		changeChannel(channel+1);
	}
	
	void channelDown(){
		changeChannel(channel-1);
	}
	
	void volumeUp(){
		if(power){
			if(volume < MAX_VOLUME){
				volume++;
			}
			showVolume();
		}
	}
	
    void volumeDown(){
    	if(power){
			if(MIN_VOLUME < volume){
				volume--;
			}
			showVolume();
		}
	}
    
    void showVolume(){
    	System.out.print("음량. ");
    	for(int i = MIN_VOLUME+1; i<= MAX_VOLUME; i++){
    		if(i <=volume){
    			System.out.print("■");
    		}else{
    			System.out.print("□");
    		}
    	}
    	System.out.println();
    	
    }
    
    
    
/*	void TvOn(){
		power = true;
		System.out.println("Tv On");
	}
	
	void TvOff(){
		power = false;
		System.out.println("Tv Off");
	}
	
	void VolumeUp(){
		if(power){
			volume++;
			System.out.println("Volume: " + volume);
		}else{
			System.out.println("전원이 꺼져 있습니다.");
		}
	}
	void VolumeDown(){
		if(power){
			volume--;
			System.out.println("Volume: " + volume);
		}else{
			System.out.println("전원이 꺼져 있습니다.");
		}
	}
	
	void channelUp(){
		if(power){
			channel++;
			System.out.println("channel: " + channel);
		}else{
			System.out.println("전원이 꺼져 있습니다.");
		}
	}
	
	void channelDown(){
		if(power){
			channel--;
			System.out.println("channel: " + channel);
		}else{
			System.out.println("전원이 꺼져 있습니다.");
		}
	}*/
}
