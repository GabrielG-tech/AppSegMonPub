package br.edu.infnet.appcriptografia

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.TextView
import android.os.Bundle
import android.view.View
import android.widget.Button
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var encrypt: Button
    private lateinit var decrypt: Button
    private lateinit var message: EditText
    private lateinit var cipher: EditText
    private lateinit var key: EditText
    private var screen_output: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        encrypt = findViewById(R.id.btnencrypt)
        decrypt = findViewById(R.id.btndecrypt)
        screen_output = findViewById(R.id.tV1)
        message = findViewById(R.id.inputMessage)
        cipher = findViewById(R.id.ciphEdt)
        key = findViewById(R.id.key_dt)

        encrypt.setOnClickListener(View.OnClickListener {
            encrypt12(
                message.getText().toString(),
                key.getText().toString().toInt()
            )
        })
        decrypt.setOnClickListener(View.OnClickListener {
            decrypt12(
                cipher.getText().toString(),
                key.getText().toString().toInt()
            )
        })
    }

    fun decrypt12(cipher: String?, key: Int) {
        screen_output!!.text = Utility.decrypt1(cipher.toString(), key)!!.lowercase(Locale.getDefault())
    }

    fun encrypt12(message: String, shiftkey: Int): String {
        var message = message
        message = message.lowercase(Locale.getDefault())
        var cipherText = ""
        for (i in 0 until message.length) {
            val charPosition = alphabetString.indexOf(message[i])
            val keyval = (shiftkey + charPosition) % 26
            val replaceVAL = alphabetString[keyval]
            cipherText += replaceVAL
            screen_output!!.text = cipherText
            cipher!!.setText(cipherText)
        }
        return cipherText
    }

    companion object {
        private const val alphabetString = "abcdefghijklmnopqrstuvwxyz"
    }
}

