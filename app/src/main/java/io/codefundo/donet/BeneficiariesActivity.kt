package io.codefundo.donet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import io.codefundo.donet.data.BeneficiaryAdapter
import kotlinx.android.synthetic.main.activity_beneficiaries.*

class BeneficiariesActivity: AppCompatActivity() {

    lateinit var viewModel: BeneficiaryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beneficiaries)

        viewModel = ViewModelProviders.of(this).get(BeneficiaryViewModel::class.java)

        val beneficiaryAdapter = BeneficiaryAdapter(context = this)
        val beneficiaries = viewModel.getCurrentBeneficiariesUseCase.execute()
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
