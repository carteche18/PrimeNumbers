package com.example.primenumbers;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLOutput;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    HashMap<String, Integer> resulats = new HashMap<String, Integer>(); //HASH MAP

    EditText n1;
    TextView answer;

    public void toastMsg(String msg) {  //toast pels missatges per pantalla
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1 = findViewById(R.id.num);
        answer = findViewById(R.id.resultat);
        Button button = (Button) findViewById(R.id.buttoncalc);



        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                String num1 = n1.getText().toString();

                //validació dades:

                if (num1.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Enter Numbers",Toast.LENGTH_SHORT).show();
                }
                else if(num1.length() > 4){
                    toastMsg("No més de 4 xifres!");

                }else if (num1.equals("0")){
                    toastMsg("Ep!, com a mínim un 1!");
                }
                else{
                    //codi
                    if (resulats.containsKey(num1)){ //si ja s'ha calculat mostram el resultat
                        System.out.println(" --> " + resulats.get(num1));
                        answer.setText(resulats.get(num1).toString());
                        toastMsg("Prime Number Calculated!");

                    }else { //si no, el calcules

                        int a = Integer.parseInt(n1.getText().toString());
                        int num=1, count=0, i;

                        while (count < a) {
                            num = num + 1;
                            for (i = 2; i <= num; i++) {

                                if (num % i == 0) {

                                    break;
                                }
                            }
                            if (i == num) {

                                count = count + 1;
                            }
                        }
                        String answer1 = String.valueOf(num);
                        resulats.put(num1, num); //guarda el resultat al hash map

                        answer.setText(answer1); //mostra el resultat
                        toastMsg("Prime Number Calculated!");
                    }
                    System.out.println("hashmap: "+ resulats);
                }
            }
        });
    }
}