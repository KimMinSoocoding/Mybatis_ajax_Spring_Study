package ex;

public enum EnumDeviceState {
	// 생성자 호출
	ON("켜짐"), OFF("꺼짐"), PAUSE("일시정지"), STOP("멈춤"), PLAY("동작중");
	
	// ON, OFF, PAUSE, STOP, PLAY 상수는 내부적으로 new를 통해 만들어진 객체
	
	// 켜짐, 꺼짐, 일시정지, 멈춤, 동작중 문자열을 갖는 멤버변수 
	private final String state;
	
	private EnumDeviceState(String state) {
		this.state = state;
	}
	
	public String getState() {
		return state;
	}
}

/* 
 내부적으로 다음과 같은 동작으로 볼 수 있음 
   class EnumDeviceState{
   	public static final EnumDeviceState ON = new EnumDeviceState("켜짐");
   	public static final EnumDeviceState OFF = new EnumDeviceState("꺼짐");
   	public static final EnumDeviceState PAUSE = new EnumDeviceState("일시정지");
   	public static final EnumDeviceState STOP = new EnumDeviceState("멈춤");
   	public static final EnumDeviceState PLAY = new EnumDeviceState("동작중");
   }
   
   private final String state; 
   
   private EnumDeviceState(String state){
   		this.state = state;
   }
 
 */
