package com.example.recycleviewtocours.recycler_vertical;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleviewtocours.R;
import com.example.recycleviewtocours.SecondeActivity;


public class MyRecyclerAdapterVertical extends RecyclerView.Adapter<MyRecyclerViewHolderVertical> {

    /**
     * Atributs globaux attentions aux S se sont les tableaux ;)
     **/
    String stagiaires[], descs[];
    int avatars[];
    Context context;

    /**
     * Constructeur avec 4 paramètres le contexte, et les 3 tableaux : stagiaires, descs et les avatars
     **/
    public MyRecyclerAdapterVertical(Context context, String[] stagiaires, String[] descs, int[] avatars) {
        this.context = context;
        this.stagiaires = stagiaires;
        this.descs = descs;
        this.avatars = avatars;
    }

    /**
     * Méthodes ajoutées automatiquement lors de la création de la classe
     **/
    @NonNull
    @Override
    public MyRecyclerViewHolderVertical onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /* Création du layout inflater dans le context où il est créé */
        LayoutInflater inflater = LayoutInflater.from(context);
        /* on va remplir layout avec notre custom layout 3 params
         * le fichier layout // la vue parent // à false pour ne pas être attaché à son parent
         *  On va insérer cette inflater dans une view **/
        View view = inflater.inflate(R.layout.item_recycler_vertical, parent, false);
        /* comme ça on peut renvoyer la nouvelle vue - il faut l'instancier la vue en paramètre de
         * MyRecyclerViewHolder vue que l'on est dans la méthode du MyRecyclerViewHolder**/
        return new MyRecyclerViewHolderVertical(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewHolderVertical holder, int position) {
        /* On utilise object holder qui hérite de MyRecyclerViewHolder pour peupler nos items **/
        /* Aojut du texte **/
        holder.stagiaire.setText(stagiaires[position]);
        holder.description.setText(descs[position]);
        /* Ajout de l'image avec setImagesRessouces **/
        holder.avatar.setImageResource(avatars[position]);
        /* utilisation de position pour ajout dynamique **/

        /* Ajout du listener sur tout le container (contenant) de notre viewHolder **/
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Ajout d'un Intent pour passer à la seconde vue **/
                /* On passe le context où la méthode est exécutée puis la clase de destination **/
                Intent intent = new Intent(context, SecondeActivity.class);
                /* On envoie nos datas avec putExtra la clé et la valeur à transmettre **/
                intent.putExtra("stagiaire", stagiaires[holder.getBindingAdapterPosition()]);
                intent.putExtra("desc", descs[holder.getBindingAdapterPosition()]);
                intent.putExtra("avatar", avatars[holder.getBindingAdapterPosition()]);
                /* On lance l'activité depuis le context en lui passant l'intent **/
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        /* Nombre d'item de la liste en comptant le nombre d'images avec lenght **/
        return avatars.length;
    }
}
