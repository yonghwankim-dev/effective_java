package role10.autovalue;

public class Driver {

    public static void main(String[] args) {
        Product product = Product.builder().price("test").name("myname").build();
        Product product2 = Product.builder().price("test").name("myname").build();
        Product product3 = Product.builder().price("test").name("myname").build();
        
        // 반사성 테스트
        System.out.println(product.equals(product));
        
        // 대칭성 테스트
        System.out.println(product.equals(product2));
        System.out.println(product2.equals(product));
        
        // 추이성 테스트
        System.out.println(product.equals(product2));
        System.out.println(product2.equals(product3));
        System.out.println(product.equals(product3));
        
        // 일관성 테스트
        System.out.println(product.equals(product2));
        
        // null 아님 테스트
        System.out.println(product.equals(null));
    }
}
