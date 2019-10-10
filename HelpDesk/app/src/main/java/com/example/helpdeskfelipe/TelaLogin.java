package com.example.helpdeskfelipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.helpdesk.R;
import com.example.helpdeskfelipe.api.LoginTask;
import com.example.helpdeskfelipe.api.OnEventListener;
import com.example.helpdeskfelipe.modelo.Login;
import com.google.gson.Gson;

public class TelaLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_tela);

        final EditText editLogin = (EditText) findViewById(R.id.editLogin);
        final EditText editSenha = (EditText) findViewById(R.id.editSenha);
        final Button btLogar = (Button) findViewById(R.id.btLogar);

        btLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String login = editLogin.getText().toString();
                String chave = editSenha.getText().toString();

                if (login.equals("admin") && chave.equals("senha")) {
                    Toast msg = Toast.makeText(getApplicationContext(), "Login realizado com sucesso", Toast.LENGTH_LONG);
                    msg.show();

                    Intent intent = new Intent(TelaLogin.this, TabelaAtividade.class);
                    intent.putExtra("HelpDesk", "Olá " + login);
                    startActivity(intent);

                } else {
                    Toast msg1 = Toast.makeText(getApplicationContext(), "Login ou Senha incorretos", Toast.LENGTH_LONG);
                    msg1.show();
                }
            }
        });
    }
}

