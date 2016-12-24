package com.simon.app;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;


@SuppressWarnings("deprecation")
public class ActHome extends TabActivity {
	private TabHost mTabHost;
	private LayoutInflater mInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.act_home);
        
        mInflater = LayoutInflater.from(this);
        
        mTabHost = getTabHost();
        mTabHost.addTab(tabMyDouban());
        mTabHost.addTab(tabNewbook());
        mTabHost.addTab(tabBookReview());
        mTabHost.addTab(tabSearch());
        mTabHost.addTab(tabAbout());
        
        //设置默认显示当前tab
        mTabHost.setCurrentTabByTag("myDouban");
    }
    
    //生成我的豆瓣tab item 
    private TabSpec tabMyDouban(){
    	TabSpec spec = mTabHost.newTabSpec("myDouban");
    	//指定标签显示的内容，激活的Activity对应的对象
    	Intent intent = new Intent(this, ActMyDouban.class);
    	spec.setContent(intent);
    	//设置标签的文字和样式
    	spec.setIndicator(genTabItemView("我的豆瓣",R.drawable.tab_main_nav_me));
    	return spec;
    }
    
  //生成我的豆瓣tab item 
    private TabSpec tabNewbook(){
    	TabSpec spec = mTabHost.newTabSpec("newBook");
    	//指定标签显示的内容，激活的Activity对应的对象
    	Intent intent = new Intent(this, ActNewbook.class);
    	spec.setContent(intent);
    	//设置标签的文字和样式
    	spec.setIndicator(genTabItemView("新书",R.drawable.tab_main_nav_book));
    	return spec;
    }
    
  //生成我的豆瓣tab item 
    private TabSpec tabBookReview(){
    	TabSpec spec = mTabHost.newTabSpec("bookReview");
    	//指定标签显示的内容，激活的Activity对应的对象
    	Intent intent = new Intent(this, ActBookReview.class);
    	spec.setContent(intent);
    	//设置标签的文字和样式
    	spec.setIndicator(genTabItemView("书评",R.drawable.detail_comment_selected));
    	return spec;
    }
    
    //生成我的豆瓣tab item 
    private TabSpec tabSearch(){
    	TabSpec spec = mTabHost.newTabSpec("serach");
    	//指定标签显示的内容，激活的Activity对应的对象
    	Intent intent = new Intent(this, ActSearch.class);
    	spec.setContent(intent);
    	//设置标签的文字和样式
    	spec.setIndicator(genTabItemView("搜索",R.drawable.tab_main_nav_search));
    	return spec;
    }
    
  //生成我的豆瓣tab item 
    private TabSpec tabAbout(){
    	TabSpec spec = mTabHost.newTabSpec("serach");
    	//指定标签显示的内容，激活的Activity对应的对象
    	Intent intent = new Intent(this, ActAbout.class);
    	spec.setContent(intent);
    	//设置标签的文字和样式
    	spec.setIndicator(genTabItemView("关于",R.drawable.tab_main_nav_more));
    	return spec;
    }

    //组装每个Icon视图View
	private View genTabItemView(String tabItemTitle, int tabItemIcon) {
		View view = mInflater.inflate(R.layout.tab_bar_item, null);
		ImageView ivIcon = (ImageView) view.findViewById(R.id.ivTabItemIcon);
		TextView tvTitle = (TextView) view.findViewById(R.id.tvTabItemTitle);
		
		ivIcon.setImageResource(tabItemIcon);
		tvTitle.setText(tabItemTitle);
		return view;
	}

}
