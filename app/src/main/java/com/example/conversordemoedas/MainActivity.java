package com.example.conversordemoedas;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValor = findViewById(R.id.editValor);
        this.mViewHolder.textDollar = findViewById(R.id.textDolllar);
        this.mViewHolder.textEuro = findViewById(R.id.textEuro);
        this.mViewHolder.buttonCalcular = findViewById(R.id.buttonCalcular);

        this.mViewHolder.buttonCalcular.setOnClickListener(this);

        //Chama o metodo para limpar os campos
        this.limparcampos();

    }

    @Override
    public void onClick(View view) {
        int id = mViewHolder.buttonCalcular.getId();
            if (id == R.id.buttonCalcular) {
                //Logica do Botão calcular
                this.mViewHolder.buttonCalcular.setBackgroundColor(getColor(R.color.colorPrimary));
                Double valor = Double.valueOf(this.mViewHolder.editValor.getText().toString());
                this.mViewHolder.textDollar.setText(String.format("%.2f",valor*3.76));
                this.mViewHolder.textEuro.setText(String.format("%.2f",valor*4.23));

            }
    }

    private void limparcampos(){
        this.mViewHolder.textDollar.setText("");
        this.mViewHolder.textEuro.setText("");
        this.mViewHolder.editValor.setText("");

    }

    private static class ViewHolder{
        EditText editValor;
        TextView textDollar;
        TextView textEuro;
        Button buttonCalcular;
    }
}
