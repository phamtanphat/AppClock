package com.example.myapplication;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    ClockView clockView;
    Button btnDatlich;
    ListView lv;
    EditText edtCongviec;
    ArrayList<Timeclock> mangtimeclock = new ArrayList<>();
    String congviec = "";
    AdapterClock adapterClock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clockView = findViewById(R.id.clockview);
        btnDatlich = findViewById(R.id.buttonDatlich);
        lv = findViewById(R.id.listview);
        edtCongviec = findViewById(R.id.edittextCongviec);

        adapterClock = new AdapterClock(MainActivity.this,mangtimeclock,R.layout.dong_time_clock);
        lv.setAdapter(adapterClock);

        btnDatlich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if (edtCongviec.getText().toString().length() > 0){
                            Calendar calendar = Calendar.getInstance();
                            calendar.set(clockView.getCalendarCurrent().get(Calendar.YEAR) , clockView.getCalendarCurrent().get(Calendar.MONTH) , clockView.getCalendarCurrent().get(Calendar.DATE),hourOfDay,minute);
                            Timeclock timeclock = new Timeclock(calendar.getTimeInMillis(),true,edtCongviec.getText().toString());

                            mangtimeclock.add(timeclock);
                            adapterClock.notifyDataSetChanged();
                        }else{
                            Toast.makeText(MainActivity.this, "Nhập công việc", Toast.LENGTH_SHORT).show();
                            edtCongviec.findFocus();
                        }



                    }
                },clockView.getCalendarCurrent().get(Calendar.HOUR) , clockView.getCalendarCurrent().get(Calendar.MINUTE) , true);
                timePickerDialog.show();
            }
        });





    }
}
