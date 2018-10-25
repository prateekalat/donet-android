package io.codefundo.donet

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.annotation.ArrayRes
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ageGroup.setResource(this, R.array.age_groups)
        familialStatus.setResource(this, R.array.familial_statuses)
        disability.setResource(this, R.array.disabilities)
        gender.setResource(this, R.array.genders)
        currentBalance.setResource(this, R.array.current_balance)

        buttonSearch.setOnClickListener {
            Toast.makeText(this, "Searching..", Toast.LENGTH_SHORT).show()
        }
    }

    private fun Spinner.setResource(context: Context, @ArrayRes res: Int) {
        // Layout of dropdown items
        val arrayAdapter = ArrayAdapter.createFromResource(
                context,
                res,
                android.R.layout.simple_spinner_dropdown_item
        )

        adapter = arrayAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        return true
    }
}
