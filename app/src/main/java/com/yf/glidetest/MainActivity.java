package com.yf.glidetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class MainActivity extends AppCompatActivity {
private ImageView image1,image2,image3,image4,image5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image1= (ImageView) findViewById(R.id.img1);
        image2= (ImageView) findViewById(R.id.img2);
        image3= (ImageView) findViewById(R.id.img3);
        image4= (ImageView) findViewById(R.id.img4);
        image5= (ImageView) findViewById(R.id.img5);
        String url = "http://avatar.csdn.net/9/7/A/1_zhangphil.jpg";
        //原图，

        Glide.with(this).load(url).crossFade(1000).into(image1);

        //原图 -> 圆图

        Glide.with(this).load(url).bitmapTransform(new CustomShapeTransformation(this,R.drawable.mysystem)).crossFade(1000).into(image2);

        //原图的毛玻璃、高斯模糊效果

        Glide.with(this).load(url).bitmapTransform(new BlurTransformation(this, 25)).crossFade(1000).into(image3);

        //原图基础上复合变换成圆图 +毛玻璃（高斯模糊）

        Glide.with(this).load(url).bitmapTransform(new BlurTransformation(this, 25), new CropCircleTransformation(this)).crossFade(1000).into(image4);

        //原图处理成圆角，如果是四周都是圆角则是RoundedCornersTransformation.CornerType.ALL

        Glide.with(this).load(url).bitmapTransform(new RoundedCornersTransformation(this, 30, 0, RoundedCornersTransformation.CornerType.BOTTOM)).crossFade(1000).into(image5);
    }
}
