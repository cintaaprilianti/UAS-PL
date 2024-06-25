public class Trapezoid {
    double sisiA;
    double sisiB;
    double tinggi;
    public Trapezoid (String sisiA, String sisiB, String tinggi) {
        this.sisiA = Double.parseDouble(sisiA);
        this.sisiB = Double.parseDouble(sisiB);
        this.tinggi = Double.parseDouble(tinggi);
    }
    public double luas() {
        return 0.5 * (sisiA + sisiB) * tinggi;
    }
    public double keliling() {
        double sisiMiring = Math.sqrt(Math.pow(tinggi, 2) + Math.pow((sisiA - sisiB) / 2, 2 ));
        double keliling = sisiA + sisiB + 2 * sisiMiring;
        return keliling;
    }
    public void printLuas(String satuan) {
        System.out.println(luas() + satuan);
    }
    public String toString() {
        return "Luas: " + luas() + ", Keliling: " + keliling();
    }
}
