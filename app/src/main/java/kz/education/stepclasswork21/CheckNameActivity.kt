package kz.education.stepclasswork21

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi

class CheckNameActivity : AppCompatActivity() {

    var buttonCheck: Button? = null;
    var editTextEditor: EditText? = null;
    var textViewStatus: TextView? = null;

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_name)
        initializeView()
        initializeListener()
    }

    fun initializeView(){
        buttonCheck = findViewById(R.id.activity_check_name_check)
        editTextEditor = findViewById(R.id.activity_check_name_editor)
        textViewStatus = findViewById(R.id.activity_check_name_status)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun initializeListener(){
        buttonCheck?.setOnClickListener(View.OnClickListener {
            val regex = """\d+""".toRegex()
            if(editTextEditor!!.text.isNotEmpty()) {
                if (regex.containsMatchIn(editTextEditor!!.text)){
                    textViewStatus?.setText(R.string.activity_check_name_text_view_error);
                    textViewStatus?.setTextColor(getColor(R.color.red))
                } else {
                    textViewStatus?.setText(R.string.activity_check_name_text_view_success);
                    textViewStatus?.setTextColor(getColor(R.color.black))
                }
            }else{
                textViewStatus?.setText("");
            }
        })
    }
}