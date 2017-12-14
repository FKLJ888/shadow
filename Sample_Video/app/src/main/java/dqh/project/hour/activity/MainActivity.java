package dqh.project.hour.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;
import java.util.List;

import dqh.project.hour.R;
import dqh.project.hour.fragment.MyFragment;
import dqh.project.hour.fragment.SpecialFragment;
import dqh.project.hour.fragment.FancyFragment;
import dqh.project.hour.fragment.FoundFragment;

//底部导航栏
//compile 'com.ashokvarma.android:bottom-navigation-bar:2.0.2'
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView home_title;
    private ImageView home_edit;
    private BottomNavigationBar main_footer;
    private FrameLayout main_frame;

    private List<Fragment> fragments;

    private FoundFragment tuijianFragment;
    private SpecialFragment duanziFragment;
    private FancyFragment shipinFragment;

    private int tag=0;
    private MyFragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        createView();
    }

    private void createView() {
        initBottomNavigationBar();
    }

    private void initData() {
        fragments = new ArrayList<>();
        tuijianFragment = new FoundFragment();
        duanziFragment = new SpecialFragment();
        shipinFragment = new FancyFragment();
        myFragment = new MyFragment();

        fragments.add(tuijianFragment);
        fragments.add(duanziFragment);
        fragments.add(shipinFragment);
        fragments.add(myFragment);
    }

    private void initView() {
        home_title = (TextView) findViewById(R.id.home_title);
        home_edit = (ImageView) findViewById(R.id.home_edit);
        home_edit.setOnClickListener(this);
        main_footer = (BottomNavigationBar) findViewById(R.id.main_footer);
        main_frame = (FrameLayout) findViewById(R.id.main_frame);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_edit:
                //创作页面
                break;
        }
    }


    /**
     * 初始化 底部导航栏
     */
    private void initBottomNavigationBar() {
        //设置显示模式 ：普通模式
        main_footer.setMode(BottomNavigationBar.MODE_SHIFTING);
        //设置背景风格 ：背景颜色波纹改变
        main_footer.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);

        //初始化 子导航页
        BottomNavigationItem recommendItem = new BottomNavigationItem(R.mipmap.found, "精选");
        BottomNavigationItem crossTalkItem = new BottomNavigationItem(R.mipmap.special, "专题");
        BottomNavigationItem videoItem = new BottomNavigationItem(R.mipmap.fancy, "发现");
        BottomNavigationItem my = new BottomNavigationItem(R.mipmap.my, "发现");

        //添加子导航页
        main_footer.addItem(recommendItem);
        main_footer.addItem(crossTalkItem);
        main_footer.addItem(videoItem);
        main_footer.addItem(my);
        //设置默认选中条目
        main_footer.setFirstSelectedPosition(0);
        //未活动 图标颜色
        main_footer.setInActiveColor(R.color.dimgrey);
        //活动时 图标颜色
        main_footer.setActiveColor(R.color.red);
        //初始化
        main_footer.initialise();

        home_title.setText("推荐");

        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_frame, fragments.get(0))
                .add(R.id.main_frame, fragments.get(1))
                .add(R.id.main_frame, fragments.get(2))
                .add(R.id.main_frame, fragments.get(3))
                .hide(fragments.get(1))
                .hide(fragments.get(2))
                .hide(fragments.get(3))
                .commitAllowingStateLoss();

        /**
         * BottomNavigationBar 点击监听
         */
        main_footer.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                switch (position) {
                    case 0:
                        home_title.setText("精选");
                        break;
                    case 1:
                        home_title.setText("专题");
                        break;
                    case 2:
                        home_title.setText("发现");
                        break;
                    case 3:
                        home_title.setText("我的");
                        break;
                }

                if (tag != position) {
                    getSupportFragmentManager().beginTransaction()
                            .show(fragments.get(position))
                            .hide(fragments.get(tag))
                            .commitAllowingStateLoss();
                    tag = position;
                }
            }
            @Override
            public void onTabUnselected(int position) {
            }
            @Override
            public void onTabReselected(int position) {
            }
        });
    }
}
