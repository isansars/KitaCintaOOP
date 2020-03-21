public class Point {
    private int x, y; // absis dan ordinat

    // Constructor
    // Set titik mula-mula ke (0, 0)
    public Point();

    // Set titik mula-mula ke (x, y)
    public Point(int x, int y);

    // Getter
    public int getAbsis();
    public int getOrdinat();

    // Setter
    public void setAbsis(int x);
    public void setOrdinat(int y);

    // Menghasilkan true jika titik (x, y) berada di (0, 0)
    public boolean isOrigin();

    // Menghasilkan true jika titik pada argumen sama dengan dirinya
    public boolean isEqual(Point p);

    // Mengubah titik dengan penambahan Point argumen
    public void translate(Point p);

    // Mentranslasikan titik sebesar (x, y)
    public void translate(int x, int y);

    // Menghasilkan nomor kuadran dari titik sekarang
    // Sebuah titik yang berada pada sumbu x atau y tidak akan dicoba
    public int kuadran();

    // Menghasilkan jarak antara titik sekarang dengan Point argumen
    public double distance(Point p);

    // Menuliskan titik ke layar dengan format "(x,y)"
    public void print();
}