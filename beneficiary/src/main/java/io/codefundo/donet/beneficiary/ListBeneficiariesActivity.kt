package io.codefundo.donet.beneficiary

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import io.codefundo.donet.beneficiary.data.BeneficiaryAdapter
import io.codefundo.donet.beneficiary.data.SearchParameters
import kotlinx.android.synthetic.main.activity_list_beneficiaries.*

class ListBeneficiariesActivity: AppCompatActivity() {

    lateinit var beneficiaryViewModel: BeneficiaryViewModel
//    lateinit var authenticationViewModel: AuthenticationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_beneficiaries)

        beneficiaryViewModel = ViewModelProviders.of(this).get(BeneficiaryViewModel::class.java)

        // Check if the use case is "searchForNewBeneficiaries" or "getCurrentBeneficiaries"
        val beneficiaries = if (intent.hasExtra("search")) {
            val parameters = intent.getIntArrayExtra("searchParameters")
            beneficiaryViewModel
                    .searchForNewBeneficiariesUseCase
                    .execute(SearchParameters.generateFromIntArray(
                            donorId = beneficiaryViewModel.currentUser.id,
                            array = parameters.toTypedArray()
                    ))
        } else {
            beneficiaryViewModel
                    .getCurrentBeneficiariesUseCase
                    .execute(beneficiaryViewModel.currentUser)
        }

        val beneficiaryAdapter = BeneficiaryAdapter(activity = this)

        beneficiaries.observe(this, Observer {
            beneficiaryAdapter.updateUsers(resource = it)
        })

        recyclerView.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            itemAnimator = DefaultItemAnimator()
            setHasFixedSize(true)
            adapter = beneficiaryAdapter
        }

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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
