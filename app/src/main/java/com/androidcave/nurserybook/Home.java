package com.androidcave.nurserybook;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Home extends Fragment implements OnClickListener {

	private ImageView btn_Alphabet, btn_Number, btn_Color, btn_Alphabet_word, btn_Rate;
	private View HomeFragment;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		HomeFragment = inflater.inflate(R.layout.activity_main, container,
				false);
		initUI();
		return HomeFragment;
	}

	private void initUI() {
		// TODO Auto-generated method stub
		btn_Alphabet = (ImageView) HomeFragment
				.findViewById(R.id.button_alphabet);
		btn_Number = (ImageView) HomeFragment.findViewById(R.id.button_number);
		btn_Color = (ImageView) HomeFragment.findViewById(R.id.color);
		btn_Alphabet_word = (ImageView) HomeFragment.findViewById(R.id.alphabet_word);
		btn_Rate = (ImageView) HomeFragment.findViewById(R.id.rate);

		btn_Alphabet.setOnClickListener(this);
		btn_Number.setOnClickListener(this);
		btn_Color.setOnClickListener(this);
		btn_Alphabet_word.setOnClickListener(this);
		btn_Rate.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		if (v == btn_Alphabet) {
			Bundle bundle = new Bundle();
			bundle.putString("value", "Alphabet");
			Main Alphabet = new Main();
			Alphabet.setArguments(bundle);
			((BaseContainerFragment) getParentFragment()).replaceFragment(
					Alphabet, true);
		}

		if (v == btn_Number) {
			Bundle bundle = new Bundle();
			bundle.putString("value", "Number");
			Main Number = new Main();
			Number.setArguments(bundle);
			((BaseContainerFragment) getParentFragment()).replaceFragment(
					Number, true);
		}

		if (v == btn_Color) {
			Bundle bundle = new Bundle();
			bundle.putString("value", "Color");
			Main Color = new Main();
			Color.setArguments(bundle);
			((BaseContainerFragment) getParentFragment()).replaceFragment(
					Color, true);
		}
		if (v == btn_Alphabet_word) {
			Bundle bundle = new Bundle();
			bundle.putString("value", "Alphabet_word");
			Main Alphabet_word = new Main();
			Alphabet_word.setArguments(bundle);
			((BaseContainerFragment) getParentFragment()).replaceFragment(
					Alphabet_word, true);
		}

		if (v == btn_Rate) {
			final String appPackageName = getActivity().getPackageName();
			try {
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
			} catch (android.content.ActivityNotFoundException anfe) {
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + appPackageName)));
			}
		}

	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
	}
}
