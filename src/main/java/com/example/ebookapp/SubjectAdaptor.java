package com.example.ebookapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SubjectAdaptor extends RecyclerView.Adapter<SubjectAdaptor.viewHolder> {

    Context context;
    ArrayList<SubjectModel> list;

    public SubjectAdaptor(Context context, ArrayList<SubjectModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_subject, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        SubjectModel model= list.get(position);

        holder.subjectName.setText(model.getSubjectName());


    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView subjectName;
      public viewHolder(@NonNull View itemView) {
          super(itemView);
          subjectName  =itemView.findViewById(R.id.beginner);
      }
  }

}
