package fr.maformation.charlotte.layouts;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import fr.maformation.charlotte.layouts.databinding.FullUserActivityBinding;

public class FullUserActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FullUserActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.full_user_activity);
        User user = (User) getIntent().getSerializableExtra("user");
        binding.setUser(user);
        /*TextView nom = findViewById(R.id.nom); //champ nom
        TextView prenom = findViewById(R.id.prenom); //champ prenom
        TextView age = findViewById(R.id.age); //champ age

        nom.setText(user.getNom());
        prenom.setText(user.getPrenom());
        age.setText(String.valueOf(user.getAge()));*/
    }
}
