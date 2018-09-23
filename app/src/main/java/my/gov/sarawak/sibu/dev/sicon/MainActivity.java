package my.gov.sarawak.sibu.dev.sicon;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import my.gov.sarawak.sibu.dev.sicon.PageActivity;
import my.gov.sarawak.sibu.dev.sicon.R;

public class MainActivity extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private TextView Signup;
    private int counter = 4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = findViewById(R.id.loginusername);
        Password = findViewById(R.id.loginpassword);
        Info = findViewById(R.id.loginInfo);
        Login = findViewById(R.id.loginsignin);
        Signup = findViewById(R.id.loginsignup);

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignupActivity.class));
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Username.getText().toString(), Password.getText().toString());
            }
        });
    }

    private void validate(String userName, String userPassword){
        if((userName.equals("Admin")) && (userPassword.equals("1234"))){
            Intent intent = new Intent(MainActivity.this, PageActivity.class);
            startActivity(intent);
        }else{
            counter--;

            Info.setText("No of attempts remaining: " + String.valueOf(counter));

            if(counter == 0){
                Login.setEnabled(false);
            }
        }
    }

}
