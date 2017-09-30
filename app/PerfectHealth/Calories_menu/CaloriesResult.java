package com.abdulrahman.asus.PerfectHealth.Calories_menu;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.abdulrahman.asus.PerfectHealth.R;

public class CaloriesResult extends AppCompatActivity {
    double hieght , wieght , result;
    int age , level;
    String radioButton , resultN , resultL , resultW;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories_result);
        TextView  resultNow = (TextView)findViewById(R.id.resultNow);
        TextView  resultLoss = (TextView)findViewById(R.id.resultLoss);
        TextView  resultWin = (TextView)findViewById(R.id.resultWin);

        Bundle bundle = getIntent().getExtras();

        hieght = bundle.getDouble("hieght");
        wieght = bundle.getDouble("wieght");
        age = bundle.getInt("age");
        radioButton = bundle.getString("radio");
        level = bundle.getInt("level");

        resultN = String.valueOf(String.format("%.1f",calculate()));
        resultL = String.valueOf(String.format("%.1f",calculate()-550));
        resultW = String.valueOf(String.format("%.1f",calculate()+550));


        resultNow.setText(convertToEnglishDigits(resultN));
        resultLoss.setText(convertToEnglishDigits(resultL));
        resultWin.setText(convertToEnglishDigits(resultW));

    }

    private double calculate(){
        switch (level){
            case 1:
                if (radioButton.equals("men"))
                    result = ((10 * wieght) + (6.25 * hieght) - (5 * age) + 5) * 1.2;
                else if(radioButton.equals("female"))
                    result = ((10 * wieght) + (6.25 * hieght) - (5 * age) - 161) * 1.2;
                break;
            case 2:
                if (radioButton.equals("men"))
                    result = ((10 * wieght) + (6.25 * hieght) - (5 * age) + 5) * 1.375;
                else if(radioButton.equals("female"))
                    result = ((10 * wieght) + (6.25 * hieght) - (5 * age) - 161) * 1.375;
                break;
            case 3:
                if (radioButton.equals("men"))
                    result = ((10 * wieght) + (6.25 * hieght) - (5 * age) + 5) * 1.55;
                else if(radioButton.equals("female"))
                    result = ((10 * wieght) + (6.25 * hieght) - (5 * age) - 161) * 1.55;
                break;
            case 4:
                if (radioButton.equals("men"))
                    result = ((10 * wieght) + (6.25 * hieght) - (5 * age) + 5) * 1.725;
                else if(radioButton.equals("female"))
                    result = ((10 * wieght) + (6.25 * hieght) - (5 * age) - 161) * 1.725;
                break;
            case 5:
                if (radioButton.equals("men"))
                    result = ((10 * wieght) + (6.25 * hieght) - (5 * age) + 5) * 1.9;
                else if(radioButton.equals("female"))
                    result = ((10 * wieght) + (6.25 * hieght) - (5 * age) - 161) * 1.9;
                break;
        }



        return result;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public static String convertToEnglishDigits(String value)
    {
        String newValue = value.replace("١", "1").replace("٢", "2").replace("٣", "3").replace("٤", "4").replace("٥", "5")
                .replace("٦", "6").replace("٧", "7").replace("٨", "8").replace("٩", "9").replace("٠", "0")
                .replace("۱", "1").replace("۲", "2").replace("۳", "3").replace("۴", "4").replace("۵", "5")
                .replace("۶", "6").replace("۷", "7").replace("۸", "8").replace("۹", "9").replace("۰", "0");

        return newValue;
    }

}
