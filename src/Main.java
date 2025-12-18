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
                        insertionSort(nacinIzpisa, vrstaIzpisa, arr);
                    } else if (nacinIzpisa.equals("count")) {
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
                    break;
                case "heap":
                    break;
                case "merge":
                    break;
                case "quick":
                    break;
                case "radix":
                    break;
                case "bucket":
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
                if (nacin.equals("trace")) printInsertionSort(0, arr, nacin);
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
                    if (nacin.equals("trace")) printInsertionSort(i, arr, nacin);
                }


            } else if (izpis.equals("down")) {
                if (nacin.equals("trace")) printInsertionSort(0, arr, nacin);
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
                    if (nacin.equals("trace")) printInsertionSort(i, arr, nacin);
                }


            }
        }

        public static void insertionCount(String nacin, String izpis, Array arr) {

            if (izpis.equals("up")) {
                arr.primerjave=0;
                arr.premiki=0;
                insertionSort(nacin,"up",arr);
                printInsertionSort(1,arr,nacin);
                arr.primerjave=0;
                arr.premiki=0;
                insertionSort(nacin,"up",arr);
                printInsertionSort(1,arr,nacin);
                arr.primerjave=0;
                arr.premiki=0;
                insertionSort(nacin,"down",arr);
                printInsertionSort(0,arr,nacin);
                System.out.println();

            } else if (izpis.equals("down")) {
                arr.primerjave=0;
                arr.premiki=0;
                insertionSort(nacin,"down",arr);
                printInsertionSort(1,arr,nacin);
                arr.primerjave=0;
                arr.premiki=0;
                insertionSort(nacin,"down",arr);
                printInsertionSort(1,arr,nacin);
                arr.primerjave=0;
                arr.premiki=0;
                insertionSort(nacin,"up",arr);
                printInsertionSort(0,arr,nacin);
                System.out.println();

            }


        }

        public static void printInsertionSort(int i, Array arr, String nacin) {
            int[] r = arr.toArray();
            if (nacin.equals("trace")) {

                if (i == 0) {
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
        public static void selectionSort(String nacin, String izpis, Array arr){

           if(izpis.equals("up")) {
               if(nacin.equals("trace")) printSelectionSort(-1, arr, nacin);
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
                   arr.premiki+=3;
                   if(nacin.equals("trace")) printSelectionSort(i, arr, nacin);


               }
           }else if(izpis.equals("down")) {
               if(nacin.equals("trace")) printSelectionSort(-1, arr, nacin);
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
                   arr.premiki+=3;
                   if(nacin.equals("trace")) printSelectionSort(i, arr, nacin);


               }

           }


        }
        public static void selectionCount(String nacin, String izpis, Array arr){
            if(izpis.equals("up")) {
                arr.primerjave=0;
                arr.premiki=0;
                selectionSort(nacin,"up",arr);
                printSelectionSort(1,arr,nacin);
                arr.primerjave=0;
                arr.premiki=0;
                selectionSort(nacin,"up",arr);
                printSelectionSort(1,arr,nacin);
                arr.primerjave=0;
                arr.premiki=0;
                selectionSort(nacin,"down",arr);
                printSelectionSort(0,arr,nacin);
                System.out.println();


            }else if(izpis.equals("down")) {
                arr.primerjave=0;
                arr.premiki=0;
                selectionSort(nacin,"down",arr);
                printSelectionSort(1,arr,nacin);
                arr.primerjave=0;
                arr.premiki=0;
                selectionSort(nacin,"down",arr);
                printSelectionSort(1,arr,nacin);
                arr.primerjave=0;
                arr.premiki=0;
                selectionSort(nacin,"up",arr);
                printSelectionSort(0,arr,nacin);
                System.out.println();


            }

        }
        public static void printSelectionSort(int i, Array arr, String nacin){
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

    }
