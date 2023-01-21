package com.brianajusta.androidchapterchallengekelompoksatu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import com.brianajusta.androidchapterchallengekelompoksatu.R
import com.brianajusta.androidchapterchallengekelompoksatu.databinding.ActivityChangeNameMenuBinding

class ChangeNameMenu : AppCompatActivity() {

    private lateinit var binding: ActivityChangeNameMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityChangeNameMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_name_menu)

        binding.ivClose.setOnClickListener{
            finish() }

        val name = null
        binding.etPlayerOne.text = name
        val name2 = null
        binding.etPlayerTwo.text = name2

     /*   binding.btnFinish.setOnClick(email: String, password: String) {
            Log.d(LOG_TAG, "email $email password : $password");
        }*/

        /*button.setOnClickListener {
            if (name == null || name2 == null) {
                Toast.makeText(this, "Nama Pemain tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, MenuActivity::class.java)
                intent.putExtra("location", name.getText().toString() && name2.getText().toString())
                startActivity(intent)            }
        }*/
    }
}
