package com.example.dcs;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ConvMsg extends ArrayAdapter<MsgConv> {
    private Activity context;
    List<MsgConv> busestime;

    public ConvMsg(Activity context, List<MsgConv> busestime) {
        super(context, R.layout.layout_conmsg_list, busestime);
        this.context = context;
        this.busestime = busestime;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_conmsg_list, null, true);

        TextView textViewmsg = (TextView) listViewItem.findViewById(R.id.textViewmsg);

        MsgConv msgConv = busestime.get(position);
        textViewmsg.setText(msgConv.getBusstop1());

        return listViewItem;
    }
}
