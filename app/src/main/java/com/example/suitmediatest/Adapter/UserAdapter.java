package com.example.suitmediatest.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suitmediatest.Interface.RecyclerViewInterface;
import com.example.suitmediatest.Model.UserModel;
import com.example.suitmediatest.R;
import com.example.suitmediatest.Screen3Activity;
import com.squareup.picasso.Picasso;

import java.net.URI;
import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private Context context;
    private ArrayList<UserModel> UserList;
    private final RecyclerViewInterface recyclerViewInterface;

    public UserAdapter(Context context, ArrayList<UserModel> UserList, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.UserList = UserList;
        this.recyclerViewInterface = recyclerViewInterface;
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view, recyclerViewInterface);

    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        UserModel User = UserList.get(position);
        holder.tvFirstName.setText(User.getFirstName());
        holder.tvLastName.setText(User.getLastName());
        holder.tvEmail.setText(User.getEmail());

        try {
            holder.img.setImageURI(User.getImg());

        } catch (Exception e) {
            e.printStackTrace();
            // Handle error
        }
        //Picasso.get().load(User.getImg()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return UserList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        LinearLayout UserLayout;
        TextView tvFirstName, tvLastName,tvEmail;
        ImageView img;

        public UserViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            tvFirstName = itemView.findViewById(R.id.tvFirstName);
            tvLastName = itemView.findViewById(R.id.tvLastName);
            tvEmail = itemView.findViewById(R.id.tvEmailAPI);
            img = itemView.findViewById(R.id.ivProfile);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(recyclerViewInterface != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(position);
                        }
                    }
                }
            });
        }

    }

}
