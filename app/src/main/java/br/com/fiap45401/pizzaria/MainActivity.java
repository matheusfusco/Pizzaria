package br.com.fiap45401.pizzaria;

import android.content.Intent;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import br.com.fiap45401.pizzaria.models.Pedido;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private String username;

    @BindView(R.id.tvWelcome)
    TextView tvWelcome;

    @BindView(R.id.cbCalabresa)
    CheckBox cbCalabresa;

    @BindView(R.id.cbFrango)
    CheckBox cbFrango;

    @BindView(R.id.cbPortuguesa)
    CheckBox cbPortuguesa;

    @BindView(R.id.cbQueijo)
    CheckBox cbQueijo;

    @BindView(R.id.spPagamento)
    Spinner spPagamento;

    @BindView(R.id.rgSize)
    RadioGroup rgSize;

    Pedido pedido = new Pedido();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (getIntent() != null) {
            username = getIntent().getStringExtra("USUARIO");
            tvWelcome.setText("Bem vindo " + username + "!");
        }

        configureCheckBoxListener(cbCalabresa);
        configureCheckBoxListener(cbFrango);
        configureCheckBoxListener(cbPortuguesa);
        configureCheckBoxListener(cbQueijo);
    }

    private void configureCheckBoxListener(final CheckBox cb) {
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    pedido.addFlavour(cb.getText().toString());
                }
                else {
                    pedido.removeFlavour(cb.getText().toString());
                }

            }
        });
    }

    @OnClick(R.id.btFecharPedido)
    public void closeOrder() {

        pedido.setClient(username);
        pedido.setSize(getPizzaSize());
        pedido.setPayment(spPagamento.getSelectedItem().toString());

        Intent proxTela = new Intent(this, ConfirmarPedidoActivity.class);
        proxTela.putExtra("PEDIDO", pedido);
        startActivity(proxTela);
    }

    public String getPizzaSize() {
        return ((RadioButton)findViewById(rgSize.getCheckedRadioButtonId())).getText().toString();
    }
}
