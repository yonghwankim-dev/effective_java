
package role10.autovalue;

// Generated by com.google.auto.value.processor.AutoValueProcessor
 final class AutoValue_Product extends Product {

  private final String name;
  private final String price;

  private AutoValue_Product(
      String name,
      String price) {
    this.name = name;
    this.price = price;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public String price() {
    return price;
  }

  @Override
  public String toString() {
    return "Product{"
        + "name=" + name + ", "
        + "price=" + price
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Product) {
      Product that = (Product) o;
      return (this.name.equals(that.name()))
           && (this.price.equals(that.price()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.name.hashCode();
    h *= 1000003;
    h ^= this.price.hashCode();
    return h;
  }

  static final class Builder extends Product.Builder {
    private String name;
    private String price;
    Builder() {
    }
    @Override
    public Product.Builder name(String name) {
      if (name == null) {
        throw new NullPointerException("Null name");
      }
      this.name = name;
      return this;
    }
    @Override
    public Product.Builder price(String price) {
      if (price == null) {
        throw new NullPointerException("Null price");
      }
      this.price = price;
      return this;
    }
    @Override
    public Product build() {
      String missing = "";
      if (this.name == null) {
        missing += " name";
      }
      if (this.price == null) {
        missing += " price";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_Product(
          this.name,
          this.price);
    }
  }

}