package role10.autovalue;

public class Driver {

    public static void main(String[] args) {
        Product product = Product.builder().price("test").name("myname").build();
        Product product2 = Product.builder().price("test").name("myname").build();
        Product product3 = Product.builder().price("test").name("myname").build();
        
        // �ݻ缺 �׽�Ʈ
        System.out.println(product.equals(product));
        
        // ��Ī�� �׽�Ʈ
        System.out.println(product.equals(product2));
        System.out.println(product2.equals(product));
        
        // ���̼� �׽�Ʈ
        System.out.println(product.equals(product2));
        System.out.println(product2.equals(product3));
        System.out.println(product.equals(product3));
        
        // �ϰ��� �׽�Ʈ
        System.out.println(product.equals(product2));
        
        // null �ƴ� �׽�Ʈ
        System.out.println(product.equals(null));
    }
}
