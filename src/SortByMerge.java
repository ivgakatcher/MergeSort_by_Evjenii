public class SortByMerge {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        int[] array1 = {3, 1, 2, 4, 8, 5, 3, 9, 2, 6, 8, 0, 4, 56, 34, 67, 34, 23, 14, 78, 45, 93};
        printArray("Исходный массив ", array1);

        array1 = sortByMerge(array1);
        printArray("Сортированный массив ", array1);

    }

    private static void printArray(String message, int[] massiv) {
        System.out.println(message + massiv.length + " чисел");
        for (int i = 0; i < massiv.length; i++) {
            System.out.print(massiv[i] + " ; ");
        }
        System.out.println();
    }

    public static int[] mergeSortedArray(int[] m1, int[] m2) {
        int[] resultArray = new int[m1.length + m2.length];
        int pos1 = 0, pos2 = 0;
        for (int i = 0; i < resultArray.length; i++) {
            if (pos1 == m1.length) {
                resultArray[i] = m2[pos2];
                pos2++;
            } else if (pos2 == m2.length) {
                resultArray[i] = m1[pos1];
                pos1++;
            } else if (m1[pos1] < m2[pos2]) {
                resultArray[i] = m1[pos1];
                pos1++;
            } else {
                resultArray[i] = m2[pos2];
                pos2++;
            }
        }
        return resultArray;
    }
    public static int[] sortByMerge(int[] m) {
        //проверка, что массив невырожденный
        if (m == null) return null;
        if (m.length == 1) return m;
        //разбиение на два равных кусочка
        int len1=m.length / 2;
        int len2=m.length - m.length / 2;
        int[] m1 = new int[len1];
        System.arraycopy(m, 0, m1, 0, len1);
        int[] m2 = new int[len2];
        System.arraycopy(m, len1, m2, 0, len2);
        //сортировка левого и правого кусочков
        m1 = sortByMerge(m1);
        m2 = sortByMerge(m2);
        //слияние отсортированных левого и правого кусочков
        return mergeSortedArray(m1, m2);
    }
}
