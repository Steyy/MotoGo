package edu.upc.eseiaat.pma.motogo;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;

public class ScheduleActivity extends AppCompatActivity implements CalendarView.OnDateChangeListener {

    private CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        calendarView = (CalendarView) findViewById(R.id.calendar);
        calendarView.setOnDateChangeListener(this);
    }

    @Override
    public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        CharSequence []items = new CharSequence[3];
        items[0]="Pedir cita";
        items[1]="Ver citas";
        items[2]="Cancelar";

        final int dia, mes, anio;
        dia = i;
        mes = i1+1;
        anio = i2;


        builder.setTitle("Seleccione una opción")
                .setItems(items, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        if (i==0){
                            //pedir cita
                            Intent intent = new Intent(getApplication(), AddActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putInt("dia",dia);
                            bundle.putInt("mes",mes);
                            bundle.putInt("anio",anio);
                            intent.putExtras(bundle);
                            startActivity(intent);

                        }else if(i==1){
                            //ver citas
                            Intent intent = new Intent(getApplication(), DateActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putInt("dia",dia);
                            bundle.putInt("mes",mes);
                            bundle.putInt("anio",anio);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }else{
                            return;
                        }

                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
