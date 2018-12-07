package io.codefundo.donet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import io.codefundo.donet.data.User
import io.codefundo.donet.data.UserAdapter
import kotlinx.android.synthetic.main.activity_beneficiaries.*

class BeneficiariesActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beneficiaries)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            itemAnimator = DefaultItemAnimator()
            adapter = UserAdapter(generateData())
        }
    }

    private fun generateData() = arrayListOf(
            User("DWF", "Balance is: " + 1),
            User("ASE", "Balance is: " + 14),
            User("REW", "Balance is: " + 8),
            User("AWQ", "Balance is: " + 4),
            User("PFR", "Balance is: " + 9)
    )
}
