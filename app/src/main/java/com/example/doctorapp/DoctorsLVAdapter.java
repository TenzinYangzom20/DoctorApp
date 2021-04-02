package com.example.doctorapp;

import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;


        import com.squareup.picasso.Picasso;

        import java.util.ArrayList;

public class DoctorsLVAdapter extends ArrayAdapter<DoctorAvailable> {

    // constructor for our list view adapter.
    public DoctorsLVAdapter(@NonNull Context context, ArrayList<DoctorAvailable> doctorArrayList) {
        super(context, 0, doctorArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // below line is use to inflate the
        // layout for our item of list view.
        View listitemView = convertView;
        if (listitemView == null) {
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.image_lv_item, parent, false);
        }

        // after inflating an item of listview item
        // we are getting data from array list inside
        // our modal class.
        DoctorAvailable doctorAvailable = getItem(position);

        // initializing our UI components of list view item.
        TextView nameTV = listitemView.findViewById(R.id.idTVtext);
        TextView emailTV = listitemView.findViewById(R.id.idTVtext1);
        TextView specialitiesTV = listitemView.findViewById(R.id.idTVtext2);
        TextView experienceTV = listitemView.findViewById(R.id.idTVtext3);
        ImageView docIV = listitemView.findViewById(R.id.idIVimage);

        // after initializing our items we are
        // setting data to our view.
        // below line is use to set data to our text view.
        nameTV.setText(doctorAvailable.getDocName());
        emailTV.setText(doctorAvailable.getDocEmail());
        specialitiesTV.setText(doctorAvailable.getDocSpecialities());
        experienceTV.setText(doctorAvailable.getDocExperience());
        // in below line we are using Picasso to
        // load image from URL in our Image VIew.
        Picasso.get().load(doctorAvailable.getImgUrl()).into(docIV);

        // below line is use to add item click listener
        // for our item of list view.
        listitemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on the item click on our list view.
                // we are displaying a toast message.
                Toast.makeText(getContext(), "Item clicked is : " + doctorAvailable.getDocName(), Toast.LENGTH_SHORT).show();
            }
        });
        return listitemView;
    }

}
