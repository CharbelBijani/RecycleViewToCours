package com.example.recycleviewtocours;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerViewHolder extends RecyclerView.ViewHolder {

    TextView stagiaire, description;
    ImageView avatar;
    ConstraintLayout mainLayout;

    public MyRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        /** Le contenu **/
        stagiaire = itemView.findViewById(R.id.tv_stagiaireHorizontal);
        description = itemView.findViewById(R.id.tv_desc);
        avatar = itemView.findViewById(R.id.iv_avatarHorizontal);
        /** Le contenant **/
        mainLayout = itemView.findViewById(R.id.mainLayoutHorizontal);
    }
}

