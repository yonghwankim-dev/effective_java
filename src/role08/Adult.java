package role08;

public class Adult {
	public static void main(String[] args) {
		try(Room myRoom = new Room(7)){
			System.out.println("�ȳ�~");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
