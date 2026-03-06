import java.util.Objects;
import java.util.Scanner;

class Array {
    private int[] array;
    int size;
    int premiki;
    int primerjave;

    public Array() {
        array = new int[10];
        size = 0;
    }
    public int getPremiki() {
        return premiki;

    }
    public int getPrimerjave() {
        return  primerjave;
    }
    public void add(int x) {
        if (size == array.length) {
            resize();
        }
        array[size++] = x;

    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int x) {
        array[i] = x;


    }

    public int size() {
        return size;
    }

    private void resize() {
        int[] b = new int[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            b[i] = array[i];
        }
        array = b;
    }

    public int[] toArray() {
        int[] r = new int[size];
        for (int i = 0; i < size; i++) r[i] = array[i];
        return r;
    }


}




public class Main {
    private static boolean isBucket=false;
    public static void main(String[] args) {
        Scanner vh = new Scanner(System.in);
        String nacinIzpisa = "";
        String vrstaUrejanja = "";
        String vrstaIzpisa = "";
        String ukazi = vh.nextLine();
        String tabela = vh.nextLine();
        Array arr = napolniTabelo(tabela);
        Scanner vh1 = new Scanner(ukazi);
        nacinIzpisa = vh1.next();
        vrstaUrejanja = vh1.next();
        vrstaIzpisa = vh1.next();

        switch (vrstaUrejanja) {
            case "insert":
                if (nacinIzpisa.equals("trace")) {
                    isBucket=false;
                    insertionSort(nacinIzpisa, vrstaIzpisa, arr);

                } else if (nacinIzpisa.equals("count")) {
                    isBucket=false;
                    insertionCount(nacinIzpisa, vrstaIzpisa, arr);
                }
                break;
            case "select":
                if (nacinIzpisa.equals("trace")) {
                    selectionSort(nacinIzpisa, vrstaIzpisa, arr);
                } else if (nacinIzpisa.equals("count")) {
                    selectionCount(nacinIzpisa, vrstaIzpisa, arr);
                }
                break;
            case "bubble":
                if (nacinIzpisa.equals("trace")) {
                    bubbleSort(nacinIzpisa, vrstaIzpisa, arr);
                } else if (nacinIzpisa.equals("count")) {
                    countBubbleSort(nacinIzpisa, vrstaIzpisa, arr);
                }
                break;
            case "heap":
                if (nacinIzpisa.equals("trace")) {
                    heapSort(nacinIzpisa, vrstaIzpisa, arr);
                } else if (nacinIzpisa.equals("count")) {
                    countHeapSort(nacinIzpisa, vrstaIzpisa, arr);
                }
                break;
            case "merge":
                if (nacinIzpisa.equals("trace")) {
                    mergeSort(nacinIzpisa, vrstaIzpisa, arr);
                } else if (nacinIzpisa.equals("count")) {
                    mergeCount(nacinIzpisa, vrstaIzpisa, arr);
                }
                break;
            case "quick":
                if (nacinIzpisa.equals("trace")) {
                    quickSort(nacinIzpisa, vrstaIzpisa, arr);
                } else if (nacinIzpisa.equals("count")) {
                    quickCount(nacinIzpisa, vrstaIzpisa, arr);
                }
                break;
            case "radix":
                if (nacinIzpisa.equals("trace")) {
                    radixSort(nacinIzpisa, vrstaIzpisa, arr);
                } else if (nacinIzpisa.equals("count")) {
                    radixCount(nacinIzpisa, vrstaIzpisa, arr);
                }
                break;
            case "bucket":
                if (nacinIzpisa.equals("trace")) {
                    isBucket=true;
                    bucketSort(nacinIzpisa, vrstaIzpisa, arr);
                } else if (nacinIzpisa.equals("count")) {
                    isBucket=true;
                    countBucket(nacinIzpisa, vrstaIzpisa, arr);
                }
                break;

        }

    }

    public static Array napolniTabelo(String tabela) {
        Scanner vh = new Scanner(tabela);
        Array arr = new Array();
        while (vh.hasNext()) {
            String niz = vh.next();
            if (isNumeric(niz)) {
                arr.add(Integer.parseInt(niz));
            }


        }
        return arr;


    }

    public static boolean isNumeric(String s) {
        try {
            int n = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }


    }

    public static void insertionSort(String nacin, String izpis, Array arr) {
        if (izpis.equals("up")) {
            if (nacin.equals("trace") && !isBucket) printNormalSort(-1, arr, nacin);
            for (int i = 1; i < arr.size(); i++) {
                int k = arr.get(i);
                arr.premiki++;
                int j = i;
                while (j > 0) {
                    arr.primerjave++;
                    if (arr.get(j - 1) > k) {
                        arr.set(j, arr.get(j - 1));
                        arr.premiki++;
                        j--;
                    } else break;
                }
                arr.set(j, k);
                arr.premiki++;
                if (nacin.equals("trace")) printNormalSort(i, arr, nacin);
            }


        } else if (izpis.equals("down")) {
            if (nacin.equals("trace") && !isBucket ) printNormalSort(-1, arr, nacin);
            for (int i = 1; i < arr.size(); i++) {
                int k = arr.get(i);
                arr.premiki++;
                int j = i;
                while (j > 0) {
                    arr.primerjave++;
                    if (arr.get(j - 1) < k) {
                        arr.set(j, arr.get(j - 1));
                        arr.premiki++;
                        j--;
                    } else break;
                }
                arr.set(j, k);
                arr.premiki++;
                if (nacin.equals("trace")) printNormalSort(i, arr, nacin);
            }


        }
    }

    public static void insertionCount(String nacin, String izpis, Array arr) {

        if (izpis.equals("up")) {
            arr.primerjave = 0;
            arr.premiki = 0;
            insertionSort(nacin, "up", arr);
            printNormalSort(1, arr, nacin);
            arr.primerjave = 0;
            arr.premiki = 0;
            insertionSort(nacin, "up", arr);
            printNormalSort(1, arr, nacin);
            arr.primerjave = 0;
            arr.premiki = 0;
            insertionSort(nacin, "down", arr);
            printNormalSort(0, arr, nacin);
            System.out.println();

        } else if (izpis.equals("down")) {
            arr.primerjave = 0;
            arr.premiki = 0;
            insertionSort(nacin, "down", arr);
            printNormalSort(1, arr, nacin);
            arr.primerjave = 0;
            arr.premiki = 0;
            insertionSort(nacin, "down", arr);
            printNormalSort(1, arr, nacin);
            arr.primerjave = 0;
            arr.premiki = 0;
            insertionSort(nacin, "up", arr);
            printNormalSort(0, arr, nacin);
            System.out.println();

        }


    }

    public static void printNormalSort(int i, Array arr, String nacin) {
        int[] r = arr.toArray();
        if (nacin.equals("trace")) {

            if (i == -1) {
                for (int j = 0; j < r.length; j++) {
                    System.out.print(r[j] + " ");

                }
                System.out.println();

            } else {

                for (int j = 0; j < r.length; j++) {
                    System.out.print(r[j] + " ");
                    if (j == i) System.out.print("| ");

                }
                System.out.println();
            }


        } else if (nacin.equals("count")) {
            System.out.printf("%d %d", arr.premiki, arr.primerjave);

            if (i == 1) {
                System.out.print(" | ");
            } else {
                System.out.print(" ");
            }

        }


    }

    public static void selectionSort(String nacin, String izpis, Array arr) {

        if (izpis.equals("up")) {
            if (nacin.equals("trace")) printNormalSort(-1, arr, nacin);
            for (int i = 0; i < arr.size() - 1; i++) {
                int min = i;
                for (int j = i + 1; j < arr.size(); j++) {
                    arr.primerjave++;
                    if (arr.get(j) < arr.get(min)) {

                        min = j;

                    }


                }
                int temp = arr.get(i);
                arr.set(i, arr.get(min));
                arr.set(min, temp);
                arr.premiki += 3;
                if (nacin.equals("trace")) printNormalSort(i, arr, nacin);


            }
        } else if (izpis.equals("down")) {
            if (nacin.equals("trace")) printNormalSort(-1, arr, nacin);
            for (int i = 0; i < arr.size() - 1; i++) {
                int max = i;
                for (int j = i + 1; j < arr.size(); j++) {
                    arr.primerjave++;
                    if (arr.get(j) > arr.get(max)) {
                        max = j;

                    }


                }
                int temp = arr.get(i);
                arr.set(i, arr.get(max));
                arr.set(max, temp);
                arr.premiki += 3;
                if (nacin.equals("trace")) printNormalSort(i, arr, nacin);


            }

        }


    }

    public static void selectionCount(String nacin, String izpis, Array arr) {
        if (izpis.equals("up")) {
            arr.primerjave = 0;
            arr.premiki = 0;
            selectionSort(nacin, "up", arr);
            printNormalSort(1, arr, nacin);
            arr.primerjave = 0;
            arr.premiki = 0;
            selectionSort(nacin, "up", arr);
            printNormalSort(1, arr, nacin);
            arr.primerjave = 0;
            arr.premiki = 0;
            selectionSort(nacin, "down", arr);
            printNormalSort(0, arr, nacin);
            System.out.println();


        } else if (izpis.equals("down")) {
            arr.primerjave = 0;
            arr.premiki = 0;
            selectionSort(nacin, "down", arr);
            printNormalSort(1, arr, nacin);
            arr.primerjave = 0;
            arr.premiki = 0;
            selectionSort(nacin, "down", arr);
            printNormalSort(1, arr, nacin);
            arr.primerjave = 0;
            arr.premiki = 0;
            selectionSort(nacin, "up", arr);
            printNormalSort(0, arr, nacin);
            System.out.println();


        }

    }

    public static void bubbleSort(String nacin, String izpis, Array arr) {
        if (izpis.equals("up")) {

            if (nacin.equals("trace")) printNormalSort(-1, arr, nacin);

            int n = arr.size();
            boolean swapped = false;
            int lastSwap = 0;
            int lastSwapT = 0;
            for (int i = 0; i < n - 1; i++) {
                swapped = false;
                lastSwap = lastSwapT;

                for (int j = n - 1; j > lastSwap; j--) {
                    arr.primerjave++;
                    if (arr.get(j) < arr.get(j - 1)) {
                        int tmp = arr.get(j);
                        arr.set(j, arr.get(j - 1));
                        arr.set(j - 1, tmp);
                        arr.premiki += 3;
                        swapped = true;
                        lastSwapT = j;
                    }
                }
                if (swapped) {
                    if (nacin.equals("trace")) printNormalSort(lastSwapT - 1, arr, nacin);
                } else {
                    if (lastSwapT != arr.size - 1 && nacin.equals("trace")) {
                        printNormalSort(arr.size - 2, arr, nacin);

                    }
                    break;
                }


            }


        } else if (izpis.equals("down")) {
            if (nacin.equals("trace")) printNormalSort(-1, arr, nacin);

            int n = arr.size();
            boolean swapped = false;
            int lastSwap = 0;
            int lastSwapT = 0;
            for (int i = 0; i < n - 1; i++) {
                swapped = false;
                lastSwap = lastSwapT;

                for (int j = n - 1; j > lastSwap; j--) {
                    arr.primerjave++;
                    if (arr.get(j) > arr.get(j - 1)) {
                        int tmp = arr.get(j);
                        arr.set(j, arr.get(j - 1));
                        arr.set(j - 1, tmp);
                        arr.premiki += 3;
                        swapped = true;
                        lastSwapT = j;
                    }
                }

                if (swapped) {
                    if (nacin.equals("trace")) printNormalSort(lastSwapT - 1, arr, nacin);
                } else {
                    if (lastSwapT != arr.size - 1 && nacin.equals("trace")) {
                        printNormalSort(arr.size - 2, arr, nacin);

                    }
                    break;
                }
            }
        }
    }


    public static void countBubbleSort(String nacin, String izpis, Array arr) {
        if (izpis.equals("up")) {
            arr.primerjave = 0;
            arr.premiki = 0;
            bubbleSort(nacin, "up", arr);
            printNormalSort(1, arr, nacin);
            arr.primerjave = 0;
            arr.premiki = 0;
            bubbleSort(nacin, "up", arr);
            printNormalSort(1, arr, nacin);
            arr.primerjave = 0;
            arr.premiki = 0;
            bubbleSort(nacin, "down", arr);
            printNormalSort(0, arr, nacin);
            System.out.println();


        } else if (izpis.equals("down")) {
            arr.primerjave = 0;
            arr.premiki = 0;
            bubbleSort(nacin, "down", arr);
            printNormalSort(1, arr, nacin);
            arr.primerjave = 0;
            arr.premiki = 0;
            bubbleSort(nacin, "down", arr);
            printNormalSort(1, arr, nacin);
            arr.primerjave = 0;
            arr.premiki = 0;
            bubbleSort(nacin, "up", arr);
            printNormalSort(0, arr, nacin);
            System.out.println();


        }

    }

    public static void heapSort(String nacin, String izpis, Array arr) {
        if (nacin.equals("trace")) printNormalSort(-1, arr, nacin);
        int n = arr.size();
        for (int i = n / 2 - 1; i >= 0; i--) {
            zgradi(arr, n, i, izpis);
        }
        if (nacin.equals("trace")) printNormalSort(arr.size - 1, arr, nacin);
        for (int i = n - 1; i > 0; i--) {

            int tmp = arr.get(0);
            arr.set(0, arr.get(i));
            arr.set(i, tmp);
            arr.premiki += 3;

            zgradi(arr, i, 0, izpis);
            if (nacin.equals("trace")) printNormalSort(i - 1, arr, nacin);
        }
    }


    public static void zgradi(Array arr, int n, int i, String izpis) {
        int extrem = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (izpis.equals("up")) {

            if (left < n) {
                arr.primerjave++;
                if (arr.get(left) > arr.get(extrem)) extrem = left;
            }

            if (right < n) {
                arr.primerjave++;
                if (arr.get(right) > arr.get(extrem)) extrem = right;
            }
        } else if (izpis.equals("down")) {

            if (left < n) {
                arr.primerjave++;
                if (arr.get(left) < arr.get(extrem)) extrem = left;
            }

            if (right < n) {
                arr.primerjave++;
                if (arr.get(right) < arr.get(extrem)) extrem = right;
            }
        }
        if (extrem != i) {
            int tmp = arr.get(i);
            arr.set(i, arr.get(extrem));
            arr.set(extrem, tmp);
            arr.premiki += 3;

            zgradi(arr, n, extrem, izpis);
        }
    }

    public static void countHeapSort(String nacin, String izpis, Array arr) {
        if (izpis.equals("up")) {
            arr.primerjave = 0;
            arr.premiki = 0;
            heapSort(nacin, "up", arr);
            printNormalSort(1, arr, nacin);
            arr.primerjave = 0;
            arr.premiki = 0;
            heapSort(nacin, "up", arr);
            printNormalSort(1, arr, nacin);
            arr.primerjave = 0;
            arr.premiki = 0;
            heapSort(nacin, "down", arr);
            printNormalSort(0, arr, nacin);
            System.out.println();


        } else if (izpis.equals("down")) {
            arr.primerjave = 0;
            arr.premiki = 0;
            heapSort(nacin, "down", arr);
            printNormalSort(1, arr, nacin);
            arr.primerjave = 0;
            arr.premiki = 0;
            heapSort(nacin, "down", arr);
            printNormalSort(1, arr, nacin);
            arr.primerjave = 0;
            arr.premiki = 0;
            heapSort(nacin, "up", arr);
            printNormalSort(0, arr, nacin);
            System.out.println();


        }


    }

    public static void mergeSort(String nacin, String izpis, Array arr) {
        if (izpis.equals("up")) {
            if (nacin.equals("trace")) printNormalSort(-1, arr, nacin);
            mergeSortRec(arr, 0, arr.size() - 1, true, nacin);
        } else if (izpis.equals("down")) {
            if (nacin.equals("trace")) printNormalSort(-1, arr, nacin);
            mergeSortRec(arr, 0, arr.size() - 1, false, nacin);
        }
    }

    private static void mergeSortRec(Array arr, int l, int r, boolean up, String nacin) {
        if (l < r) {
            int m = (l + r) / 2;
            if (nacin.equals("trace")) {
                printMergeSort(l, m, r, arr, true);
            }
            mergeSortRec(arr, l, m, up, nacin);
            mergeSortRec(arr, m + 1, r, up, nacin);
            merge(arr, l, m, r, up, nacin);
            if (nacin.equals("trace")) {

                printMergeSort(l, m, r, arr, false);

            }
        }
    }

    private static void merge(Array arr, int l, int m, int r, boolean up, String nacin) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = arr.get(l + i);
            arr.premiki++;
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr.get(m + 1 + j);
            arr.premiki++;
        }
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            arr.primerjave++;
            if ((up && L[i] <= R[j]) || (!up && L[i] >= R[j])) {
                arr.set(k, L[i]);
                arr.premiki++;
                i++;
            } else {
                arr.set(k, R[j]);
                arr.premiki++;
                j++;
            }
            k++;

        }
        while (i < n1) {
            arr.set(k, L[i]);
            arr.premiki++;
            i++;
            k++;
        }
        while (j < n2) {
            arr.set(k, R[j]);
            arr.premiki++;
            j++;
            k++;
        }
    }

    public static void printMergeSort(int l, int m, int r, Array arr, boolean withBorder) {
        int[] tab = arr.toArray();
        for (int i = l; i <= r; i++) {
            System.out.print(tab[i] + " ");
            if (withBorder && i == m) System.out.print("| ");
        }
        System.out.println();
    }

    public static void mergeCount(String nacin, String izpis, Array arr) {
        if (izpis.equals("up")) {
            arr.primerjave = 0;
            arr.premiki = 0;
            mergeSort(nacin, "up", arr);
            printNormalSort(1, arr, nacin);
            arr.primerjave = 0;
            arr.premiki = 0;
            mergeSort(nacin, "up", arr);
            printNormalSort(1, arr, nacin);
            arr.primerjave = 0;
            arr.premiki = 0;
            mergeSort(nacin, "down", arr);
            printNormalSort(0, arr, nacin);
            System.out.println();
        } else if (izpis.equals("down")) {
            arr.primerjave = 0;
            arr.premiki = 0;
            mergeSort(nacin, "down", arr);
            printNormalSort(1, arr, nacin);
            arr.primerjave = 0;
            arr.premiki = 0;
            mergeSort(nacin, "down", arr);
            printNormalSort(1, arr, nacin);
            arr.primerjave = 0;
            arr.premiki = 0;
            mergeSort(nacin, "up", arr);
            printNormalSort(0, arr, nacin);
            System.out.println();
        }
    }

    public static void quickSort(String nacin, String izpis, Array arr) {
        if (nacin.equals("trace")) {
            printNormalSort(-1, arr, nacin);
        }
        if (izpis.equals("up")) {
            quickSortRec(arr, 0, arr.size() - 1, true, nacin);
            if (nacin.equals("trace")) {
                printNormalSort(-1, arr, nacin);
            }
        } else {
            quickSortRec(arr, 0, arr.size() - 1, false, nacin);
            if (nacin.equals("trace")) {
                printNormalSort(-1, arr, nacin);
            }
        }
    }

    private static void quickSortRec(Array arr, int l, int r, boolean up, String nacin) {
        if (l < r) {
            int pivotIndex = partition(arr, l, r, up);
            if (nacin.equals("trace")) {
                printQuickSort(l, r, pivotIndex, arr);
            }
            quickSortRec(arr, l, pivotIndex - 1, up, nacin);
            quickSortRec(arr, pivotIndex + 1, r, up, nacin);

        }
    }

    private static int partition(Array arr, int left, int right, boolean up) {
        int pivot = arr.get(left);
        arr.premiki++;
        int l = left;
        int r = right + 1;
        while (true) {
            if (up) {
                while (true) {
                    l++;
                    if (l > right) break;
                    arr.primerjave++;
                    if (arr.get(l) >= pivot) break;
                }
                while (true) {
                    r--;
                    arr.primerjave++;
                    if (arr.get(r) <= pivot) break;
                }
            } else {
                while (true) {
                    l++;
                    if (l > right) break;
                    arr.primerjave++;
                    if (arr.get(l) <= pivot) break;
                }while (true) {
                    r--;
                    arr.primerjave++;
                    if (arr.get(r) >= pivot) break;
                }
            }


            if (l >= r) break;
            int tmp = arr.get(l);
            arr.set(l, arr.get(r));
            arr.set(r, tmp);
            arr.premiki += 3;



        }
        int tmp = arr.get(left);
        arr.set(left, arr.get(r));
        arr.set(r, tmp);
        arr.premiki += 3;
        return r;
    }


    public static void quickCount(String nacin, String izpis, Array arr) {
        if (izpis.equals("up")) {
            arr.primerjave = 0;
            arr.premiki = 0;
            quickSort(nacin, "up", arr);
            printNormalSort(1, arr, nacin);
            arr.primerjave = 0;
            arr.premiki = 0;
            quickSort(nacin, "up", arr);
            printNormalSort(1, arr, nacin);
            arr.primerjave = 0;
            arr.premiki = 0;
            quickSort(nacin, "down", arr);
            printNormalSort(0, arr, nacin);
            System.out.println();
        } else if (izpis.equals("down")) {
            arr.primerjave = 0;
            arr.premiki = 0;
            quickSort(nacin, "down", arr);
            printNormalSort(1, arr, nacin);
            arr.primerjave = 0;
            arr.premiki = 0;
            quickSort(nacin, "down", arr);
            printNormalSort(1, arr, nacin);
            arr.primerjave = 0;
            arr.premiki = 0;
            quickSort(nacin, "up", arr);
            printNormalSort(0, arr, nacin);
            System.out.println();
        }
    }
    public static void printQuickSort(int l, int r, int pivot, Array arr) {
        int[] tab = arr.toArray();
        for (int i = l; i <= r; i++) {
            if (i == pivot) System.out.print("| ");
            System.out.print(tab[i] + " ");
            if (i == pivot) System.out.print("| ");
        }
        System.out.println();
    }
    public static void radixSort(String nacin, String izpis, Array arr) {
        if (nacin.equals("trace")) {
            printNormalSort(-1, arr, nacin);
        }
        int max = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > max) max = arr.get(i);
        }
        int exp = 1;
        Array output = new Array();
        for (int i = 0; i < arr.size(); i++) output.add(0);
        while (max / exp > 0) {
            int[] count = new int[10];
            for (int i = 0; i < arr.size(); i++) {
                arr.primerjave++;
                int digit = (arr.get(i) / exp) % 10;
                count[digit]++;
            }
            if (izpis.equals("up")) {
                for (int i = 1; i < 10; i++) {
                    count[i] += count[i - 1];
                }
            } else {
                for (int i = 8; i >= 0; i--) {
                    count[i] += count[i + 1];
                }
            }
            for (int i = arr.size() - 1; i >= 0; i--) {
                arr.primerjave++;
                int digit = (arr.get(i) / exp) % 10;
                output.set(count[digit] - 1, arr.get(i));
                count[digit]--;
                arr.premiki++;
            }
            for (int i = 0; i < arr.size(); i++) {
                arr.set(i, output.get(i));
                arr.premiki++;
            }
            if (nacin.equals("trace")) printNormalSort(-1, arr, nacin);
            exp *= 10;
        }
    }

    public static void radixCount(String nacin, String izpis, Array arr) {
        if (izpis.equals("up")) {
            arr.primerjave = 0;
            arr.premiki = 0;
            radixSort(nacin, "up", arr);
            printNormalSort(1, arr, nacin);
            arr.primerjave = 0;
            arr.premiki = 0;
            radixSort(nacin, "up", arr);
            printNormalSort(1, arr, nacin);
            arr.primerjave = 0;
            arr.premiki = 0;
            radixSort(nacin, "down", arr);
            printNormalSort(0, arr, nacin);
            System.out.println();
        } else if (izpis.equals("down")) {
            arr.primerjave = 0;
            arr.premiki = 0;
            radixSort(nacin, "down", arr);
            printNormalSort(1, arr, nacin);
            arr.primerjave = 0;
            arr.premiki = 0;
            radixSort(nacin, "down", arr);
            printNormalSort(1, arr, nacin);
            arr.primerjave = 0;
            arr.premiki = 0;
            radixSort(nacin, "up", arr);
            printNormalSort(0, arr, nacin);
            System.out.println();
        }
    }
    public static void bucketSort(String nacin, String izpis, Array arr) {
        if (nacin.equals("trace")) printNormalSort(-1, arr, nacin);
        int n = arr.size();
        if (n <= 1) return;
        int min = arr.get(0);
        int max = arr.get(0);
        for (int i = 0; i < n; i++) {
            arr.primerjave++;
            if (arr.get(i) < min) min = arr.get(i);
            arr.primerjave++;
            if (arr.get(i) > max) max = arr.get(i);
        }
        int k = n / 2;
        if (k == 0) k = 1;
        double v = (double)(max - min + 1) / k;
        Array[] buckets = new Array[k];
        for (int i = 0; i < k; i++){
            buckets[i] = new Array();
        }
        for (int i = 0; i < n; i++) {
            int idx = (int)((arr.get(i) - min) / v);
            arr.primerjave++;
            if (idx >= k) idx = k - 1;

            buckets[idx].add(arr.get(i));
            arr.premiki++;
        }
        if (nacin.equals("trace")) {
            if (izpis.equals("up")) {
                for (int i = 0; i < k; i++) {
                    for (int j = 0; j < buckets[i].size(); j++)
                        System.out.print(buckets[i].get(j) + " ");
                    if (i < k - 1) System.out.print("| ");
                }
            } else {
                for (int i = k - 1; i >= 0; i--) {
                    for (int j = 0; j < buckets[i].size(); j++)
                        System.out.print(buckets[i].get(j) + " ");
                    if (i > 0) System.out.print("| ");
                }
            }
            System.out.println();
        }
        int pos = 0;
        if(izpis.equals("up")) {
            for (int i = 0; i < k; i++)
                for (int j = 0; j < buckets[i].size(); j++) {
                    arr.set(pos++, buckets[i].get(j));
                    arr.premiki++;
                }
        }else{
            for (int i = k - 1; i >= 0; i--)
                for (int j = 0; j < buckets[i].size(); j++) {
                    arr.set(pos++, buckets[i].get(j));
                    arr.premiki++;}
        }

        insertionSort(nacin, izpis, arr);
    }
    public static void countBucket(String nacin, String izpis, Array arr){
        if (izpis.equals("up")) {
            arr.primerjave = 0;
            arr.premiki = 0;
            bucketSort(nacin, "up", arr);
            printNormalSort(1, arr, nacin);
            arr.primerjave = 0;
            arr.premiki = 0;
            bucketSort(nacin, "up", arr);
            printNormalSort(1, arr, nacin);
            arr.primerjave = 0;
            arr.premiki = 0;
            bucketSort(nacin, "down", arr);
            printNormalSort(0, arr, nacin);
            System.out.println();
        } else if (izpis.equals("down")) {
            arr.primerjave = 0;
            arr.premiki = 0;
            bucketSort(nacin, "down", arr);
            printNormalSort(1, arr, nacin);
            arr.primerjave = 0;
            arr.premiki = 0;
            bucketSort(nacin, "down", arr);
            printNormalSort(1, arr, nacin);
            arr.primerjave = 0;
            arr.premiki = 0;
            bucketSort(nacin, "up", arr);
            printNormalSort(0, arr, nacin);
            System.out.println();
        }




    }




}











