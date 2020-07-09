package com.androidcave.nurserybook;

import java.io.IOException;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Main extends Fragment implements OnClickListener {

	private ViewPager pager;
	private MainAdapter adepter;
	private ImageView Previous;
	private ImageView Back;
	private ImageView Next;
	private ImageView Reply;
	private MediaPlayer mp;
	private Context mContext;
	private int position;
	private int txtSize = 160;
	private View MainFragment;
	View center_view;


	private int[] alphabet_sound = { R.raw.apple, R.raw.ball, R.raw.cat,
			R.raw.doll, R.raw.egg, R.raw.frog, R.raw.grape, R.raw.hen,
			R.raw.igloo, R.raw.jam, R.raw.kite, R.raw.lemon,
			R.raw.mouse, R.raw.nest, R.raw.orrnge, R.raw.pig, R.raw.quail,
			R.raw.rabbit, R.raw.sun, R.raw.train, R.raw.umbrella,
			R.raw.van, R.raw.watermelon, R.raw.xray_fish, R.raw.yoyo,
			R.raw.zebra };
	private int[] alphabet_spelling_sound = { R.raw.s_apple, R.raw.s_ball, R.raw.s_cat,
			R.raw.s_doll, R.raw.s_egg, R.raw.s_frog, R.raw.s_grape, R.raw.s_hen,
			R.raw.s_igloo, R.raw.s_jam, R.raw.s_kite, R.raw.s_lemon,
			R.raw.s_mouse, R.raw.s_nest, R.raw.s_orange, R.raw.s_pig, R.raw.s_quill,
			R.raw.s_rabbit, R.raw.s_sun, R.raw.s_train, R.raw.s_umbrella,
			R.raw.s_van, R.raw.s_watermelon, R.raw.s_xray_fish, R.raw.s_yoyo,
			R.raw.s_zebra };

	private int[] color_sound = { R.raw.black,R.raw.white, R.raw.blue, R.raw.brown,
			R.raw.green, R.raw.yellow, R.raw.orange, R.raw.red,R.raw.purple };

	private int[] number_sound = { R.raw.n1, R.raw.n2, R.raw.n3, R.raw.n4,
			R.raw.n5, R.raw.n6, R.raw.n7, R.raw.n8, R.raw.n9, R.raw.n10 };

	private int[] alphabet_word_sound = { R.raw.a, R.raw.b,R.raw.c, R.raw.d,R.raw.e, R.raw.f,R.raw.g, R.raw.h,
			R.raw.i, R.raw.j,R.raw.k, R.raw.l ,R.raw.m, R.raw.n,R.raw.o, R.raw.p ,R.raw.q, R.raw.r ,
			R.raw.s, R.raw.t ,R.raw.u, R.raw.v ,R.raw.w, R.raw.x ,R.raw.y, R.raw.z };

	private String[] color, text,example;

	private int[] sound, image;

	private String value = "";

	private int endPosition = 0;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		MainFragment = inflater.inflate(R.layout.viewpager_layout, container,
				false);
		value = getArguments().getString("value");
		mContext = getActivity().getApplicationContext();
		initUI();
		return MainFragment;
	}

	@SuppressLint("Recycle")
	public void initUI() {
		Previous = (ImageView) MainFragment.findViewById(R.id.previous);
		Next = (ImageView) MainFragment.findViewById(R.id.next);
		Reply = (ImageView) MainFragment.findViewById(R.id.reply);
		pager = (ViewPager) MainFragment.findViewById(R.id.viewpager);
		center_view = (View) MainFragment.findViewById(R.id.center_view);
		Back = (ImageView) MainFragment.findViewById(R.id.back);
		loadData();
		mp = MediaPlayer.create(mContext, sound[0]);

		final Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				// Do something after 1000ms
				prepare();
				mp.start();
			}
		}, 1000);
		adepter = new MainAdapter(mContext, color, image, text,example, txtSize,value);

		pager.setOnPageChangeListener(player);
		pager.setAdapter(adepter);

		pager.setCurrentItem(0);




		Previous.setVisibility(View.INVISIBLE);

		Next.setOnClickListener(this);
		Previous.setOnClickListener(this);
		Reply.setOnClickListener(this);
		center_view.setOnClickListener(this);
		Back.setOnClickListener(this);

	}

	private int getItem(int i) {
		return pager.getCurrentItem() + i;
	}

	OnPageChangeListener player = new OnPageChangeListener() {

		@Override
		public void onPageSelected(int arg0) {
			position = arg0;

			if (position == 0) {
				Previous.setVisibility(View.INVISIBLE);
			} else {
				Previous.setVisibility(View.VISIBLE);
			}

			if (position == endPosition) {
				Next.setVisibility(View.INVISIBLE);
			} else {
				Next.setVisibility(View.VISIBLE);
			}

			if (!mp.isPlaying()) {
				mp = MediaPlayer.create(mContext, sound[arg0]);
				prepare();
				mp.start();

			} else {
				mp.stop();
				mp = MediaPlayer.create(mContext, sound[arg0]);
				prepare();
				mp.start();

			}

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}

		@Override
		public void onPageScrollStateChanged(int arg0) {

		}
	};

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		if (v == Next) {

			pager.setCurrentItem(getItem(+1), true);

		}

		if (v == Previous) {

			pager.setCurrentItem(getItem(-1), true);

		}

		if (v == Reply) {

			if (!mp.isPlaying()) {
				mp = MediaPlayer.create(mContext, sound[position]);
				prepare();
				mp.start();
			}

			else {
				mp.stop();
				mp = MediaPlayer.create(mContext, sound[position]);
				prepare();
				mp.start();
			}
		}
		if(v==center_view) {
			if (value.equals("Alphabet_word")) {
				if (!mp.isPlaying()) {
					mp = MediaPlayer.create(mContext, alphabet_spelling_sound[position]);
					prepare();
					mp.start();

				} else {
					mp.stop();
					mp = MediaPlayer.create(mContext, alphabet_spelling_sound[position]);
					prepare();
					mp.start();

				}
			}
		}

		if(v==Back) {
			getFragmentManager().popBackStack();

		}
	}


	public void prepare() {
		try {
			mp.prepare();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		mp.stop();
		super.onDestroyView();
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@SuppressLint("Recycle")
	private void loadData() {
		if (value.equals("Alphabet")) {
			sound = alphabet_word_sound;
			TypedArray images = getResources().obtainTypedArray(
					R.array.alphabet_image);
			image = new int[images.length()];

			color = getResources().getStringArray(R.array.alphabet_color);
			text = getResources().getStringArray(R.array.alphabet);
			txtSize = (int) (getResources()
					.getDimension(R.dimen.long_text_size) / getResources()
					.getDisplayMetrics().density);
			endPosition = image.length - 1;
		} else if (value.equals("Number")) {
			sound = number_sound;
			TypedArray images = getResources().obtainTypedArray(
					R.array.number_image);
			image = new int[images.length()];
			for (int y = 0; y < image.length; y++) {
				image[y] = images.getResourceId(y, 0);
			}

			color = getResources().getStringArray(R.array.number_color);
			text = getResources().getStringArray(R.array.number_name);
			txtSize = (int) (getResources().getDimension(
					R.dimen.short_text_size) / getResources()
					.getDisplayMetrics().density);
			endPosition = image.length - 1;
		} else if (value.equals("Color")) {
			sound = color_sound;
			TypedArray images = getResources().obtainTypedArray(
					R.array.color_image);
			image = new int[images.length()];
			for (int y = 0; y < image.length; y++) {
				image[y] = images.getResourceId(y, 0);
			}

			color = getResources().getStringArray(R.array.color_color);
			text = getResources().getStringArray(R.array.color_name);
			txtSize = (int) (getResources()
					.getDimension(R.dimen.long_text_size) / getResources()
					.getDisplayMetrics().density);
			endPosition = image.length - 1;
		} else if (value.equals("Alphabet_word")) {
			sound = alphabet_sound;
			TypedArray images = getResources().obtainTypedArray(
					R.array.alphabet_image);
			image = new int[images.length()];
			for (int y = 0; y < image.length; y++) {
				image[y] = images.getResourceId(y, 0);
			}

			color = getResources().getStringArray(R.array.alphabet_color);
			text = getResources().getStringArray(R.array.alphabet);
			example = getResources().getStringArray(R.array.example_name);
			// txtSize = (int) getResources()
			// .getDimension(R.dimen.short_text_size);
			txtSize = (int) (getResources().getDimension(
					R.dimen.short_text_size) / getResources()
					.getDisplayMetrics().density);
			endPosition = image.length - 1;
		}
	}

}
