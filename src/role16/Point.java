package role16;

// 이러한 인스턴스 필드들을 모아놓은 클래스들은 외부에 노출시키지 말아야한다.
// public 대신 package-private(default), private로 접근자를 설정함
class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
