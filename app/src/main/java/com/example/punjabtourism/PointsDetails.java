package com.example.punjabtourism;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PointsDetails extends AppCompatActivity {
    ImageView pointImage;
    TextView pointDetail;
    String name = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points_details);

        pointImage = findViewById(R.id.imgPoint);
        pointDetail = findViewById(R.id.txtDetail);

        name = getIntent().getStringExtra("point");
        setDetails();
    }
    public void setDetails(){

        if(name.equals("lahore")){
            pointImage.setImageResource(R.drawable.lahore);
            pointDetail.setText("Lahore remains a major tourist destination in Pakistan. The Walled City of Lahore was renovated in 2014 and is popular due to the presence of UNESCO World Heritage Sites. Among the most popular sights are the Lahore Fort, adjacent to the Walled City, and home to the Sheesh Mahal, the Alamgiri Gate, the Naulakha pavilion, and the Moti Masjid. The fort along with the adjoining Shalimar Gardens has been a UNESCO World Heritage Site since 1981");
        } else if(name.equals("bahawalpur")){
            pointImage.setImageResource(R.drawable.bahawalpur);
            pointDetail.setText("In the United India, Bahawalpur was called the Rajputana State which is now Rajhistan in India. The city is renowned for its many famous palaces which include the likes of Noor Mahal, Darbar Mahal, Sadiq Ghar Palace, as well as an ancient fort, Fort of Derawar located in the Cholistan Desert and bordering India.");
        } else if(name.equals("multan")){
            pointImage.setImageResource(R.drawable.multan);
            pointDetail.setText("Multan is famous for its large number of Sufi shrines, including the unique rectangular tomb of Shah Gardez that dates from the 1150s and is covered in blue enameled tiles typical of Multan. The shrine of Shamsuddin Sabzwari dates from 1330, and has a unique green dome.");
        } else if(name.equals("sialkot")){
            pointImage.setImageResource(R.drawable.sialkot);
            pointDetail.setText("Sialkot is a quietly industrious city with a curiously friendly populace. It is the 13th largest city located in Punjab, Pakistan. Sialkot is a place where history lives. This city is green, beautiful, clean, and well maintained. The people of Sialkot are loving and beautiful and it is one of the best things about this city.");
        } else if(name.equals("islamabad")){
            pointImage.setImageResource(R.drawable.islamabad);
            pointDetail.setText("Faisal Mosque is an important cultural landmark of the city and that attracts many tourists daily. Faisal Mosque built in 1986, was named after the Saudi Arabian King, Faisal bin Abdul Aziz. It also serves the purpose of accommodating 24,000 Muslims that pray at this mosque. Faisal Mosque that is designed by the Turks and financed by the Kingdom of Saudi Arabia includes calligraphy of Quranic Versus along the walls of the mosque.");
        } else if(name.equals("faisalabad")){
            pointImage.setImageResource(R.drawable.faisalabad);
            pointDetail.setText("Faisalabad is the third largest city of Pakistan after Karachi and Lahore. The city is famous for it exports in Textiles, furniture, and starch. It has one of the largest agriculture university of the world. Gutwala Forest, Jinah Park and Canal Park are among a few resorts for recreation.");
        } else if(name.equals("taxila")){
            pointImage.setImageResource(R.drawable.taxila);
            pointDetail.setText("Taxila is most famous for ruins of several settlements, the earliest dating from around 1000 BCE. It is also known for its collection of Buddhist religious monuments, including the Dharmarajika stupa, the Jaulian monastery, and the Mohra Muradu monastery.");
        } else if(name.equals("kasur")){
            pointImage.setImageResource(R.drawable.kasur);
            pointDetail.setText("Kasur is a small place in Pakistan and can be easily explored within a day. There aren’t many things to do and attractions to visit in this town. Also, being a small town, there are fewer accommodation options. People usually consider making a quick stop here before heading to the neighboring cities. You can halt here for a quick snack and take a little break from your journey.");
        }
    }

}