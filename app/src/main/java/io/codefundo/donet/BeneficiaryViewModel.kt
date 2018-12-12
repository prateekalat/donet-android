package io.codefundo.donet

import androidx.lifecycle.ViewModel
import io.codefundo.donet.dagger.BeneficiaryComponentInjector
import io.codefundo.donet.data.User
import io.codefundo.donet.domain.AddNewBeneficiaryUseCase
import io.codefundo.donet.domain.GetCurrentBeneficiariesUseCase
import io.codefundo.donet.domain.SearchForNewBeneficiariesUseCase
import javax.inject.Inject

class BeneficiaryViewModel : ViewModel() {

    @Inject lateinit var getCurrentBeneficiariesUseCase: GetCurrentBeneficiariesUseCase
    @Inject lateinit var addNewBeneficiaryUseCase: AddNewBeneficiaryUseCase
    @Inject lateinit var searchForNewBeneficiariesUseCase: SearchForNewBeneficiariesUseCase

    val currentUser = User(
            id = 1,
            name = "Iru Smisu",
            comment = "E"
    ) // TODO Get actual user

    init {
        BeneficiaryComponentInjector
                .instance
                .inject(this)
    }
}