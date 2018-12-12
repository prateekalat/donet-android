package io.codefundo.donet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import io.codefundo.donet.data.BeneficiaryAdapter
import io.codefundo.donet.data.SearchParameters
import kotlinx.android.synthetic.main.activity_beneficiaries.*

class BeneficiariesActivity: AppCompatActivity() {

    lateinit var viewModel: BeneficiaryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beneficiaries)

        viewModel = ViewModelProviders.of(this).get(BeneficiaryViewModel::class.java)

        // Check if the use case is "searchForNewBeneficiaries" or "getCurrentBeneficiaries"
        val beneficiaries = if (intent.hasExtra("search")) {
            val parameters = intent.getIntArrayExtra("searchParameters")
            viewModel
                    .searchForNewBeneficiariesUseCase
                    .execute(SearchParameters.generateFromIntArray(
                            donorId = viewModel.currentUser.id,
                            array = parameters.toTypedArray()
                    ))
        } else {
            viewModel
                    .getCurrentBeneficiariesUseCase
                    .execute(viewModel.currentUser)
        }

        val beneficiaryAdapter = BeneficiaryAdapter(context = this)

        beneficiaries.observe(this, Observer {
            beneficiaryAdapter.updateUsers(resource = it)
        })

        recyclerView.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            itemAnimator = DefaultItemAnimator()
            setHasFixedSize(true)
            adapter = beneficiaryAdapter
        }
    }
}
