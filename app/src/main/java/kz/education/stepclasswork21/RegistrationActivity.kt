package kz.education.stepclasswork21

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class RegistrationActivity : AppCompatActivity() {
    var buttonSend: Button? = null
    var editTextLogin: EditText? = null
    var editTextEmail: EditText? = null
    var editTextPassword: EditText? = null
    var editTextRepeatPassword: EditText? = null
    var textViewLoginStatus: TextView? = null
    var textViewEmailStatus: TextView? = null
    var textViewPasswordStatus: TextView? = null
    var textViewRepeatPasswordStatus: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registation)
        initializeView()
        initializeListener()
    }

    fun initializeView(){
        buttonSend = findViewById(R.id.activity_registration_button_send)
        editTextLogin = findViewById(R.id.activity_registration_edit_text_login)
        editTextEmail = findViewById(R.id.activity_registration_edit_text_email)
        editTextPassword = findViewById(R.id.activity_registration_edit_text_password)
        editTextRepeatPassword = findViewById(R.id.activity_registration_edit_text_repeat_password)
        textViewLoginStatus = findViewById(R.id.activity_registration_login_status)
        textViewEmailStatus = findViewById(R.id.activity_registration_email_status)
        textViewPasswordStatus = findViewById(R.id.activity_registration_password_status)
        textViewRepeatPasswordStatus = findViewById(R.id.activity_registration_repeat_password_status)
    }

    fun initializeListener(){
        buttonSend?.setOnClickListener(View.OnClickListener {
            val regexNumber = """\d+""".toRegex()
            val regexString = """[a-zA-Z]+""".toRegex()

            if(editTextLogin!!.text.isEmpty()){
                textViewLoginStatus?.setText(R.string.activity_registration_text_view_status_error_null)
            }else if(!regexNumber.containsMatchIn(editTextLogin!!.text)){
                textViewLoginStatus?.setText(R.string.activity_registration_text_view_status_error_name_number)
            }else if(!regexString.containsMatchIn(editTextLogin!!.text)){
                textViewLoginStatus?.setText(R.string.activity_registration_text_view_status_error_name_string)
            }else{
                textViewLoginStatus?.setText("")
            }

            if(editTextEmail!!.text.isEmpty()){
                textViewEmailStatus?.setText(R.string.activity_registration_text_view_status_error_null)
            }else{
                textViewEmailStatus?.setText("")
            }

            if(editTextPassword!!.text.isEmpty()){
                textViewPasswordStatus?.setText(R.string.activity_registration_text_view_status_error_null)
            }else{
                textViewPasswordStatus?.setText("")
            }

            if(editTextRepeatPassword!!.text.isEmpty()){
                textViewRepeatPasswordStatus?.setText(R.string.activity_registration_text_view_status_error_null)
            }else if(editTextPassword!!.text.toString() != editTextRepeatPassword!!.text.toString()){
                textViewRepeatPasswordStatus?.setText(R.string.activity_registration_text_view_status_error_password_equals)
            }else{
                textViewRepeatPasswordStatus?.setText("")
            }

        })
    }

}