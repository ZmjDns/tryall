package com.zmj.example.tryall.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zmj.example.tryall.R;

/**
 * Created by ZMJ
 * on 2018/7/10
 */
public class MyFragment1 extends android.support.v4.app.Fragment {

	public MyFragment1() {
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fg_content,container,false);
		TextView textView = view.findViewById(R.id.txt_content);
		textView.setText("第一个Fragment");
		return view;
	}
}
