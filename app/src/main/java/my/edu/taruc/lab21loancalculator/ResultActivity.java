package my.edu.taruc.lab21loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView textView;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //link UI to program
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);

        //To receive data from another Activitys
        Intent intent = getIntent(); //asking "who called me?"
        double payment = intent.getDoubleExtra(MainActivity.MONTHLY_PAYMENT,0);
        String status = intent.getStringExtra((MainActivity.LOAN_STATUS));


        //TODO : display the output
        textView.setText("Monthly Payment " + payment);
        textView2.setText("Loan Status " + status);


    }

    public void closeActivity(View view){
        //terminate the current activity
        finish();
    }
}
