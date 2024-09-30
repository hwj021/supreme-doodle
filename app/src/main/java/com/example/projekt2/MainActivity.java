package com.example.projekt2;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextEmail;

    private EditText editTextSurname;
    private EditText editTextNumber;
    private EditText editTextPassword;
    private EditText editTextPasswordConfirm;
    private Button buttonSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Powiązanie widoków z kodem
        editTextName = findViewById(R.id.editTextName);
        editTextSurname = findViewById(R.id.editTextSurname);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextNumber = findViewById(R.id.editTextNumber);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextPasswordConfirm = findViewById(R.id.editTextPasswordConfirm);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pobranie wprowadzonych danych
                String name = editTextName.getText().toString().trim();
                String surname = editTextSurname.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String number = editTextNumber.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String confirm = editTextPasswordConfirm.getText().toString().trim();
                // Walidacja danych
                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić imię", Toast.LENGTH_SHORT).show();
                } else if (surname.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić nazwisko", Toast.LENGTH_SHORT).show();
                } else if (editTextNumber.getText().length() < 9) {
                    Toast.makeText(MainActivity.this, "Za krótki numer telefonu", Toast.LENGTH_SHORT).show();
                } else if (password.length() < 6) {
                    Toast.makeText(MainActivity.this, "Za krótkie hasło", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(confirm)) {
                    Toast.makeText(MainActivity.this, "Hasła nie są identyczne", Toast.LENGTH_SHORT).show();
                } else if
                (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(MainActivity.this, "Niepoprawny adres email", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Formularz przesłany poprawnie", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}