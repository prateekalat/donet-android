package io.codefundo.donet

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import io.codefundo.donet.beneficiary.ListBeneficiariesActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonSearch.setOnClickListener {
            val intent = Intent(this, ListBeneficiariesActivity::class.java)
            intent.putExtra("search", true)
            intent.putExtra(
                    "searchParameters",
                    intArrayOf(
                            gender.selectedItemPosition,
                            ageGroup.selectedItemPosition,
                            familialStatus.selectedItemPosition,
                            disability.selectedItemPosition,
                            numberOfDependencies.selectedItemPosition
                    )
            )
            intent.putExtra("code", "search")

            startActivity(intent)
        }

        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.beneficiaries -> {
                val intent = Intent(this, ListBeneficiariesActivity::class.java)
                intent.putExtra("code", "list")
                startActivity(intent)
            }

            else -> return super.onOptionsItemSelected(item)
        }

        return false
    }
}
