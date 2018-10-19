package fr.maformation.charlotte.layouts;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import fr.maformation.charlotte.layouts.databinding.TotBinding;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>   {

    int tempPosition = -1;

    interface ItemClickListener{
        void onClick(View view, int position);
    }

    private List<User> users;
    private ItemClickListener listener;

    MyAdapter(List<User> users, ItemClickListener listener){
        this.users = users;
        this.listener = listener;
    }

    //Un ViewHolder représente un conteneur pour la vue de chaque item de la liste
    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //each data item is just a string in this case
        TotBinding binding;
        public MyViewHolder(View view) {
            super(view);
            this.binding = DataBindingUtil.bind(view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            //ici on sait que l'utilisateur a cliqué sur l'item
            //en appelant getAdapterPosition(), on sait aussi de quel item il s'agit
            //mais que faire mtn pr prévenir l'activité ?
            if (tempPosition != -1)
                users.get(tempPosition).setSelected(false);
            
            listener.onClick(view, getAdapterPosition());
            users.get(getAdapterPosition()).setSelected(true);
            tempPosition = getAdapterPosition();
        }
    }

    //Créé une nouvelle vue d'item, invoquée par le layout manager
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        //instancie la vue d'un item en allant chercher le layout particulier
        TotBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.user, parent, false);
        MyViewHolder vh = new MyViewHolder(binding.getRoot());
        return vh;
    }

    //fabrique le contenu de la vue associée à l'item de numero 'position'
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        User user = users.get(position);
        holder.binding.setUser(user);
        /* TextView nom = holder.v.findViewById(R.id.nom);
        TextView prenom = holder.v.findViewById(R.id.prenom);
        TextView age = holder.v.findViewById(R.id.age);

        nom.setText(users.get(position).nom);
        prenom.setText(users.get(position).prenom);
        age.setText(String.valueOf(users.get(position).age));

        if (users.get(position).age > 40) {
            holder.v.setBackgroundColor(0xFF33FF00);
        }else{
            holder.v.setBackgroundColor(0xFFFFFF00);
        }
        */
    }

    //Doit retourner la taille de la liste d'items
    @Override
    public int getItemCount(){
        return users.size();
    }

}