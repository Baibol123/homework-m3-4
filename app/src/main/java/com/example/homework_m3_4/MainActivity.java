package com.example.homework_m3_4;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.homework_m3_4.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    public static final String KEY_CONTINENT = "key1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new ContinentsFragment(), null).commit();
        }
    }
}