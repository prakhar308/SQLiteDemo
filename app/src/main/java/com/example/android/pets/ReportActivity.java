package com.example.android.pets;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ReportActivity extends AppCompatActivity {

    Calendar c = Calendar.getInstance();
    EditText e_from,e_to;
    Integer flag;
    Button generate_report;
    PetCursorAdapter mCursorAdaptor;
    String sFromDate,sToDate,sMonth,sDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        e_from = (EditText) findViewById(R.id.from);
        e_to = (EditText) findViewById(R.id.to);
        generate_report = (Button) findViewById(R.id.generate_report);

        ListView report_list = (ListView) findViewById(R.id.report_list);
        mCursorAdaptor = new PetCursorAdapter(this,null);
        report_list.setAdapter(mCursorAdaptor);

        final DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                if(flag == 1){
                    if(month<10 && dayOfMonth<10){
                        sMonth = "0" + String.valueOf(month);
                        sDay = "0"+String.valueOf(dayOfMonth);
                        sFromDate = (String.valueOf(year)+"-" +sMonth+"-" +sDay);
                        e_from.setText(sFromDate);
                    }else if(month<10){
                        sMonth = "0" + String.valueOf(month);
                        sFromDate = (String.valueOf(year)+"-" +sMonth+"-"+String.valueOf(dayOfMonth));
                        e_from.setText(sFromDate);
                    }else if(dayOfMonth<10){
                        sDay = "0"+String.valueOf(dayOfMonth);
                        sFromDate = String.valueOf(year)+"-"+String.valueOf(month)+"-"+sDay;
                        e_from.setText(sFromDate);
                    }else{
                        sFromDate = String.valueOf(year+"-"+String.valueOf(month)+"-"+String.valueOf(dayOfMonth));
                        e_from.setText(sFromDate);
                    }
                }
                if(flag == 0){
                    if(month<10 && dayOfMonth<10){
                        sMonth = "0" + String.valueOf(month);
                        sDay = "0"+String.valueOf(dayOfMonth);
                        sToDate = (String.valueOf(year)+"-" +sMonth+"-" +sDay);
                        e_to.setText(sToDate);
                    }else if(month<10){
                        sMonth = "0" + String.valueOf(month);
                        sToDate = (String.valueOf(year)+"-" +sMonth+"-"+String.valueOf(dayOfMonth));
                        e_to.setText(sToDate);
                    }else if(dayOfMonth<10){
                        sDay = "0"+String.valueOf(dayOfMonth);
                        sToDate = String.valueOf(year)+"-"+String.valueOf(month)+"-"+sDay;
                        e_to.setText(sToDate);
                    }else{
                        sToDate = String.valueOf(year+"-"+String.valueOf(month)+"-"+String.valueOf(dayOfMonth));
                        e_to.setText(sToDate);
                    }
                }
            }
        };


        e_from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = 1;
                new DatePickerDialog(ReportActivity.this,d,c.get(Calendar.YEAR),c.get(Calendar.MONTH),
                        c.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        e_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = 0;
                new DatePickerDialog(ReportActivity.this,d,c.get(Calendar.YEAR),c.get(Calendar.MONTH),
                        c.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        generate_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
