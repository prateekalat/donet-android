package io.codefundo.donet

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Spinner
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
            val progress = ProgressDialog(this)
            progress.setTitle("Loading")
            progress.setMessage("Features Chosen: Under 12, Unmarried, Has Disability, Male, 0 - 20")
            progress.setCancelable(true) // disable dismiss by tapping outside of the dialog
            progress.show()

            val intent = Intent(this, BeneficiariesActivity::class.java)
            startActivity(intent)
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.beneficiaries -> {
                val intent = Intent(this, BeneficiariesActivity::class.java)
                startActivity(intent)
            }

            else -> return super.onOptionsItemSelected(item)
        }

        return false
    }
}
