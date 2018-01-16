package edu.upc.eseiaat.pma.motogo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class NameActivity extends AppCompatActivity {

    //public static final String USER_NAME = "MyUserName";

    //String usuario;

    EditText euser;
    Button btnsave;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        euser = (EditText) findViewById(R.id.EditUser);
        btnsave = (Button) findViewById(R.id.btnsave);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(NameActivity.this, ScheduleActivity.class);

                Bundle b = new Bundle();
                b.putString("NOMBRE", euser.getText().toString());

               /* SharedPreferences settings = getSharedPreferences(USER_NAME, 0);
                String user = settings.getString("euser", null);*/


                intent.putExtras(b);

                startActivity(intent);

            }

        });

    }

   /* @Override
    protected void onStop() {
        super.onStop();

        usuario = euser.toString();

        SharedPreferences settings = getSharedPreferences(USER_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putStringSet("euser", usuario);

        editor.commit();

    }*/

    }




