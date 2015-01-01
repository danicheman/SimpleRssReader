package com.simplerssreader;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RssAdapter extends BaseAdapter {

	private final List<RssItem> items;
	private final Context context;

	public RssAdapter(Context context, List<RssItem> items) {
		this.items = items;
		this.context = context;
	}

	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int id) {
		return id;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = View.inflate(context, R.layout.rss_item, null);
			holder = new ViewHolder();
			holder.itemTitle = (TextView) convertView.findViewById(R.id.itemTitle);
			holder.itemImage = (ImageView) convertView.findViewById(R.id.itemImage);
            convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.itemTitle.setText(items.get(position).getTitle());
        new ImageDownloader(holder.itemImage).execute(items.get(position).getUrl());
		return convertView;
	}

	static class ViewHolder {
		TextView itemTitle;
        ImageView itemImage;
	}
}
