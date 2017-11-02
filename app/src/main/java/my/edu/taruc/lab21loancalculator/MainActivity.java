package my.edu.taruc.lab21loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String MONTHLY_PAYMENT = "payment";
    public static final String LOAN_STATUS = "status";

    //gobal variables
    EditText editText;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        editText2  = (EditText) findViewById(R.id.editText2);
        editText3  = (EditText) findViewById(R.id.editText3);
        editText4  = (EditText) findViewById(R.id.editText4);
        editText5  = (EditText) findViewById(R.id.editText5);
    }

    public void calculateLoan(View view) {

        //TODO: calculate monthly payment and determine the loan status
        double monthlyPayment = 0;
        String status = "Approved";

        double vehiclePrice;
        double DownPayment;
        double Repayment;
        double InterestRate;
        double Salary;

        //get input
        vehiclePrice = Double.parseDouble(editText.getText().toString());
        DownPayment = Double.parseDouble(editText2.getText().toString());
        Repayment = Double.parseDouble(editText3.getText().toString());
        InterestRate = Double.parseDouble(editText4.getText().toString())/100;
        Salary = Double.parseDouble(editText5.getText().toString());

        double totalInterest;
        double totalLoan;
        double Salary30 = Salary*0.3;

        //calculation and adjustment
        totalInterest = (vehiclePrice - DownPayment)*InterestRate*(Repayment/12);
        totalLoan = (vehiclePrice - DownPayment)+totalInterest;
        monthlyPayment = totalLoan/Repayment;

        if(monthlyPayment > Salary30)
            status = "Rejected";
        else
            status ="Approved";

        //create an explicit intent
        Intent intent = new Intent(this, ResultActivity.class);

        //TODO : passing data using putExtra method
        //format : putExtra(TAG,value)
        intent.putExtra(MONTHLY_PAYMENT, monthlyPayment);
        intent.putExtra(LOAN_STATUS, status);
        startActivity(intent);


    }

        protected void onReset(View view){
        editText.setText("");
        editText2.setText("");
        editText3.setText("");
        editText4.setText("");
        editText5.setText("");

    }

}
