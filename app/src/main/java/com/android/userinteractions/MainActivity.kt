package com.android.userinteractions

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var toastButt : Button
    private lateinit var snackButt : Button
    private lateinit var myLayout : ConstraintLayout
    private lateinit var dialog : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toastButt = findViewById(R.id.toast)
        snackButt = findViewById(R.id.snack)
        myLayout = findViewById(R.id.myLayout)
        dialog = findViewById(R.id.alert)

        toastButt.setOnClickListener {
            Toast.makeText(applicationContext, "This is a toast message", Toast.LENGTH_SHORT).show()
        }

        snackButt.setOnClickListener {
            Snackbar.make(myLayout,"This is a snackbar message", Snackbar.LENGTH_SHORT)
                .setAction("Close") {
            }
                .show()
        }
        dialog.setOnClickListener {
            showAlertDialog()
        }
    }
    @SuppressLint("SetTextI18n")
    private fun showAlertDialog(){

        val alertDialog = AlertDialog.Builder(this@MainActivity)

        alertDialog.setTitle("Change")
            .setMessage("Do you want to change the text?")
            .setIcon(R.drawable.warning)
            .setCancelable(false)
            .setPositiveButton("Yes") { _, _ ->
                dialog.text = "Alert Dialog"
            }
            .setNegativeButton("No") { dialogInterface, _ ->
                dialogInterface.cancel()
            }
        alertDialog.create().show()
    }

}