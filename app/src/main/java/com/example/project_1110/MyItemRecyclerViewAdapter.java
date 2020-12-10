package com.example.project_1110;

import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project_1110.dummy.DummyContent.DummyItem;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.travijuu.numberpicker.library.Enums.ActionEnum;
import com.travijuu.numberpicker.library.Interface.ValueChangedListener;
import com.travijuu.numberpicker.library.NumberPicker;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
    public int itemQuantity;

    public MyItemRecyclerViewAdapter(List<DummyItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = mValues.get(position);
        //holder.mIdView.setValue(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);
        holder.mThumbnailView.setImageResource(R.drawable.background);
        holder.mCostView.setText(mValues.get(position).itemCost);
        holder.mQuantity.setValue(Integer.parseInt(mValues.get(position).itemQuantity));

        holder.btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(v.getContext());
                //SharedPreferences preferences = ((Activity)v.getContext()).getPreferences(Context.MODE_PRIVATE);
                String jsonRetreived = preferences.getString("CART_ITEMS","");
                Gson gson = new Gson();
                List<DummyItem> cartItems = new ArrayList<DummyItem>();
                if(jsonRetreived.length()>0) {
                    Type listType = new TypeToken<List<DummyItem>>() {
                    }.getType();
                    cartItems = gson.fromJson(jsonRetreived, listType);
                }

                DummyItem d = new DummyItem(mValues.get(position).id,mValues.get(position).content,mValues.get(position).details,mValues.get(position).thumbnailURL,
                        mValues.get(position).itemCost, mValues.get(position).itemQuantity);
                cartItems.add(d);
                String json = gson.toJson(cartItems);

                //SharedPreferences preferences = ((Activity)v.getContext()).getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                editor.putString("CART_ITEMS",json);
                editor.apply();
                Toast.makeText(v.getContext(), "Added to cart!", Toast.LENGTH_SHORT).show();
            }
        });

        holder.mIdView.setValueChangedListener(new ValueChangedListener() {
            public void valueChanged(int value, ActionEnum action) {
                mValues.get(position).itemQuantity = Integer.toString(value);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final NumberPicker mIdView;
        public final TextView mContentView;
        public final ImageView mThumbnailView;
        public final TextView mCostView;
        public final Button btnAddToCart;
        public final NumberPicker mQuantity;

        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (NumberPicker) view.findViewById(R.id.item_quantity);
            mContentView = (TextView) view.findViewById(R.id.content);
            mThumbnailView = (ImageView) view.findViewById(R.id.frameBackground);
            mCostView = (TextView) view.findViewById(R.id.cost);
            btnAddToCart = (Button)view.findViewById(R.id.addToCart);
            mQuantity = (NumberPicker) view.findViewById(R.id.item_quantity);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}