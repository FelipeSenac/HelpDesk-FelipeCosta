package com.example.helpdeskfelipe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.helpdesk.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class TabelaAtividade extends AppCompatActivity {

    private TabelaAdaptador adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.atividade_tabela);

        //String retorno = getIntent().getExtras().getString("HelpDesk");
       // Toast.makeText(getApplicationContext(), retorno, Toast.LENGTH_LONG).show();

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        adapter = new TabelaAdaptador(getSupportFragmentManager());
        adapter.addFragment(new Tabela1Abertos(), "Abertos");
        adapter.addFragment(new Tabela2Solucao(), "Solucao");
        adapter.addFragment(new Tabela3Fechado(), "Fechados");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        final FloatingActionButton btFloat = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        btFloat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TabelaAtividade.this, TelaChamado.class);
                intent.putExtra("HelpDesk1", "Chamado ");
                startActivity(intent);

                Toast msg = Toast.makeText(getApplicationContext(), "Abrir Chamado", Toast.LENGTH_LONG);
                msg.show();

            }
        });
    }
}

