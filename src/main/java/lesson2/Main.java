package lesson2;

public class Main {
    public static void main(String[] args) throws MyArraySizeException{
        String[][] myArr2 = {
                {"1","2","3","4"},
                {"1","2","3","4"},
                {"1","2","3","4"},
                {"1","2","3","4"},
        };

        checkArr(myArr2);
        System.out.println("Done");

    }

    private static void checkArr(String[][] inputarray) throws MyArraySizeException,MyArrayDataException{
        for(int i = 0; i< inputarray.length; i++) {
            if(inputarray.length != 4 || inputarray[i].length != 4) {
                throw new MyArraySizeException();
            }
        }

        int totalSum = 0;
        for(int i = 0; i< inputarray.length; i++) {
            for(int j = 0; j< inputarray[i].length; j++) {
                try {
                    totalSum += Integer.parseInt(inputarray[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i,j);
                }
            }

        }
        System.out.println(totalSum);
    }
}
