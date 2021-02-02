package e_oop;

public class TVno1 {
	
	public static void main(String[] args) {
		TVno1 tv = new TVno1();
		while(true){
			System.out.println("---------------------------");
			System.out.println("1.전원 2.채널변경 3.채널업 4.채널다운");
			System.out.println("5.볼륨업 6.볼륨다운 0.종료");
			System.out.println("---------------------------");
			System.out.print("번호입력>");
			int input = ScanUtil.nextInt();
			
			switch(input){
			case 1: tv.TvPower(); break;
			case 2:
				System.out.print("변경할 채널 입력>");
				int channel=ScanUtil.nextInt();
				tv.changeChannel(channel);
				break;
			case 3: tv.ChannelUp(); break;
			case 4: tv.ChannelDown(); break;
			case 5: tv.VolumeUp(); break;
			case 6: tv.VolumeDown(); break;
			case 0: 
				System.out.println("종료합니다.");
				System.exit(0);
			}
		}
	}
	
	boolean power = false;
	int channel =1;
	int volume =1;
	
	final int MIN_CHANNEL=1;
	final int MAX_CHANNEL=100;
	final int MIN_VOLUME=0;
	final int MAX_VOLUME=10;
	
	void TvPower(){
		power = !power;
		System.out.println(power ? "TV 켜짐" : "TV꺼짐");
	}
	
	void changeChannel(int channel){
		if(power){
			if(MIN_CHANNEL<=channel && channel <= MAX_CHANNEL){
				this.channel = channel;
			}
		}
		System.out.println("채널: " + this.channel);		
	}
	
	void ChannelUp(){
		changeChannel(channel+1);
	}
	
	void ChannelDown(){
		changeChannel(channel-1);
	}
	
	void VolumeUp(){
		if(power){
			if(volume < MAX_VOLUME){
				volume++;
			}
			ShowVolume();
		}
	}
	
	void VolumeDown(){
		if(power){
			if(MIN_VOLUME < volume){
				volume--;
			}
			ShowVolume();
		}
	}
	
	void ShowVolume(){
		if(power){
			System.out.print("음량: ");
			for(int i = MIN_VOLUME+1; i <=MAX_VOLUME; i++){
				if(volume>=i){
					System.out.print("★");
				}else{
					System.out.print("☆");
				}
			}
			System.out.println();
		}
	}

}
