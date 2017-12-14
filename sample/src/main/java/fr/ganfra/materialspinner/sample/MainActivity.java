package fr.ganfra.materialspinner.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import fr.ganfra.materialspinner.MaterialSpinner;


public class MainActivity extends AppCompatActivity {

    private static final String ERROR_MSG = "Very very very long error message to get scrolling or multiline animation when the error button is clicked";
    private static final String[] ITEMS = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6"};

    private ArrayAdapter<String> adapter;

    MaterialSpinner spinner1;
    MaterialSpinner spinner2;
    MaterialSpinner spinner3;
    MaterialSpinner spinner4;
    MaterialSpinner spinner5;
    MaterialSpinner spinner6;
    MaterialSpinner spinner7;
    MaterialSpinner spinner8;

    private boolean shown = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ITEMS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        initSpinnerHintAndFloatingLabel();
        initSpinnerOnlyHint();
        initSpinnerNoHintNoFloatingLabel();
        initSpinnerMultiline();
        initSpinnerScrolling();
        initSpinnerHintAndCustomHintView();
        initEmptyArray();
        initHintNotSelectable();
    }

    private void initSpinnerHintAndCustomHintView() {
        spinner6 = findViewById(R.id.spinner6);
        spinner6.setAdapter(adapter);
        spinner4.setHint("Select an item");
    }

    private void initSpinnerHintAndFloatingLabel() {
        spinner1 = findViewById(R.id.spinner1);
        spinner1.setAdapter(adapter);
        spinner1.setPaddingSafe(0, 0, 0, 0);
    }

    private void initSpinnerOnlyHint() {
        spinner2 = findViewById(R.id.spinner2);
    }

    private void initSpinnerNoHintNoFloatingLabel() {
        spinner3 = findViewById(R.id.spinner3);
        spinner3.setAdapter(adapter);
    }

    private void initSpinnerMultiline() {
        spinner4 = findViewById(R.id.spinner4);
        spinner4.setAdapter(adapter);
        spinner4.setHint("Select an item");
    }

    private void initSpinnerScrolling() {
        spinner5 = findViewById(R.id.spinner5);
        spinner5.setAdapter(adapter);
        spinner5.setHint("Select an item");
    }

    private void initEmptyArray() {
        String[] emptyArray = {};
        spinner7 = findViewById(R.id.spinner7);
        spinner7.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, emptyArray));
    }

    private void initHintNotSelectable(){
        spinner8 = findViewById(R.id.spinner8);
        spinner8.setAdapter(adapter);
        spinner8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(spinner8.getSelectedItem() != null) {
                    Log.d("SELECTED_ITEM", spinner8.getSelectedItem().toString());
                    Log.d("SELECTED_ITEM", ITEMS[i]);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.d("SELECTED_ITEM", "No thing selected");
            }
        });
    }

    public void activateError(View view) {
        if (!shown) {
            spinner4.setError(ERROR_MSG);
            spinner5.setError(ERROR_MSG);
        } else {
            spinner4.setError(null);
            spinner5.setError(null);
        }
        shown = !shown;

    }


}
