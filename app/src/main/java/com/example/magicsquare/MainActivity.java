package com.example.magicsquare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvResult;
    int ma[][]=new int[5][5];
    int row, col;    //행과 열을 가리키는 변수
    int num = 1;   // 마방진에 들어갈 값
    String result="";   //출력할 변수


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult=(TextView)findViewById(R.id.tvResult);
        col=ma[0].length/2;    // 0행의 1열 구하는방법->첫행의 중간열
        ma[row][col]=num; // 0행 1열에 1을 집어넣는다 ->첫행의 중간열에 1을 집어넣는다
        for (num=2; num<=ma[0].length*ma[0].length; num++) {

            row--;   //  0-1 = -1   대각선 위로 이동한다.
            col++;  //  0+1 = 1
            if (row < 0 && col == ma[0].length) {    //행과열이 모두 존재하지 않는다   라는 대명제를 먼저 걸어줘야 한다! 이게 중요하다.
                row += 2;   //행을 2이동
                col--;   //열을 -1이동
            }
            if (row < 0) { //행이 존재하지 않는다면~
                row = ma[0].length - 1;  //  마지막 행 으로 이동

            } else if (col == ma[0].length) {  // 1행 3열
                col = 0;    // 1행0열로 이동
            } else if (ma[row][col] != 0) {
                row += 2;   //행을 2이동
                col--;   //열을 -1이동
            }
            ma[row][col] = num;  // 2행 2열에 2를 입력함  -> 1행 0열에 3 입력  -> 2행0열에 4입력 ->  1행 1열에 5입력 -> 0행 2열에 6입력 ->...
        }
        for (int i = 0; i<ma[0].length; i++){
            for (int j =0; j<ma[0].length; j++){
                if (ma[i][j]<10){
                    result+="  "+Integer.toString((ma[i][j]))+" ";
                }else
                result+=Integer.toString((ma[i][j]))+" ";
            }
            result+='\n';
        }
        tvResult.setText(result);
        }

}
