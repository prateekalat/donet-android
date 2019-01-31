package io.codefundo.donet.beneficiary

import androidx.lifecycle.ViewModel
import io.codefundo.donet.beneficiary.dagger.BeneficiaryComponentInjector
import io.codefundo.donet.authentication.data.User
import io.codefundo.donet.beneficiary.domain.AddNewBeneficiaryUseCase
import io.codefundo.donet.beneficiary.domain.GetCurrentBeneficiariesUseCase
import io.codefundo.donet.beneficiary.domain.SearchForNewBeneficiariesUseCase
import javax.inject.Inject

class BeneficiaryViewModel : ViewModel() {

    @Inject lateinit var getCurrentBeneficiariesUseCase: GetCurrentBeneficiariesUseCase
    @Inject lateinit var addNewBeneficiaryUseCase: AddNewBeneficiaryUseCase
    @Inject lateinit var searchForNewBeneficiariesUseCase: SearchForNewBeneficiariesUseCase

    var currentUser = User(
            id = 1,
            firstName = "Iru",
            lastName = "Smisu"
    ) // TODO Get actual user

    init {
        BeneficiaryComponentInjector
                .instance
                .inject(this)
    }
}