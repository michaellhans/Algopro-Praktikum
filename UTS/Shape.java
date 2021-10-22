// NIM      : 13518056
// Nama     : Michael Hans
// Tanggal  : Jumat, 15 Oktober 2021
// Topik    : UTS Praktikum Shape
// Deskripsi: Implementasi Kelas Shape

interface Movable {
    public void move(int dx, int dy);
}

interface Mirrorable {
    public void mirrorX();

    public void mirrorY();
}

class Point implements Movable, Mirrorable {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void mirrorX() {
        this.y = -this.y;
    }

    @Override
    public void mirrorY() {
        this.x = -this.x;
    }

    @Override
    public void move(int dx, int dy) {
        this.x = this.x + dx;
        this.y = this.y + dy;
    }
}

public abstract class Shape implements Mirrorable, Movable {
    abstract void print();

    // public static void main(String[] args) {
    // Polygon segiEmpat = new Polygon();
    // segiEmpat.addPoint(new Point(0, 0));
    // segiEmpat.addPoint(new Point(1, 1));
    // segiEmpat.addPoint(new Point(2, 1));
    // segiEmpat.addPoint(new Point(2, 0));
    // System.out.println("Original / Initial Polygon");
    // segiEmpat.print();
    // System.out.println("\nMirroring X on Polygon");
    // segiEmpat.mirrorX();
    // segiEmpat.print();
    // System.out.println("\nMirroring Y on Polygon");
    // segiEmpat.mirrorY();
    // segiEmpat.print();
    // System.out.println("\nMove(1, 3) on Polygon");
    // segiEmpat.move(1, 3);
    // segiEmpat.print();

    // Ellipse ellipse = new Ellipse(new Point(5, 5), 10.4, 5.4);
    // System.out.println("\nOriginal / Initial Ellipse");
    // ellipse.print();
    // System.out.println("\nMirroring X on Ellipse");
    // ellipse.mirrorX();
    // ellipse.print();
    // System.out.println("\nMirroring Y on Ellipse");
    // ellipse.mirrorY();
    // ellipse.print();
    // System.out.println("\nMove(1, 3) on Ellipse");
    // ellipse.move(1, 3);
    // ellipse.print();

    // Triangle segiTigaSiku = new Triangle(new Point(4, 4), new Point(4, 6), new
    // Point(6, 4));
    // Triangle segiTiga = new Triangle(new Point(5, 5), new Point(6, 6), new
    // Point(5, 10));

    // System.out.println();
    // segiTiga.print();
    // System.out.println();
    // segiTigaSiku.print();
    // }
}

class Polygon extends Shape {
    protected Point[] points;
    protected int sizeShape;

    public Polygon() {
        this.points = new Point[100];
        this.sizeShape = 0;
    }

    public Point[] getPoints() {
        return points;
    }

    public void setPoint(int i, Point P) {
        this.points[i] = P;
    }

    public void addPoint(Point P) {
        this.points[this.sizeShape] = P;
        this.sizeShape++;
    }

    @Override
    public void mirrorX() {
        for (int i = 0; i < sizeShape; i++) {
            points[i].mirrorX();
        }
    }

    @Override
    public void mirrorY() {
        for (int i = 0; i < sizeShape; i++) {
            points[i].mirrorY();
        }
    }

    @Override
    public void move(int dx, int dy) {
        for (int i = 0; i < sizeShape; i++) {
            points[i].move(dx, dy);
        }
    }

    @Override
    void print() {
        System.out.println("Polygon");
        for (int i = 0; i < sizeShape; i++) {
            System.out.println("(" + points[i].getX() + "," + points[i].getY() + ")");
        }
    }
}

class Ellipse extends Shape {
    private Point pusat;
    private double majorRadius;
    private double minorRadius;

    public Ellipse(Point pusat, double majorRadius, double minorRadius) {
        this.pusat = pusat;
        this.minorRadius = minorRadius;
        this.majorRadius = majorRadius;
    }

    public void setPusat(Point pusat) {
        this.pusat = pusat;
    }

    public void setMajorRadius(double majorRadius) {
        this.majorRadius = majorRadius;
    }

    public void setMinorRadius(double minorRadius) {
        this.minorRadius = minorRadius;
    }

    public Point getPusat() {
        return pusat;
    }

    public double getMajorRadius() {
        return majorRadius;
    }

    public double getMinorRadius() {
        return minorRadius;
    }

    @Override
    public void mirrorX() {
        pusat.mirrorX();
    }

    @Override
    public void mirrorY() {
        pusat.mirrorY();
    }

    @Override
    public void move(int dx, int dy) {
        pusat.move(dx, dy);
    }

    @Override
    void print() {
        System.out.println("Ellipse");
        System.out.println("Pusat\t\t: " + "(" + pusat.getX() + "," + pusat.getY() + ")");
        System.out.println("Major radius\t: " + String.format("%.1f", majorRadius));
        System.out.println("Minor radius\t: " + String.format("%.1f", minorRadius));
    }
}

class Triangle extends Polygon {
    public Triangle(Point P1, Point P2, Point P3) {
        super();
        this.addPoint(P1);
        this.addPoint(P2);
        this.addPoint(P3);
    }

    @Override
    void print() {
        Point P1 = points[0];
        Point P2 = points[1];
        Point P3 = points[2];

        if ((P1.getX() == P2.getX()) && (P1.getY() == P3.getY())) {
            System.out.println("Segitiga Siku-Siku");
        } else {
            System.out.println("Segitiga");
        }

        for (int i = 0; i < sizeShape; i++) {
            System.out.println("(" + points[i].getX() + "," + points[i].getY() + ")");
        }
    }
}