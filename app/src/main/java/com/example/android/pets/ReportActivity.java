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

import java.util.Calendar;

public class ReportActivity extends AppCompatActivity {

    Calendar c = Calendar.getInstance();
    EditText from,to;
    Integer flag;
    Button generate_report;
    PetCursorAdapter mCursorAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        from = (EditText) findViewById(R.id.from);
        to = (EditText) findViewById(R.id.to);
        generate_report = (Button) findViewById(R.id.generate_report);

        ListView report_list = (ListView) findViewById(R.id.report_list);
        mCursorAdaptor = new PetCursorAdapter(this,null);
        report_list.setAdapter(mCursorAdaptor);

        final DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                if(flag == 1){
                    from.setText(String.valueOf(dayOfMonth)+"/"
                            +String.valueOf(month)+"/"
                            +String.valueOf(year));
                }
                if(flag == 0){
                    to.setText(String.valueOf(dayOfMonth)+"/"
                            +String.valueOf(month)+"/"
                            +String.valueOf(year));
                }
            }
        };


        from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = 1;
                new DatePickerDialog(ReportActivity.this,d,c.get(Calendar.YEAR),c.get(Calendar.MONTH),
                        c.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        to.setOnClickListener(new View.OnClickListener() {
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
