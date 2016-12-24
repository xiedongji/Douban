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
        
        //����Ĭ����ʾ��ǰtab
        mTabHost.setCurrentTabByTag("newBook");
    }
    
    //�����ҵĶ���tab item 
    private TabSpec tabMyDouban(){
    	TabSpec spec = mTabHost.newTabSpec("myDouban");
    	//ָ����ǩ��ʾ�����ݣ������Activity��Ӧ�Ķ���
    	Intent intent = new Intent(this, ActMyDouban.class);
    	spec.setContent(intent);
    	//���ñ�ǩ�����ֺ���ʽ
    	spec.setIndicator(genTabItemView("�ҵĶ���",R.drawable.tab_main_nav_me));
    	return spec;
    }
    
  //�����ҵĶ���tab item 
    private TabSpec tabNewbook(){
    	TabSpec spec = mTabHost.newTabSpec("newBook");
    	//ָ����ǩ��ʾ�����ݣ������Activity��Ӧ�Ķ���
    	Intent intent = new Intent(this, ActNewbook.class);
    	spec.setContent(intent);
    	//���ñ�ǩ�����ֺ���ʽ
    	spec.setIndicator(genTabItemView("����",R.drawable.tab_main_nav_book));
    	return spec;
    }
    
  //�����ҵĶ���tab item 
    private TabSpec tabBookReview(){
    	TabSpec spec = mTabHost.newTabSpec("bookReview");
    	//ָ����ǩ��ʾ�����ݣ������Activity��Ӧ�Ķ���
    	Intent intent = new Intent(this, ActBookReview.class);
    	spec.setContent(intent);
    	//���ñ�ǩ�����ֺ���ʽ
    	spec.setIndicator(genTabItemView("����",R.drawable.detail_comment_selected));
    	return spec;
    }
    
    //�����ҵĶ���tab item 
    private TabSpec tabSearch(){
    	TabSpec spec = mTabHost.newTabSpec("serach");
    	//ָ����ǩ��ʾ�����ݣ������Activity��Ӧ�Ķ���
    	Intent intent = new Intent(this, ActSearch.class);
    	spec.setContent(intent);
    	//���ñ�ǩ�����ֺ���ʽ
    	spec.setIndicator(genTabItemView("����",R.drawable.tab_main_nav_search));
    	return spec;
    }
    
  //�����ҵĶ���tab item 
    private TabSpec tabAbout(){
    	TabSpec spec = mTabHost.newTabSpec("serach");
    	//ָ����ǩ��ʾ�����ݣ������Activity��Ӧ�Ķ���
    	Intent intent = new Intent(this, ActAbout.class);
    	spec.setContent(intent);
    	//���ñ�ǩ�����ֺ���ʽ
    	spec.setIndicator(genTabItemView("����",R.drawable.tab_main_nav_more));
    	return spec;
    }

    //��װÿ��Icon��ͼView
	private View genTabItemView(String tabItemTitle, int tabItemIcon) {
		View view = mInflater.inflate(R.layout.tab_bar_item, null);
		ImageView ivIcon = (ImageView) view.findViewById(R.id.ivTabItemIcon);
		TextView tvTitle = (TextView) view.findViewById(R.id.tvTabItemTitle);
		
		ivIcon.setImageResource(tabItemIcon);
		tvTitle.setText(tabItemTitle);
		return view;
	}

}
