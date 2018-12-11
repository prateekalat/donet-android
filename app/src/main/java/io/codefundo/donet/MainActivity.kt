package io.codefundo.donet

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonSearch.setOnClickListener {
            val intent = Intent(this, BeneficiariesActivity::class.java)
            intent.putExtra("search", true)
            intent.putExtra(
                    "searchParameters",
                    arrayOf(
                            ageGroup.selectedItem.toString(),
                            familialStatus.selectedItem.toString(),
                            disability.selectedItem.toString(),
                            gender.selectedItem.toString(),
                            currentBalance.selectedItem.toString()
                    )
            )

            startActivity(intent)
        }
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
