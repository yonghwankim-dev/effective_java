package role18.incorrect_inheritance_solution;

class Car {
    // 개선 : final 키워드를 적용하여 재정의하지 못하도록 함
    public final void move(){
        System.out.println("move!!");
    }

}
