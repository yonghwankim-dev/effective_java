package role8;

import java.lang.ref.Cleaner;
import java.lang.ref.Cleaner.Cleanable;

public class Room implements AutoCloseable{
	private static final Cleaner CLEANER = Cleaner.create();
	
	// 청소가 필요한 자원. 절대 Room을 참조해서는 안됨
	// 참조한다면 순환참조가 발생하여 자원회수가 안될 수 있음
	private static class State implements Runnable{
		int numJunkPiles;	// 방(Room) 안의 쓰레기 수
	
		public State(int numJunkPiles) {
			this.numJunkPiles = numJunkPiles;
		}
		
		// close 메서드나 cleaner가 호출한다
		@Override
		public void run() {
			System.out.println("방 청소");
			numJunkPiles = 0;
		}
	}
	
	// 방의 상태. cleanable과 공유함
	private final State state;
	
	// cleanable 객체. 수거 대상이 되면 방을 청소함
	private final Cleaner.Cleanable cleanable;
	
	public Room(int numJunkPiles) {
		state = new State(numJunkPiles);
		// Room 객체(this)가 종료되면 수행될 쓰레드 등록
		cleanable = CLEANER.register(this, state);
	}
	
	@Override
	public void close() throws Exception {
		// Room 객체가 종료될때 State.run 쓰래드 수행
		cleanable.clean();
	}
}
