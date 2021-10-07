package lesson5;

public class Main {
    public static void main(String[] args) {
        System.out.println("Lesson 5");
        String[] aaa = { "value1", "value2", "value3" };
        int[][] bbbb = { { 100, 200, 300 }, { 300, 400, 500 } };
        AppData appData = new AppData(aaa, bbbb);
        appData.save("data.csv");
        appData.load("data.csv");
        System.out.println(appData.toString());
    }
}
