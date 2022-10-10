package role18.incorrect_inheritance_solution;

// 개선 : 추상 클래스를 이용하여 move 메서드를 구현하도록 함
abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void move();
}
