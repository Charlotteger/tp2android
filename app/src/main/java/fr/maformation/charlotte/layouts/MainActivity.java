package fr.maformation.charlotte.layouts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import static android.graphics.Color.GRAY;
import static android.graphics.Color.YELLOW;

public class MainActivity extends AppCompatActivity {

    View tempv = null;
    int tempp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<User> userlist = new ArrayList();
        userlist.add(new User(false,"Stark","Catelyn",42));
        userlist.add(new User(false,"Lanister","Tyrion",49));
        userlist.add(new User(false,"Snow","John",32));
        userlist.add(new User(false,"Lanister","Cercei",34));
        for(int i = 0; i<1000 ; i++){
            userlist.add(new User(false,"nom " + i,"prenom " + i, i ));
        }

        RecyclerView recycler = findViewById(R.id.recyclerview);
        recycler.setLayoutManager(new LinearLayoutManager(this));//new GridLayoutManager(this,2));
        recycler.setAdapter(new MyAdapter(userlist, new MyAdapter.ItemClickListener(){
            @Override
            public void onClick(View view, int position){
                //c'est ici que le click sera transmis à l'activité
                if (tempv != null) {
                    if (userlist.get(tempp).age > 40) {
                        tempv.setBackgroundColor(0xFF33FF00);
                    } else {
                        tempv.setBackgroundColor(YELLOW);
                    }
                }
                tempv = view;
                tempp = position;
                view.setBackgroundColor(GRAY);
                Intent intent = new Intent(getBaseContext(), FullUserActivity.class);
                intent.putExtra("user",userlist.get(position));
                startActivity(intent);
            }
        }));
    }
}
