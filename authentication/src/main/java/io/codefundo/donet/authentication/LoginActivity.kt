package io.codefundo.donet.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy

class LoginActivity : AppCompatActivity() {

    lateinit var authenticationViewModel: AuthenticationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        authenticationViewModel = ViewModelProviders
                .of(this)
                .get(AuthenticationViewModel::class.java)

        authenticationViewModel
                .authenticationRepository
                .login()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onSuccess = {
                            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
                        },
                        onError = {
                            Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                        }
                )
    }
}
