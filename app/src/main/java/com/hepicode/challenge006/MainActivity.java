package com.hepicode.challenge006;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button button;
    CheckBox checkBoxOne, checkBoxTwo, checkBoxThree, checkBoxFour;
    String cbOneName = "";
    String cbTwoName = "";
    String cbThreeName = "";
    String cbFourName = "";
    String tempText = null;
    TextView countTextview;
    ArrayList<String> cbList;
    String finalText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countTextview = findViewById(R.id.count_text);
        button = findViewById(R.id.button);

        checkBoxOne = findViewById(R.id.cb_one);
        checkBoxTwo = findViewById(R.id.cb_two);
        checkBoxThree = findViewById(R.id.cb_three);
        checkBoxFour = findViewById(R.id.cb_four);

        cbList = new ArrayList<>();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (cbList.size() > 1){

                    finalText = cbList.get(0);

                    for (int i = 1; i < cbList.size(); i++){

                        tempText = cbList.get(i);
                        finalText += " and " + tempText;
                    }

                    countTextview.setText(finalText + " Selected");

                } else if (cbList.size() == 1) {
                    countTextview.setText(cbList.get(0) + " Selected");
                }else {
                    countTextview.setText("No CheckBoxes Selected.");
                }



            }
        });

    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.cb_one:
                if (checked) {
                    cbOneName = checkBoxOne.getText().toString();

                    cbList.add(cbOneName);

                }else
                    cbList.remove(cbOneName);

                break;
            case R.id.cb_two:
                if (checked) {
                    cbTwoName = checkBoxTwo.getText().toString();

                    cbList.add(cbTwoName);
                }else
                    cbList.remove(cbTwoName);

                break;
            case R.id.cb_three:
                if (checked) {
                    cbThreeName = checkBoxThree.getText().toString();

                    cbList.add(cbThreeName);

                }else
                    cbList.remove(cbThreeName);

                break;
            case R.id.cb_four:
                if (checked) {
                    cbFourName = checkBoxFour.getText().toString();

                    cbList.add(cbFourName);
                }else
                    cbList.remove(cbFourName);

                break;
                default:
                    break;
        }
    }

}

/*
1. On app launch, Activity A page will appear on the screen with four Checkbox and TextView widgets.
2. Feel free to select any and all the checkboxes
3. Click the button to display the value of the selected checkbox(es)
4. If no checkbox is selected before the button is click, display the message – No Checkbox selected
 */
