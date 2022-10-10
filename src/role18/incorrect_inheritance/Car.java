package role18.incorrect_inheritance;

class Car {
    // 문제 : 하위 클래스에게 재정의의 가능성을 노출시킴
    public void move(){
        System.out.println("move!!");
    }
    
    // 개선 : final 키워드를 적용하여 재정의하지 못하도록 함
//    public final void move(){
//        System.out.println("move!!");
//    }

}
