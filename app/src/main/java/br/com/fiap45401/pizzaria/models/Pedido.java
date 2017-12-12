package br.com.fiap45401.pizzaria.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by logonrm on 11/12/2017.
 */

public class Pedido implements Parcelable {
    private String client;
    private List<String> flavours;
    private String size;
    private String payment;

    public Pedido() {

    }

    protected Pedido(Parcel in) {
        client = in.readString();
        flavours = in.createStringArrayList();
        size = in.readString();
        payment = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(client);
        dest.writeStringList(flavours);
        dest.writeString(size);
        dest.writeString(payment);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Pedido> CREATOR = new Creator<Pedido>() {
        @Override
        public Pedido createFromParcel(Parcel in) {
            return new Pedido(in);
        }

        @Override
        public Pedido[] newArray(int size) {
            return new Pedido[size];
        }
    };

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public List<String> getFlavours() {
        return flavours;
    }

    public void setFlavours(List<String> flavours) {
        this.flavours = flavours;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public void addFlavour(String flavour) {
        if (flavours == null) {
            flavours = new ArrayList<>();
        }
        flavours.add(flavour);
    }

    public void removeFlavour(String flavour) {
        if (flavours != null) {
            flavours.remove(flavour);
        }
    }
}
