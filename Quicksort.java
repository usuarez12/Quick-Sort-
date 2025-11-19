import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Quicksort {


    public static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int p = partition(a, low, high);
            quickSort(a, low, p - 1);
            quickSort(a, p + 1, high);
        }
    }

    private static int partition(int[] a, int low, int high) {
        // Usamos pivote 
        int mid = low + (high - low) / 2;
        int pivot = a[mid];
        int i = low, j = high;
        while (i <= j) {
            while (a[i] < pivot) i++;
            while (a[j] > pivot) j--;
            if (i <= j) {
                swap(a, i, j);
                i++; j--;
            }
        }
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    // --- Lectura desde archivo ---
  
    public static int[] readIntegersFromFile(String filename) throws IOException {
        List<Integer> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] parts = line.split("\\s+");
                for (String p : parts) {
                    list.add(Integer.parseInt(p));
                }
            }
        }
        // convertir List<Integer> a int[]
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }

    // --- Escritura a archivo ---
    public static void writeIntegersToFile(String filename, int[] arr) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < arr.length; i++) {
                bw.write(String.valueOf(arr[i]));
                if (i < arr.length - 1) bw.write(" "); // separar con espacio
            }
            bw.newLine();
        }
    }

    // 0rograma principal
    
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java QuickSortFile <archivo_entrada> <archivo_salida>");
            System.out.println("Ejemplo: java QuickSortFile datos.txt ordenados.txt");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];

        try {
            int[] arr = readIntegersFromFile(inputFile);
            if (arr.length == 0) {
                System.out.println("El archivo de entrada no contiene números.");
                writeIntegersToFile(outputFile, arr); // escribir vacío
                return;
            }

            quickSort(arr, 0, arr.length - 1);

            writeIntegersToFile(outputFile, arr);
            System.out.println("Ordenamiento completado. Resultado escrito en: " + outputFile);
        } catch (NumberFormatException nfe) {
            System.err.println("Error: el archivo contiene texto que no es un entero válido.");
        } catch (FileNotFoundException fnfe) {
            System.err.println("Archivo no encontrado: " + inputFile);
        } catch (IOException ioe) {
            System.err.println("Error leyendo/escribiendo archivos: " + ioe.getMessage());
        }
    }
}
