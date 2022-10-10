package role18.incorrect_inheritance;

// 상위 클래스의 변경이 하위 클래스의 기능에 오작동을 일으키는 경우
class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public void move(){
        System.out.println("다리를 이용하여 이동한다");
    }
}
