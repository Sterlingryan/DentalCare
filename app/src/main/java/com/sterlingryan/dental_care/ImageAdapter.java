package com.sterlingryan.dental_care;


        import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ImageAdapter extends BaseAdapter{

    String [] result;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;
    public ImageAdapter(Dashboard mainActivity, String[] prgmNameList, int[] prgmImages) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        context=mainActivity;
        imageId=prgmImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.programlist, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textView1);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView1);

        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);

        rowView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                //Intent intent = new Intent();
                String feature;
                switch(position)
                {
                    case 0 :

                        Intent InformationIntent = new Intent(v.getContext(), InformationMenu.class); //v.getContext() instead of this?
                        ActivityCompat.startActivity((Activity) context, InformationIntent, null);
                        break;

                    case 1 :

                        Intent AppointmentLogbookIntent = new Intent(v.getContext(), AppointmentLogbook.class); //v.getContext() instead of this?
                        ActivityCompat.startActivity((Activity) context, AppointmentLogbookIntent, null);
                        break;

                    case 2 :

                        Intent BrushYourTeethIntent = new Intent(v.getContext(), BrushYourTeeth.class); //v.getContext() instead of this?
                        ActivityCompat.startActivity((Activity) context, BrushYourTeethIntent, null);
                        break;

                    case 3:
                        Intent SmokingIntent = new Intent(v.getContext(), Smoking_Input.class); //v.getContext() instead of this?
                        ActivityCompat.startActivity((Activity) context, SmokingIntent, null);
                        break;

                    case 4:
                        Intent VideosIntent= new Intent(v.getContext(), VideoSection.class); //v.getContext() instead of this?
                        ActivityCompat.startActivity((Activity) context, VideosIntent, null);
                        break;
                }
                Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
            }
        });

        return rowView;
    }

}