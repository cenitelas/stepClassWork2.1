package kz.education.stepclasswork21

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var buttonCheckName: Button?  = null;
    var buttonRegistration : Button? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews();
        initializeListeners();
    }


    fun initializeViews(){
        buttonCheckName = findViewById(R.id.activity_main_button_check_name)
        buttonRegistration = findViewById(R.id.activity_main_button_registration)
    }

    fun initializeListeners(){
        buttonCheckName?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, CheckNameActivity::class.java)
            startActivity(intent)
        })

        buttonRegistration?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        })
    }
}