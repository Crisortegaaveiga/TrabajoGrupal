package com.example.martes_18;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

class AdaptadorUsuarios extends ArrayAdapter<Usuario> {
    public AdaptadorUsuarios(Context context, Usuario[] datos) {
        super(context, R.layout.lyitem, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyitem, null);

        TextView txtnombre = (TextView)item.findViewById(R.id.lblNombre);
        txtnombre.setText(getItem(position).getNombres());

        TextView txtemail = (TextView)item.findViewById(R.id.lblEmail);
        txtemail.setText(getItem(position).getEmail());

        TextView txtweb = (TextView)item.findViewById(R.id.lblweb);
        txtweb.setText(getItem(position).getWebsite());

        ImageView imageView = (ImageView)item.findViewById(R.id.imgUsr);
        Glide.with(this.getContext())
                .load(getItem(position).getUrlavatar())
                .into(imageView);
        return(item);
    }
}