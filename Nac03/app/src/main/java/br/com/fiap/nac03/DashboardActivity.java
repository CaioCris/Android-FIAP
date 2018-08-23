package br.com.fiap.nac03;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class DashboardActivity extends AppCompatActivity {

    RadioGroup rdgCores;
    RadioButton rdbVermelho;
    RadioButton rdbAzul;
    RadioButton rdbAmarelo;

    SharedPreferences sp;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        layout = findViewById(R.id.layoutDashboard);

        rdgCores = findViewById(R.id.rdgCores);

        rdbVermelho = findViewById(R.id.rdbVermelho);
        rdbAzul = findViewById(R.id.rdbAzul);
        rdbAmarelo = findViewById(R.id.rdbAmarelo);

        sp = getSharedPreferences("login", MODE_PRIVATE);

        String corFundo = sp.getString("corFundo", "");
        int radioCheck = sp.getInt("corCheck", 0);

        if (!corFundo.equals("")) {
            alterarCorDeFundo(corFundo, layout);
        }

    }

    private void alterarCorDeFundo(String corPreferencia, LinearLayout layout) {
        switch (corPreferencia) {
            case "vermelho" :
                layout.setBackgroundResource(R.color.vermelho);
                rdbVermelho.setChecked(true);
                break;
            case "azul" :
                layout.setBackgroundResource(R.color.azul);
                rdbAzul.setChecked(true);
                break;
            case "verde" :
                layout.setBackgroundResource(R.color.amarelo);
                rdbAmarelo.setChecked(true);
                break;
            default:
                break;
        }

    }

    public void Salvar(View view) {

        int selecionado = rdgCores.getCheckedRadioButtonId();

        SharedPreferences.Editor editor = sp.edit();

        switch (selecionado) {
            case R.id.rdbVermelho:
                layout.setBackgroundResource(R.color.vermelho);
                editor.putString("corFundo", "vermelho");
                editor.commit();
                break;
            case R.id.rdbAzul:
                layout.setBackgroundResource(R.color.azul);
                editor.putString("corFundo", "azul");
                editor.commit();
                break;
            case R.id.rdbAmarelo:
                layout.setBackgroundResource(R.color.amarelo);
                editor.putString("corFundo", "amarelo");
                editor.commit();
                break;
        }

    }
}
