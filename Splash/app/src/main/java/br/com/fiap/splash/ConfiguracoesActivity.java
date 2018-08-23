package br.com.fiap.splash;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

public class ConfiguracoesActivity extends AppCompatActivity {

    SharedPreferences sp;
    Spinner spnCor;
    String[] cores = {"Vermelho", "Amarelo", "Verde"};
    CheckBox chkSplash;
    SeekBar sekTempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracoes);

        spnCor = findViewById(R.id.spnCor);
        chkSplash = findViewById(R.id.chkSplash);
        sekTempo = findViewById(R.id.sekTempo);

        sp = getSharedPreferences("configuracoes", MODE_PRIVATE);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                cores
        );

        spnCor.setAdapter(adapter);

        boolean checado = sp.getBoolean("conectado", true);
        chkSplash.setChecked(checado);

        int tempo = sp.getInt("tempoSplashScreen", 10);
        sekTempo.setProgress(tempo);


    }

    public void salvarConfiguracoes(View view) {

        SharedPreferences.Editor editor = sp.edit();

        editor.putBoolean("conectado", chkSplash.isChecked());

        String corEscolhida = spnCor.getSelectedItem().toString();
        editor.putString("CorFundo", corEscolhida);

        int tempo = sekTempo.getProgress();
        editor.putInt("tempoSpashScreen", tempo);

        editor.commit();

        Toast.makeText(this, "Preferências salvas com sucesso!", Toast.LENGTH_LONG).show();
        finish();
    }
}
