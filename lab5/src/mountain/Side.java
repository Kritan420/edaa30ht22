package mountain;

public class Side {
    Point a;
    Point b;

    public Side(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    @Override 
    public int hashCode() {
        return a.hashCode() + b.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Side) {
            Side side = (Side) o;
            return side.hashCode() == this.hashCode();
        } else {
            return false;
        }
        
    }
}
