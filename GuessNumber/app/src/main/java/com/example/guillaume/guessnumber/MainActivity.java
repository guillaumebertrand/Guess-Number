package com.example.guillaume.guessnumber;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity implements View.OnClickListener{

    Map<ImageButton, Integer> boutons;
    double randomNumber;

    private void init(){

        randomNumber = Math.floor((Math.random() * 98) +1 );

        boutons = new HashMap<>();
        boutons.put((ImageButton) findViewById(R.id.btnZero), new Integer(0));
        boutons.put((ImageButton) findViewById(R.id.btnUn), new Integer(1));
        boutons.put((ImageButton) findViewById(R.id.btnDeux), new Integer(2));
        boutons.put((ImageButton) findViewById(R.id.btnTrois), new Integer(3));
        boutons.put((ImageButton) findViewById(R.id.btnQuatre), new Integer(4));
        boutons.put((ImageButton) findViewById(R.id.btnCinq), new Integer(5));
        boutons.put((ImageButton) findViewById(R.id.btnSix), new Integer(6));
        boutons.put((ImageButton) findViewById(R.id.btnSept), new Integer(7));
        boutons.put((ImageButton) findViewById(R.id.btnHuit), new Integer(8));
        boutons.put((ImageButton) findViewById(R.id.btnNeuf), new Integer(9));

        for(ImageButton ib : boutons.keySet()){
            ib.setOnClickListener(this);
        }

        Button btnReset = (Button) findViewById(R.id.btnPlusOuMoins);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                ((TextView) findViewById(R.id.saisieTw)).setText("");
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void onClick(View v){
        int value= boutons.get((ImageButton) v).intValue();
        Log.d("on click","valeur bouton appuyé : "+ value);

        TextView saisieTw = (TextView) findViewById(R.id.saisieTw);
        if((saisieTw.getText().length() == 0 ) || (saisieTw.getText().length() >= 2)){
            saisieTw.setText(""+ value);
        }
        else {
            saisieTw.setText(saisieTw.getText().toString() + value);
        }
        double saisie =  Double.parseDouble(saisieTw.getText().toString());

        Button btnReset =(Button) findViewById(R.id.btnPlusOuMoins);

        if(saisie == randomNumber){
            //Log.d("on click","WINNER WINNER CHICKEN DINNER");
            btnReset.setText("WINNER WINNER CHICKEN DINNER");
        }
        else if(saisie > randomNumber){
            //Log.d("on click","Trop grand !");
            btnReset.setText("C'est moins que " + saisieTw.getText().toString());
        }
        else{
            //Log.d("on click","Trop bas !");
            btnReset.setText("C'est plus que " + saisieTw.getText().toString());
        }

    }
}
