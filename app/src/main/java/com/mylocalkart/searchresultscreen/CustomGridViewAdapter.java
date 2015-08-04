package com.mylocalkart.searchresultscreen;

/**
 * Created by sourin on 04/08/15.
 */
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.global.models.MiniProduct;
import com.mylocalkart.R;


public class CustomGridViewAdapter extends ArrayAdapter<MiniProduct> {
    Context context;
    int layoutResourceId;
    ArrayList<MiniProduct> dataMiniProducts = new ArrayList<MiniProduct>();

    public CustomGridViewAdapter(Context context, int layoutResourceId,
                                 ArrayList<MiniProduct> dataMiniProducts) {
        super(context, layoutResourceId, dataMiniProducts);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.dataMiniProducts = dataMiniProducts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        RecordHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new RecordHolder();
            holder.tvGridMiniPdtName = (TextView) row.findViewById(R.id.tvGridMiniPdtName);
            holder.tvGridMiniPdtPrice = (TextView) row.findViewById(R.id.tvGridMiniPdtPrice);
            holder.ivGridMiniPdtImage = (ImageView) row.findViewById(R.id.ivGridMiniPdtImage);
            row.setTag(holder);
        } else {
            holder = (RecordHolder) row.getTag();
        }

        MiniProduct item = dataMiniProducts.get(position);
        holder.tvGridMiniPdtName.setText(item.getMiniProductName());
        holder.tvGridMiniPdtPrice.setText(item.getMiniProductPrice());
        holder.ivGridMiniPdtImage.setImageBitmap(item.getMiniProductImage());
        return row;

    }

    static class RecordHolder {
        ImageView ivGridMiniPdtImage;
        TextView tvGridMiniPdtName;
        TextView tvGridMiniPdtPrice;
    }
}