package com.ith.adapters;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ith.beans.FloristItems;
import com.ith.zinnia.R;

public class FloristAdapter extends BaseAdapter{

	private ArrayList<FloristItems> listitems;
	private Context context;
	
	public FloristAdapter(Context ctx,ArrayList<FloristItems> items){
		this.context =ctx;
		this.listitems = items;
	}
	
	@Override
	public int getCount() {
		return listitems.size();
	}

	@Override
	public Object getItem(int position) {
		return listitems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return listitems.indexOf(getItem(position));
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View row = convertView;
		LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		ViewHolder holder;
		if (row == null) {
			holder = new ViewHolder();
			row = mInflater.inflate(R.layout.buyer_florists_list_items, parent, false);

			holder.tvFrom = (TextView) row.findViewById(R.id.tvFrom);
			holder.tvPrice = (TextView) row.findViewById(R.id.tvPrice);
			holder.tvTitleFlorist = (TextView) row.findViewById(R.id.tvTitleFlorist);
			holder.tvAway = (TextView) row.findViewById(R.id.tvAway);

			row.setTag(holder);
		} else {
			holder = (ViewHolder) row.getTag();
		}

		holder.tvPrice.setText(listitems.get(position).price);
		holder.tvTitleFlorist.setText(listitems.get(position).title);
		holder.tvAway.setText(listitems.get(position).away);
	
		return row;
	}
	
	private class ViewHolder{
		public ImageView imgFlower;
		public TextView tvFrom;
		public TextView tvPrice;
		public TextView tvTitleFlorist;
		public TextView tvAway;
	}

}
