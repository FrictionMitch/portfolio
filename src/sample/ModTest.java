package sample;

import javafx.fxml.FXML;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ModTest {
    @FXML
    private TextField qty;

    private String mNumberAsString = "";
    private String mPrefix = "";
    private int mQty = 5;
    private int mCheckTotal = 0;
    private String mCode ="";
    private String mSequence ="";
    private int mNumber;
    private boolean mForward;
    private List<Integer> mCounter = new ArrayList<Integer>();
    private List<Integer> mod = new ArrayList<Integer>();
    
    public String getNumberAsString() {
        return mNumberAsString;
    }
    
    public int getQty() {
        return mQty;
    }


    public String getCode() {
        return mCode;
    }
    
    public String getSequence() {
        return mSequence;
    }
    
    public int getNumber() {
        return mNumber;
    }
    
    public String getPrefix() {
        return mPrefix;
    }
    
    public boolean isForward() {
        return mForward;
    }
    
    public int getCheckTotal() {
        return mCheckTotal;
    }
    
//    public List<Integer> getCounter() {
//        return mCounter;
//    }
    
    public ModTest(String number) {
       mNumberAsString = number;
       int count = 0;
//        int seqCount = 0;
       while (count < 4) {
           mCode += String.valueOf(mNumberAsString.toUpperCase().charAt(count));
           count++;
       }
    
        int seqCount = 4;
        while (seqCount < mNumberAsString.length()) {
            mSequence += String.valueOf(mNumberAsString.charAt(seqCount));
            seqCount++;
        }
        mNumber = Integer.parseInt(mSequence);

        System.out.printf("The start number is: %s%d %n",getCode(), getNumber());
//        String digitsString = String.valueOf(mNumber);
//        char[] digits1 = digitsString.toCharArray();
        
//        int n = 128;
//        while (n > 0) {
//            int d = n / 10;
//            int k = n - d * 10;
//            n = d;
//            System.out.println(k);
//}
//        IntStream chars = digitsString.chars();
        
//        System.out.printf("%n%n %d", digits1[0]);
//        checkDigit(getNumber());
//        Integer[] digits = getDigits(getNumber());
//        while (digits < getNumber().size) {
//            int position = 0;
//            for (int digit : digits) {
//                if (digit[position] % 2 = 0) {
//                    digit[position] = digit[position] * 1;
//                } else {
//                    digit[position] = digit[position] * 2;
//                    
//                }
//            }
//        }
//        System.out.println(Arrays.toString(digits));
    }
    
//    public static void printDigits(int num) {
//        if(num / 10 > 0) {
//            printDigits(num / 10);
//        }
//        System.out.printf("%d ", num % 10);
//    }
    
//    public static Integer[] getDigits(int num) {
//        List<Integer> digits = new ArrayList<Integer>();
//        collectDigits(num, digits);
//        return digits.toArray(new Integer[]{});
//    }
//
//    private static void collectDigits(int num, List<Integer> digits) {
//        if(num / 10 > 0) {
//            collectDigits(num / 10, digits);
//        }
//        digits.add(num % 10);
//    }
//    public String codePrefix(String prefix) {
//        mNumberAsString = prefix;
//       int count = 0;
////        int seqCount = 0;
//       while (count < 4) {
//           mCode += String.valueOf(mNumberAsString.toUpperCase().charAt(count));
//           count++;
//       }
//    }
//    
//    public String digitsAsString(String number) {
//        mNumberAsString = number;
//        int count = 0;
//        int seqCount = 4;
//        while (seqCount < mNumberAsString.length()) {
//            mSequence += String.valueOf(mNumberAsString.charAt(seqCount));
//            seqCount++;
//        }
//        return mSequence;
//    }
    
    public List<Integer> forwardCount() {
        mCounter.clear();
        int total = getNumber() + getQty();
        while (getNumber() < total) {
            mCounter.add(getNumber());
            mNumber++;
        }
        return mCounter;
    }

    public List<Integer> forwardCount(int qty) {
        mCounter.clear();
        mQty = qty;
        int total = getNumber() + getQty();
        while (getNumber() < total) {
            mCounter.add(getNumber());
            mNumber++;
        }
        return mCounter;
    }

    public List<Integer> backwardCount() {
        mCounter.clear();
        int total = getNumber() - getQty();
        while (getNumber() > total) {
            mCounter.add(getNumber());
            mNumber--;
        }
        return mCounter;
    }

    public List<Integer> backwardCount(int qty) {
        mCounter.clear();
        mQty = qty;
        int total = getNumber() - getQty();
        while (getNumber() > total) {
            mCounter.add(getNumber());
            mNumber--;
        }
        return mCounter;
    }

    
    public int checkDigit(String numberString) {
        
        int currentCheck = 0;
        char[] digits = numberString.toCharArray();
        int position = 0;
        while (position < digits.length) {
            mCheckTotal = 0;
            for (char check : digits) {
                currentCheck = Integer.parseInt(String.valueOf(check));
                if (position % 2 == 0) {
                    mCheckTotal += currentCheck;
                    position++;
                }
                else {
                    currentCheck *= 2;
                    if (currentCheck > 9) {

                        char[] value = String.valueOf(currentCheck).toCharArray();
                        currentCheck = Integer.parseInt(String.valueOf(value[0]))
                                       + Integer.parseInt(String.valueOf(value[1]));
                    }
                    mCheckTotal += currentCheck;
                    position++;
                    
                }
            }
        }
        mCheckTotal = (10 - (mCheckTotal % 10));
        if (mCheckTotal == 10) {
            mCheckTotal = 0;
        }
        return mCheckTotal;
    }



}