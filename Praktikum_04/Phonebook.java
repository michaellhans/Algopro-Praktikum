//Byan Sakura
import java.util.*;

public class Phonebook {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Map<String, String> map = new HashMap<>();
            int n = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < n; ++i) {
                String nama = scanner.nextLine();
                String nomor = scanner.nextLine();
                map.put(nama, nomor);
            }
            for (int i = 0; i < n; ++i) {
                String nama = scanner.nextLine();
                String nomor = map.get(nama);
                if (nomor == null) {
                    System.out.println("Not found");
                    System.out.flush();
                } else {
                    System.out.println(nama + "=" + nomor);
                    System.out.flush();
                }
            }
        }
    }
}
