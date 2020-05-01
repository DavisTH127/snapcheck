import java.util.Scanner;
import java.lang.Math;

public class encrpytionchallenge {
    public void encryptSentence(){
        String currentString = userinput();
        String strList[] = getList(currentString);
        int strLength = strList.length;
        String encrpytedString = "";
        int currentRow = 0;
        int currentCol = 0;
        int row = (int) Math.floor(getSQRT(strLength));
        int col = (int) Math.ceil(getSQRT(strLength));

        if ((row * col) <= strLength){
            row +=1;
        }
        String strTable[][] = getMatrix(row,col,strList,strLength);
        while(true){
            if (currentCol >= col){
                break;
            }else if (currentRow == row){
                currentRow = 0;
                currentCol +=1;
                System.out.print(" ");
            }else{
                if(strTable[currentRow][currentCol] != null) {
                    System.out.print(strTable[currentRow][currentCol]);
                    currentRow += 1;
                }else{
                    strTable[currentRow][currentCol] = "";
                }
            }
        }
    }

    public String userinput(){
        while (true) {
            System.out.println("Please enter a sentence between 1-81 characters: ");
            Scanner scan = new Scanner(System.in);
            String s = scan.nextLine();
            if (s.length() >= 1 && s.length() <= 81) {
                return s;
            } else {
                continue;
            }
        }
    }

    public double getSQRT(double strSize ){
        return Math.sqrt(strSize);
    }

    public String[] getList(String currentString){
        String temp = currentString.replaceAll("\\W","");
        String templist[] = temp.split("");
        return templist;
    }

    public String[][] getMatrix(int row,int col,String[]strList,int strlength){
        String[][] matrix = new String[row][col];
        int currentCount = 0;

        for (int i =0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (currentCount != strlength){
                    matrix[i][j] = strList[currentCount];
                    currentCount +=1;
                }else{
                    break;
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        encrpytionchallenge obj = new encrpytionchallenge();
        obj.encryptSentence();
    }
}
