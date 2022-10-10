package role18.incorrect_inheritance_solution;

class Reptile extends Animal {
    public Reptile(String name) {
        super(name);
    }

    @Override
    public void move() {
        System.out.println("±â¾î°©´Ï´Ù.");
    }
}
