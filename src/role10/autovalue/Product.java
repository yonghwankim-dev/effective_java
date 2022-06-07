package role10.autovalue;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Product {
 
      public abstract String name();
      public abstract String price();
 
      @AutoValue.Builder
      public abstract static class Builder {
        public abstract Builder name(String name);
        public abstract Builder price(String price);
        public abstract Product build();
      }
 
      public static Product.Builder builder() {
        return new AutoValue_Product.Builder();
      }
}
