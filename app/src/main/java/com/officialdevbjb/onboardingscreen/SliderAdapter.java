package com.officialdevbjb.onboardingscreen;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {

        this.context = context;

    }

    // Arrays
    public int[] slide_images = {

      R.drawable.eat_icon,
      R.drawable.sleep_icon,
      R.drawable.code_icon
    };

    public String[] slide_headings = {

            "EAT",
            "SLEEP",
            "CODE"
    };

    public String[] slide_descs = {

            "Makan Adalah Kewajiban Kita Untuk Bertahan Hidup " + "Maka Kita Harus Makan",
            "Tidur Adalah Kewajiban Kita Untuk Mengistirahatkan Tubuh " + "Maka Kita Harus Tidur",
            "Ngoding Adalah Kewajiban Kita Untuk Mengembangkan Diri " + "Maka Kita Harus Ngoding :D"

    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == (RelativeLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((RelativeLayout)object);

    }
}