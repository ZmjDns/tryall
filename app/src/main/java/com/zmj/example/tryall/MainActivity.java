package com.zmj.example.tryall;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zmj.example.tryall.fragment.FragmentOne;
import com.zmj.example.tryall.fragment.FragmentTwo;
import com.zmj.example.tryall.ui.DataAnsis;
import com.zmj.example.tryall.ui.Lunbotu;
import com.zmj.example.tryall.ui.MainAct;
import com.zmj.example.tryall.ui.TestHttpurlConnAct;
import com.zmj.example.tryall.ui.TestRetrofitAct;
import com.zmj.example.tryall.ui.TextInText;
import com.zmj.example.tryall.ui.ViewPagerFgAct;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	private Button ui_mainAct,ui_TextInText,ui_ViewPagerFgAct,ui_Lunbotu,testHttpurl,
	btn_Dataanalysis,btn_TestRetrofit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_main);

		ui_mainAct = findViewById(R.id.ui_mainAct);
		ui_TextInText = findViewById(R.id.ui_TextInText);
		ui_ViewPagerFgAct = findViewById(R.id.ui_ViewPagerFgAct);
		ui_Lunbotu = findViewById(R.id.ui_Lunbotu);
		btn_Dataanalysis = findViewById(R.id.btn_Dataanalysis);
		btn_TestRetrofit = findViewById(R.id.btn_TestRetrofit);

		testHttpurl = findViewById(R.id.testHttpurl);

		ui_mainAct.setOnClickListener(this);
		ui_TextInText.setOnClickListener(this);
		ui_ViewPagerFgAct.setOnClickListener(this);
		ui_Lunbotu.setOnClickListener(this);
		testHttpurl.setOnClickListener(this);
		btn_Dataanalysis.setOnClickListener(this);
		btn_TestRetrofit.setOnClickListener(this);

		//getScreenWHshowFg();
		//testResolver();
	}
	//ContentProvider往另外一个APP中写入数据
	private void testResolver(){
		final ContentResolver resolver = this.getContentResolver();

		ContentValues values = new ContentValues();

		values.put("name","测试");
		Uri uri = Uri.parse("content://com.android.szkl.remoteserviceclient.contentprovider.NameContentProvider/testContentProvider");

		resolver.insert(uri,values);

		Toast.makeText(getApplicationContext(), "数据插入成功", Toast.LENGTH_SHORT).show();
	}

	//获取屏幕宽高显示Fragment
	private void getScreenWHshowFg(){
		//获取屏幕宽高
//		Display dis = getWindowManager().getDefaultDisplay();
//		Point size = new Point();
//		dis.getSize(size);
//		int width = size.x;
//		int heiht = size.y;
		//或者
		DisplayMetrics mertrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(mertrics);
		int width1 = mertrics.widthPixels;
		int height1 = mertrics.heightPixels;

		if(width1 < height1){
			FragmentOne fragmentOne = new FragmentOne();
			getFragmentManager().beginTransaction().replace(R.id.liner1,fragmentOne).commit();
		}else {
			FragmentTwo fragmentTwo = new FragmentTwo();
			getFragmentManager().beginTransaction().replace(R.id.liner2,fragmentTwo).commit();
		}
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()){
			case R.id.ui_mainAct:
				startActivity(new Intent(this, MainAct.class));
				break;
			case R.id.ui_TextInText:
				startActivity(new Intent(this, TextInText.class));
				break;
			case R.id.ui_ViewPagerFgAct:
				startActivity(new Intent(this, ViewPagerFgAct.class));
				break;
			case R.id.ui_Lunbotu:
				startActivity(new Intent(this, Lunbotu.class));
				break;
			case R.id.testHttpurl:
				startActivity(new Intent(this, TestHttpurlConnAct.class));
				break;
			case R.id.btn_Dataanalysis:
				startActivity(new Intent(this, DataAnsis.class));
				break;
			case R.id.btn_TestRetrofit:
				startActivity(new Intent(this, TestRetrofitAct.class));
				break;
			default:
				break;
		}
	}
}
