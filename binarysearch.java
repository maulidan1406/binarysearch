import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Kamus {
    private static Map<String, String> indoToEng = new HashMap<>();
    private static Map<String, String> engToIndo = new HashMap<>();

    public static void main(String[] args) {
        // Menambahkan data ke kamus
        indoToEng.put("apel", "apple");
        indoToEng.put("pisang", "banana");
        indoToEng.put("kucing", "cat");
        indoToEng.put("anjing", "dog");
        indoToEng.put("gajah", "elephant");

        // Membuat kamus Inggris-Indonesia dengan menukar key dan value dari kamus Indonesia-Inggris
        engToIndo = reverseMap(indoToEng);

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Kamus Indonesia-Inggris & Inggris-Indonesia ===");

        while (true) {
            System.out.println("Pilih opsi:");
            System.out.println("1. Terjemahkan dari Indonesia ke Inggris");
            System.out.println("2. Terjemahkan dari Inggris ke Indonesia");
            System.out.println("3. Keluar");

            System.out.print("Masukkan pilihan: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    translateIndoToEng(scanner);
                    break;
                case 2:
                    translateEngToIndo(scanner);
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan kamus.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }

            System.out.println();
        }
    }

    private static void translateIndoToEng(Scanner scanner) {
        System.out.print("Masukkan kata dalam Bahasa Indonesia: ");
        String word = scanner.nextLine();

        String translation = indoToEng.get(word);
        if (translation != null) {
            System.out.println("Terjemahan: " + translation);
        } else {
            System.out.println("Kata tidak ditemukan dalam kamus.");
        }
    }

    private static void translateEngToIndo(Scanner scanner) {
        System.out.print("Enter a word in English: ");
        String word = scanner.nextLine();

        String translation = engToIndo.get(word);
        if (translation != null) {
            System.out.println("Terjemahan: " + translation);
        } else {
            System.out.println("Kata tidak ditemukan dalam kamus.");
        }
    }

    private static <K, V> Map<V, K> reverseMap(Map<K, V> map) {
        Map<V, K> reversedMap = new HashMap<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            reversedMap.put(entry.getValue(), entry.getKey());
        }
        return reversedMap;
    }
}
