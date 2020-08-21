package com.example.onsite4;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    Context context;
    List<NameClass> nameClassList;
    List<NameClass> nameSubClassList = new ArrayList<>();
    private RecyclerView.Adapter adapter;
    boolean subDivision = true;

    public MainAdapter(Context context, List<NameClass> nameClassList) {
        this.context = context;
        this.nameClassList = nameClassList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_card_view , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        final NameClass nameClass = nameClassList.get(position);
        holder.nameOfFile.setText(nameClass.getNameOfFile());

//        File path = new File(nameClass.getPath());
//        File list[] = path.listFiles();

        holder.nameOfFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.rw1.getVisibility() == View.VISIBLE) {
                    holder.rw1.setVisibility(View.GONE);
                    holder.nameOfFile.setCompoundDrawablesWithIntrinsicBounds(R.drawable.right_arrow, 0, 0, 0);
                }else {
                    holder.rw1.setVisibility(View.VISIBLE);
                    holder.nameOfFile.setCompoundDrawablesWithIntrinsicBounds(R.drawable.down_arrow, 0, 0, 0);

                    File path = new File(nameClass.getPath());
                    File list[] = path.listFiles();
                    nameSubClassList.clear();
                    try {
                        for (File file : list) {
                            Log.i("bhai ka nam", file.getName());
                            String filePath = nameClass.getPath() + "/" + file.getName();

                            NameClass nameSubClass = new NameClass(file.getName(), filePath , false);

                            nameSubClassList.add(nameSubClass);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    holder.rw1.setHasFixedSize(true);
                    holder.rw1.setLayoutManager(new LinearLayoutManager(context));
                    adapter = new MainAdapter(context , nameSubClassList);
                    holder.rw1.setAdapter(adapter);
                }
            }
        });

//        try {
//            for (File file : list) {
//                Log.i("bhai ka nam", file.getName());
//                String filePath = nameClass.getPath() + "/" + file.getName();
//
//                NameClass nameSubClass = new NameClass(file.getName(), filePath , false);
//
//                nameSubClassList.add(nameSubClass);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        holder.rw1.setHasFixedSize(true);
//        holder.rw1.setLayoutManager(new LinearLayoutManager(context));
//        adapter = new MainAdapter(context , nameSubClassList);
//        holder.rw1.setAdapter(adapter);

    }

    @Override
    public int getItemCount() {
        return nameClassList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RecyclerView rw1;
        TextView nameOfFile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rw1 = itemView.findViewById(R.id.rw1);
            nameOfFile = itemView.findViewById(R.id.nameOfFile);

        }
    }
}
