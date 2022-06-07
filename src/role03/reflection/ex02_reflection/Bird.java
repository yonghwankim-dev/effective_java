package role03.reflection.ex02_reflection;

public class Bird extends Animal{
	private boolean walks;
	
	public Bird() {
		super("bird");
	}
	
	public Bird(String name) {
		super(name);
	}
	
	public Bird(String name, boolean walks) {
		super(name);
		setWalks(walks);
	}
	
	public boolean walks() {
		return walks;
	}
	
	public void setWalks(boolean walks) {
		this.walks = walks;
	}
	
	private void method1() {
		System.out.println("call Bird.method1");
	}

	@Override
	public String eats() {
		return "eats";
	}

	@Override
	protected String getSound() {
		return "grilook";
	}

}
