package io.codefundo.donet.beneficiary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.lifecycle.Observer
import io.codefundo.donet.beneficiary.dagger.BeneficiaryComponentInjector
import io.codefundo.donet.beneficiary.data.Beneficiary
import io.codefundo.donet.beneficiary.domain.BeneficiaryRepository
import io.codefundo.donet.core.Resource
import kotlinx.android.synthetic.main.activity_beneficiary.*
import javax.inject.Inject

class BeneficiaryActivity : AppCompatActivity() {

    @Inject lateinit var beneficiaryRepository: BeneficiaryRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beneficiary)

        val index = intent.getIntExtra("id", 0)

        BeneficiaryComponentInjector
                .instance
                .inject(this)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val code = intent.getStringExtra("code")
        val beneficiaries = when (code) {
            "search" -> {
                beneficiaryRepository.getCachedSearchedBeneficiaries()
            }

            else -> {
                beneficiaryRepository.getCachedCurrentBeneficiaries()
            }
        }

        beneficiaries.observe(this, Observer {
            Log.d("BeneficiaryActivity", it.toString())
            if (it is Resource.Success<*>) {
                val list = it.data
                if (list is List<*>) {
                    val filteredList = list.filterIsInstance(Beneficiary::class.java)
                    val beneficiary = filteredList[index]
                    supportActionBar?.title = "${beneficiary.firstName} ${beneficiary.lastName}"
                }
            }
        })

        donate.setOnClickListener {
            val intent = Intent(this, DonateActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
