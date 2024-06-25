import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String namaFile = "./src/trapezoid.txt";
        List<Trapezoid> trapezoid = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(namaFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Trapezoid t = new Trapezoid(data[0], data[1], data[2]);
                trapezoid.add(t);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(trapezoid);

        for (int i = 0; i < trapezoid.size() - 1; i++) {
            for (int j = 0; j < trapezoid.size() - 1; j++) {
                double keliling1 = trapezoid.get(i).keliling();
                double keliling2 = trapezoid.get(j).keliling();
                if (keliling1 < keliling2) {
                    Trapezoid temp = trapezoid.get(i);
                    trapezoid.set(i, trapezoid.get(j));
                    trapezoid.set(j, temp);
                }
            }
        }
        System.out.println("Keliling dari terkecil ke terbesar: ");
        for (int i = 0; i < trapezoid.size(); i++) {
            Trapezoid trapesium = trapezoid.get(i);
            System.out.print(trapesium.keliling() + ", ");
            if (i < trapezoid.size() - 1) {
                System.out.print(" ");
            }
        }
        String namaFileB = "./src/sorting.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(namaFileB))) {
            for (Trapezoid trapesium : trapezoid) {
                bw.write(String.valueOf(trapesium.keliling()));
                bw.newLine();
            }
            System.out.println("\nKeliling yang sudah terurut disimpan ke: " + namaFileB);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}