package com.example.menuex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout baseLayout; //위젯들의 변수 선언
    Button button1, button2;
    CalendarView calendarview;
    Chronometer chrono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Option Menu");

        baseLayout = (LinearLayout) findViewById(R.id.baseLayout); //사용할 위젯을 찾고 변수에 위젯 변수 대입
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        calendarview = (CalendarView) findViewById(R.id.calendarview);
        chrono = (Chronometer) findViewById(R.id.chrono);

        calendarview.setVisibility(View.INVISIBLE); //캘린더뷰의 Visibility를 INVISIBLE로 선언
        chrono.setVisibility(View.INVISIBLE); //크로노미터의  Visibility를 INVISIBLE로 선언

        button1.setOnClickListener(new View.OnClickListener() { //버튼을 클릭했을때 이벤트처리 메소드
            @Override
            public void onClick(View view) {
                chrono.setBase(SystemClock.elapsedRealtime()); // 크로노미터 초기화 메소드
                if (button1.isClickable() == true) { //버튼이 클릭되었을때
                    chrono.setVisibility(View.VISIBLE); //크로노미터를 보이게 한다.
                    chrono.setTextColor(Color.RED); // TextColor를 빨간색으로 변경한다.
                    chrono.start(); //크로노미터 시작
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() { //버튼을 클릭했을때 이벤트처리 메소드
            @Override
            public void onClick(View view) {
                if (button2.isClickable() == true) { //버튼이 클릭되었을때
                    chrono.setVisibility(View.VISIBLE); //크로노미터를 보이게한다.
                    chrono.setTextColor(Color.GREEN); // TextColor를 초록색으로 변경한다.
                    chrono.stop(); //크로노미터를 정지한다.
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //옵션 메뉴를 등록하는 이벤트처리이다.
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater(); //MenuInflater를 생성해야한다.
        mInflater.inflate(R.menu.menu1, menu); //MenuInflater에 XML 파일(menu1.xml =R.Menu.menu1)을 등록한다.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) { //메뉴를 클릭했을 때 동작할 이벤트처리이다.
        switch (item.getItemId()) { //Item의 Id를 가져온다
            case R.id.itemRed: //Id가 itemRed일 경우
                baseLayout.setBackgroundColor(Color.RED); //LinaerLayout의 BackgroundColor를 빨간색으로 바꾼다.
                Toast.makeText(getApplicationContext(),"배경이 빨간색으로 바뀌었습니다.",
                        Toast.LENGTH_LONG).show();
                return true;
            case R.id.itemGreen: //Id가 itemGreen일 경우
                baseLayout.setBackgroundColor(Color.GREEN); //LinaerLayout의 BackgroundColor를 초록색으로 바꾼다.
                Toast.makeText(getApplicationContext(), "배경이 초록색으로 바뀌었습니다.",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itemBlue: //Id가 itemBlue일 경우
                baseLayout.setBackgroundColor(Color.BLUE); //LinearLayout의 BackgroundColor를 파란색으로 바꾼다.
                Toast.makeText(getApplicationContext(), "배경이 파란색으로 바뀌었습니다.",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subRotate: //Id가 subRotate일 경우
                button1.setRotation(45); //button1을 45도 회전시킨다.
                Toast.makeText(getApplicationContext(), "버튼이 45도 회전하였습니다.",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subSize: //Id가 subSize일 경우
                button1.setScaleX(2); //Button1을 2배로 증가시킨다.
                Toast.makeText(getApplicationContext(), "버튼이 2배가 되었습니다.",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subcalender: //Id가 subcalender일 경우
                calendarview.setVisibility(View.VISIBLE); // 캘린더를 보이게한다.
                Toast.makeText(getApplicationContext(), "캘린더가 생겼습니다.",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.RsubRotate: // Id가 RsubRotate일 경우
                button1.setRotation(0); //button1의 회전을 0으로 초기화 시킨다.
                Toast.makeText(getApplicationContext(), "버튼이 초기화 되었습니다.",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.RsubSize: // Id가 RsubSize일 경우
                button1.setScaleX(1); //button1을 1배인 원래 상태의 버튼으로 초기화한다.
                Toast.makeText(getApplicationContext(), "버튼이 초기화되었습니다",
                        Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }
}