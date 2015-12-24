package demo.calligraphy.com.calligraphy4mycustomview.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import demo.calligraphy.com.calligraphy4mycustomview.R;

/**
 * Created by Administrator on 2015/12/24 0024.
 */
public class TopBar extends LinearLayout {
    private Context mContext;

    private TextView mTitileTextView;
    private ImageView mLeftImageView;

    private String mTitleText;//中间的文字
    private float mTitleSize;//中间文字的大小
    private int mTitleColor;//中间文字的颜色
    private int mTitleFamily;//中间文字的字体

    private boolean mLeftIconEnable;//是否显示左边图片
    private int mLeftIcon;//左边图片

    public TopBar(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (attrs == null) {
            return;
        }
        mContext = context;

        TypedArray ta = context.getTheme().obtainStyledAttributes(attrs, R.styleable.TopBar, 0, 0);

        try {
            mTitleText = ta.getString(R.styleable.TopBar_titleText);
            mTitleSize = ta.getDimension(R.styleable.TopBar_titleSize, 24);
            mTitleColor = ta.getColor(R.styleable.TopBar_titleColor, 0xffffffff);
            mTitleFamily = ta.getResourceId(R.styleable.TopBar_titleFamily, R.style.custom_font_bold);//this

            mLeftIconEnable = ta.getBoolean(R.styleable.TopBar_leftIconEnable, true);
            mLeftIcon = ta.getResourceId(R.styleable.TopBar_leftIcon, R.mipmap.get_back);
        } finally {
            ta.recycle();
        }

        init();
    }

    private void init() {
        LayoutInflater.from(mContext).inflate(R.layout.custom_topbar, this, true);
        mTitileTextView = (TextView) findViewById(R.id.tv_custom_topbar_title);
        mLeftImageView = (ImageView) findViewById(R.id.iv_custom_topbar_lefticon);

        mTitleText = (mTitleText == null) ? "" : mTitleText;
        mTitileTextView.setText(mTitleText);
        if (mTitleSize > 0) {
            mTitileTextView.setTextSize(mTitleSize);
        }
        mTitileTextView.setTextColor(mTitleColor);
        mTitileTextView.setTextAppearance(mContext, mTitleFamily);//this
        // mTitleFamily don't work

        mLeftImageView.setVisibility(mLeftIconEnable ? View.VISIBLE : View.GONE);
        mLeftImageView.setImageResource(mLeftIcon);
    }
}
