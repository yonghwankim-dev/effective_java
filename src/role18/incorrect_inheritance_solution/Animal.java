package role18.incorrect_inheritance_solution;

// ���� : �߻� Ŭ������ �̿��Ͽ� move �޼��带 �����ϵ��� ��
abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void move();
}
