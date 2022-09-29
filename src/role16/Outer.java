package role16;

class Outer {
    private static class Point{
        public double x;
        public double y;
    }

    public String name;

    public Point getPoint(){
        Point point = new Point();
        point.x = 5;
        point.y = 3;
        return point;
    }
}
