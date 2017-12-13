package br.com.fiap45401.pizzaria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.fiap45401.pizzaria.models.Pedido;

public class ConfirmarPedidoActivity extends AppCompatActivity {

    private Pedido pedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_pedido);

        if (getIntent() != null) {
            pedido = getIntent().getParcelableExtra("PEDIDO");
        }
    }
}
