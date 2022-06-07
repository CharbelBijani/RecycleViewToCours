package com.example.recycleviewtocours;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.example.recycleviewtocours.recycler_horizontal.MyRecyclerAdapterHorizontal;
import com.example.recycleviewtocours.recycler_vertical.MyRecyclerAdapterVertical;

import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

public class MainActivity extends AppCompatActivity {

    /**
     * Attributs globaux
     **/
    RecyclerView recyclerViewVertical, recyclerViewHorizontal;


    /**
     * Déclaration des tableaux de String
     **/
    String stagiaires[], descs[];
    /**
     * Déclaration du tableau des images
     **/
    int avatars[] = {R.drawable.stagiaire_01,
            R.drawable.stagiaire_02,
            R.drawable.stagiaire_03,
            R.drawable.stagiaire_04,
            R.drawable.stagiaire_05,
            R.drawable.stagiaire_06,
            R.drawable.stagiaire_07,
            R.drawable.stagiaire_08,
            R.drawable.stagiaire_09,
            R.drawable.stagiaire_010,
            R.drawable.stagiaire_011,
            R.drawable.stagiaire_012,
            R.drawable.stagiaire_013,
            R.drawable.stagiaire_014
    };

    /**
     * Méthode pour initialiser le design et les données avec le code
     **/
    public void initUI() {
        recyclerViewHorizontal = (RecyclerView) findViewById(R.id.mRecyclerViewHorizontal);
        recyclerViewVertical = (RecyclerView) findViewById(R.id.mRecyclerViewVertical);
        stagiaires = getResources().getStringArray(R.array.stagiaires);
        descs = getResources().getStringArray(R.array.description);
    }

    public void remplissageRecyclerVertical() {
        // Déclaration de l'adapter
        MyRecyclerAdapterVertical myRecyclerAdapterVertical = new MyRecyclerAdapterVertical(this,
                stagiaires, descs, avatars);
        // Ajout de l'adapteur au recyclerView
        recyclerViewVertical.setAdapter(myRecyclerAdapterVertical);
        // Ajout d'un nouveau LinearLayout pour contenir les vues du RecyclerView
        // On peut alors choisir l'orientation vertical ou horizontal ou inverser la sélection
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        // Decoration
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerViewVertical.addItemDecoration(itemDecoration);

        Drawable dividerDrawable = ContextCompat.getDrawable(this, R.drawable.divider_drawable);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerViewVertical.addItemDecoration(dividerItemDecoration);
        // Animator
        recyclerViewVertical.setItemAnimator(new SlideInUpAnimator());
        recyclerViewVertical.setLayoutManager(layoutManager);
    }

    public void remplissageRecyclerHorizontal() {
        // Déclaration de l'adapter
        MyRecyclerAdapterHorizontal myRecyclerAdapterHorizontal = new MyRecyclerAdapterHorizontal(this,
                stagiaires, descs, avatars);
        // Ajout de l'adapteur au recyclerView
        recyclerViewHorizontal.setAdapter(myRecyclerAdapterHorizontal);
        // Ajout d'un nouveau LinearLayout pour contenir les vues du RecyclerView
        // On peut alors choisir l'orientation vertical ou horizontal ou inverser la sélection
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        recyclerViewHorizontal.setLayoutManager(layoutManager);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /** Appel des méthodes **/
        initUI();
        remplissageRecyclerHorizontal();
        remplissageRecyclerVertical();

    }
}