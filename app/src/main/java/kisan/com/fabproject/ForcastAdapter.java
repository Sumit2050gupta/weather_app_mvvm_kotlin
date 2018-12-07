package kisan.com.fabproject;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hp on 07-12-2018.
 */

public class ForcastAdapter extends RecyclerView.Adapter<ForcastAdapter.ViewHolder> {
    List<ForcastModel> list;
    public ForcastAdapter(List<ForcastModel> list){
    this.list = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.forcast_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       holder.condition.setText(list.get(position).getCondition());
       holder.date.setText(list.get(position).getDate());
       holder.temp.setText(list.get(position).getMinT() + "/" + list.get(position).getMaxT());
       switch (list.get(position).getConditionCode()){
           case 1003:
               holder.imageView.setImageResource(R.drawable.clouds);
               break;
           default:
               holder.imageView.setImageResource(R.drawable.clear);

       }
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView date;
        TextView temp;
        TextView condition;
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            init(itemView);
        }

        private void init(View itemView) {
            date = itemView.findViewById(R.id.date);
            temp = itemView.findViewById(R.id.temp);
            condition = itemView.findViewById(R.id.condition);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
