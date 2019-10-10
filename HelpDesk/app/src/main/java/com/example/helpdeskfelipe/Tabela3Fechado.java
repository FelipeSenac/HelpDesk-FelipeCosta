package com.example.helpdeskfelipe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.helpdesk.R;
import com.example.helpdeskfelipe.api.ChamadoTask;
import com.example.helpdeskfelipe.api.OnEventListener;
import com.example.helpdeskfelipe.modelo.Chamado;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Tabela3Fechado extends Fragment {

    ListView listaChamadosFechados;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_tres, container, false);
        final List<Chamado> chamadosfechados = new ArrayList<Chamado>();

        ChamadoTask chamadoTask = new ChamadoTask(view.getContext(), new OnEventListener<String>() {

            @Override
            public void onSuccess(String result) {
                Toast.makeText(view.getContext(), "Chamados Fechados ", Toast.LENGTH_LONG).show();
                Gson gson = new Gson();
                Chamado[] chamados = gson.fromJson(result, Chamado[].class);

                for (Chamado chamado : chamados) {
                    if (chamado.getStatus().toLowerCase().equals("fechado")) {

                        chamadosfechados.add(chamado);
                    }

                    ArrayAdapter<Chamado> adapter = new ArrayAdapter<Chamado>(getActivity(),
                            android.R.layout.simple_list_item_1, chamadosfechados);

                    listaChamadosFechados = (ListView) view.findViewById(R.id.chamados_fechados);
                    listaChamadosFechados.setAdapter(adapter);

                }
            }
            @Override
            public void onFailure(Exception e) {
                Toast.makeText(view.getContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        chamadoTask.execute();

        return view;

    }
}
