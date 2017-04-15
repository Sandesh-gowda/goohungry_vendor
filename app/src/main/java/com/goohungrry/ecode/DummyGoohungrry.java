package com.goohungrry.ecode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

public class DummyGoohungrry extends AppCompatActivity {
    public SimpleDraweeView foodImage,foodType;
    TextView foodTitle,foodDescription,cost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_card
        );

     /*   Uri nonveg = Uri.parse("http://52.66.31.77/lobo/banners/ic_non_veg.png");
        Uri imageUri = Uri.parse("http://hyderabadbiryanihouseca.com/img/img06.jpg");
        cost = (TextView) findViewById(R.id.tvErrMsg);
        foodType = (SimpleDraweeView) findViewById(R.id.iv_foodTypeProductConcise);
        foodTitle = (TextView) findViewById(R.id.tv_product_title_productCoincise);
        foodDescription = (TextView) findViewById(R.id.tv_product_discription_productConcise);
        foodImage = (SimpleDraweeView) findViewById(R.id.product_image);
        foodImage.setVisibility(View.VISIBLE);
foodImage.setImageURI(imageUri);
        foodType.setImageURI(nonveg);
        cost.setText("₹500");
        foodTitle.setText("Hungry Biriyani");*/


    }
}
