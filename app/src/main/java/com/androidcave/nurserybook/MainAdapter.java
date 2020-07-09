package com.androidcave.nurserybook;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainAdapter extends PagerAdapter {
	private Context ctx;
	private LayoutInflater layoutInflater;

	TextView textView;
	TextView textView_small;
	TextView example_name;
	ImageView image_view;
	String[] color;
	int[] image;
	String[] text;
	String[] example;
	private int txtSize = 160;
	String value;
	int flag = 0;
	int duration;

	public MainAdapter(Context ctx, String[] color, int[] image, String[] text,String[] example,
			int txtSize,String value) {
		this.ctx = ctx;
		this.color = color;
		this.image = image;
		this.text = text;
		this.example = example;
		this.txtSize = txtSize;
		this.value = value;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stuba
		return image.length;
	}

	@Override
	public boolean isViewFromObject(View v, Object o) {
		// TODO Auto-generated method stub
		return (v == (LinearLayout) o);
	}

	@Override
	public Object instantiateItem(final ViewGroup container, final int position) {
		// TODO Auto-generated method stub


		layoutInflater = (LayoutInflater) ctx
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView;
		if(value.equals("Alphabet")){
			itemView = layoutInflater.inflate(R.layout.swiper_layout_alphabet,
					container, false);
			textView = (TextView) itemView.findViewById(R.id.set_img_in_image_view_alphabet);
			textView_small = (TextView) itemView.findViewById(R.id.set_img_in_image_view_alphabet_small);

			textView.setTextColor(Color.parseColor(color[position]));
			textView_small.setTextColor(Color.parseColor(color[position]));
			//textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, txtSize);
			textView.setText(text[position]);
			textView_small.setText(text[position].toLowerCase());


		} else if(value.equals("Alphabet_word")){
			itemView = layoutInflater.inflate(R.layout.swiper_layout_alphabet_word,
					container, false);
			textView = (TextView) itemView.findViewById(R.id.set_img_in_image_view_alphabet_word);
			example_name = (TextView) itemView.findViewById(R.id.example_name);

			image_view = (ImageView) itemView
					.findViewById(R.id.set_img_in_imageview_example_word);

			textView.setTextColor(Color.parseColor(color[position]));
			//textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, txtSize);
			textView.setText(text[position]);
			example_name.setText(example[position]);
			if(example[position].length()>9){
				example_name.setTextSize(30);
			}
			example_name.setTextColor(Color.parseColor(color[position]));
			image_view.setImageResource(image[position]);

		}
		else {
			itemView = layoutInflater.inflate(R.layout.swiper_layout,
					container, false);

			textView = (TextView) itemView.findViewById(R.id.set_img_in_image_view);
			image_view = (ImageView) itemView
					.findViewById(R.id.set_img_in_imageview_example);

			textView.setTextColor(Color.parseColor(color[position]));
			textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, txtSize);
			textView.setText(text[position]);
			image_view.setImageResource(image[position]);
		}



		container.addView(itemView);
		return itemView;

	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
		container.removeView((LinearLayout) object);
	}

}
