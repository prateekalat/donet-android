package io.codefundo.donet.beneficiary

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import io.codefundo.donet.authentication.domain.AuthenticationRepository
import io.codefundo.donet.beneficiary.dagger.BeneficiaryComponentInjector
import io.codefundo.donet.beneficiary.data.BeneficiaryRetrofitService
import io.codefundo.donet.beneficiary.data.Transaction
import io.codefundo.donet.beneficiary.data.TransactionWrapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_donate.*
import javax.inject.Inject

class DonateActivity : AppCompatActivity() {

    @Inject lateinit var beneficiaryRetrofitService: BeneficiaryRetrofitService
    @Inject lateinit var authenticationRepository: AuthenticationRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donate)

        BeneficiaryComponentInjector.instance.inject(this)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        donate.setOnClickListener {
//            Single.timer(2, TimeUnit.SECONDS)
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribeBy {
//                        Toast.makeText(
//                                this,
//                                "${amount.editableText} donated!",
//                                Toast.LENGTH_SHORT
//                        ).show()
//
//                        finish()
//                    }
            val beneficiaryId = intent.getIntExtra("beneficiaryId", 0)

//            Toast.makeText(this, "Beneficiary Id: $beneficiaryId", Toast.LENGTH_SHORT).show()

            beneficiaryRetrofitService
                    .getSmartContractId(beneficiaryId)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeBy(
                            onSuccess = { contractId ->
                                Toast.makeText(this, "Smart Contract ID: $contractId", Toast.LENGTH_SHORT).show()
                                val token = authenticationRepository.getCachedAccessToken().value
                                if (token != null) {
                                    beneficiaryRetrofitService.donate(
                                            "https://donet-emh24g-api.azurewebsites.net/api/v1/contracts/$contractId/actions",
                                            token.toString(),
                                            TransactionWrapper(listOf(Transaction(
                                                    amount.editableText.toString()
                                            ))))
                                            .observeOn(AndroidSchedulers.mainThread())
                                            .subscribeBy(
                                                    onSuccess = {
                                                        Toast.makeText(this, "Success! Trans ID: $it", Toast.LENGTH_LONG).show()
                                                        finish()
                                                    },
                                                    onError = {
                                                        Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                                                    }
                                            )
                                }
                            },
                            onError = {
                                Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                            }
                    )

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
