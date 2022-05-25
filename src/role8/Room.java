package role8;

import java.lang.ref.Cleaner;
import java.lang.ref.Cleaner.Cleanable;

public class Room implements AutoCloseable{
	private static final Cleaner CLEANER = Cleaner.create();
	
	// û�Ұ� �ʿ��� �ڿ�. ���� Room�� �����ؼ��� �ȵ�
	// �����Ѵٸ� ��ȯ������ �߻��Ͽ� �ڿ�ȸ���� �ȵ� �� ����
	private static class State implements Runnable{
		int numJunkPiles;	// ��(Room) ���� ������ ��
	
		public State(int numJunkPiles) {
			this.numJunkPiles = numJunkPiles;
		}
		
		// close �޼��峪 cleaner�� ȣ���Ѵ�
		@Override
		public void run() {
			System.out.println("�� û��");
			numJunkPiles = 0;
		}
	}
	
	// ���� ����. cleanable�� ������
	private final State state;
	
	// cleanable ��ü. ���� ����� �Ǹ� ���� û����
	private final Cleaner.Cleanable cleanable;
	
	public Room(int numJunkPiles) {
		state = new State(numJunkPiles);
		// Room ��ü(this)�� ����Ǹ� ����� ������ ���
		cleanable = CLEANER.register(this, state);
	}
	
	@Override
	public void close() throws Exception {
		// Room ��ü�� ����ɶ� State.run ������ ����
		cleanable.clean();
	}
}
