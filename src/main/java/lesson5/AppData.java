package lesson5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class AppData {
    private String[] header;
    private int[][] data;
    private static final String DELIMITER = ";";

    AppData(String[] _header, int[][] _data) {
        this.header = _header;
        this.data = _data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Data contains: \n");
        sb.append(Arrays.toString(header));
        sb.append("\n");
        for (int[] dataline : data) {
            sb.append(Arrays.toString(dataline)).append("\n");
        }
        return sb.toString();
    }

    public void save(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);
            fw.write(String.join(DELIMITER, header));
            fw.write("\n");
            for (int[] dataline : data) {
                String str = Arrays.toString(dataline).replace("[", "").replace("]", "").replace(" ", "")
                        .replace(",", DELIMITER).trim();
                fw.write(String.join(DELIMITER, str));
                fw.write("\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            this.header = br.readLine().split(DELIMITER);
            ArrayList<ArrayList<Integer>> _data = new ArrayList<>();
            String strCurrentLine;
            int i = 0;
            while ((strCurrentLine = br.readLine()) != null) {
                _data.add(new ArrayList<Integer>());
                for (String elem : strCurrentLine.split(DELIMITER)) {
                    _data.get(i).add(Integer.parseInt(elem));
                }
                i++;
            }
            // from https://stackoverflow.com/questions/10043209/convert-arraylist-into-2d-array-containing-varying-lengths-of-arrays
            this.data = _data.stream().map(u -> u.stream().mapToInt(n -> n).toArray()).toArray(int[][]::new);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
