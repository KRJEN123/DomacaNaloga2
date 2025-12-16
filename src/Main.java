import java.util.Objects;
import java.util.Scanner;

class Array {
    private int[] array;
    private int size;
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

    public void print(int urejen) {
        if (urejen == 0) {
            for (int i = 0; i < size; i++) {
                System.out.printf("%-3d", array[i]);


            }
            System.out.println();

        } else {

            for (int i = 0; i < size; i++) {
                System.out.printf("%-3d", array[i]);
                if (i == urejen) System.out.print("| ");

            }
            System.out.println();
        }
    }

//trace insert up
//10 42 27 17 58 39 91 19 42 66
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
                    insertionSort(nacinIzpisa, vrstaIzpisa, arr);
                    break;
                case "select":
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
            if (nacin.equals("trace")) {
                if (izpis.equals("up")) {
                    arr.print(0);//10 27 42 17 58 39 91 19 42 66
                    for (int i = 1; i < arr.size(); i++) {//i==2
                        int k = arr.get(i);//k==27
                        int j = i;//j==2
                        while (j > 0 && arr.get(j - 1) > k) {// true in true
                            arr.set(j, arr.get(j - 1));//index 2,index 1
                            j = j - 1;//j==1
                        }
                        arr.set(j, k);
                        arr.print(i);
                    }


                } else if (izpis.equals("down")) {
                    arr.print(0);
                    for (int i = 1; i < arr.size(); i++) {//i==2
                        int k = arr.get(i);//k==27
                        int j = i;//j==2
                        while (j > 0 && arr.get(j - 1) < k) {// true in true
                            arr.set(j, arr.get(j - 1));//index 2,index 1
                            j = j - 1;//j==1
                        }
                        arr.set(j, k);
                        arr.print(i);
                    }

                }


            } else if (nacin.equals("count")) {


                if (izpis.equals("up")) {
                    for (int i = 1; i < arr.size(); i++) {
                        int k = arr.get(i);
                        arr.premiki++;
                        int j = i;
                        while (j > 0 && arr.get(j - 1) > k) {
                            arr.primerjave++;
                            arr.set(j, arr.get(j - 1));
                            arr.premiki++;
                            j = j - 1;
                        }
                        arr.set(j, k);
                        arr.premiki++;
                    }


                } else if (izpis.equals("down")) {
                    for (int i = 1; i < arr.size(); i++) {
                        int k = arr.get(i);
                        arr.premiki++;
                        int j = i;
                        while (j > 0 && arr.get(j - 1) < k) {
                            arr.primerjave++;
                            arr.set(j, arr.get(j - 1));
                            arr.premiki++;
                            j = j - 1;
                        }
                        arr.set(j, k);
                        arr.premiki++;
                    }

                }





            }


        }
    }
