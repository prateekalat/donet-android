package io.codefundo.donet

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import io.codefundo.donet.authentication.AuthenticationViewModel
import io.codefundo.donet.authentication.data.AccessToken
import io.codefundo.donet.authentication.data.User
import io.codefundo.donet.core.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy

class LoginActivity : AppCompatActivity() {

    private lateinit var authenticationViewModel: AuthenticationViewModel

    private val clientId = "7ea8b7ec-8f68-4adb-b497-71c92a04604d"
    private val redirectUri = "donet://callback"
    private val authorizationUrl = "https://login.microsoftonline.com/ab1392a3-2bc6-447a-be06-c76a6c5e6df7/oauth2/authorize"
    private val tokenUrl = "https://login.microsoftonline.com/ab1392a3-2bc6-447a-be06-c76a6c5e6df7/oauth2/token"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        authenticationViewModel = ViewModelProviders
                .of(this)
                .get(AuthenticationViewModel::class.java)

        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("access_token", "") ?: ""
        val tokenType = sharedPreferences.getString("token_type", "") ?: ""
        Log.d("LoginActivity", token)
        if (token == "") {
            // Not authenticated
            val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("$authorizationUrl?" +
                            "client_id=$clientId" +
                            "&redirect_uri=$redirectUri" +
                            "&response_type=code" +
                            "&response_mode=query" +
                            "&state=12345" +
                            "&resource=$clientId"
                    )
            )
            startActivity(intent)
        } else {
            requestUser(token, tokenType)
        }

        checkNewIntent(intent)
    }

    private fun requestUser(token: String, tokenType: String) {
        val accessToken = AccessToken(token, tokenType)

        Log.d("LoginActivity", accessToken.toString())

        // Authenticated
        authenticationViewModel
                .authenticationRepository
                .setCachedAccessToken(accessToken)

        authenticationViewModel.authenticationRepository.requestUserFromServer().observe(
                this,
                Observer {
                    if (it is Resource.Failure) {
                        Toast.makeText(
                                this,
                                "RequestUser: ${it.throwable.message}",
                                Toast.LENGTH_SHORT).show()
                    } else {
                        if (it is Resource.Success<*>) {
                            val data = it.data
                            if (data is User) {
                                Log.d("LoginActivity", data.toString())

                                startActivity(Intent(this, MainActivity::class.java))
                                finish()
                            }
                        }
                    }

                }
        )
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        checkNewIntent(intent)
    }

    private fun checkNewIntent(intent: Intent?) {

        Log.d("LoginActivity, Intent:", intent.toString())

        val uri = intent?.data
        if (uri != null) {
            val code = uri.getQueryParameter("code")
            authenticationViewModel
                    .authenticationRepository
                    .requestAccessTokenFromServer(tokenUrl,
                            mapOf(
                                    "client_id" to clientId,
                                    "code" to code,
                                    "grant_type" to "authorization_code",
                                    "redirect_uri" to redirectUri,
                                    "resource" to clientId
                            )
                    ).observeOn(AndroidSchedulers.mainThread())
                    .subscribeBy(
                            onSuccess = {
                                Log.d("LoginActivity", it.toString())
                                val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
                                if (sharedPreferences != null) {
                                    with (sharedPreferences.edit()) {
                                        putString("access_token", it.accessToken)
                                        putString("token_type", it.tokenType)
                                        apply()
                                    }

                                    requestUser(it.accessToken, it.tokenType)
                                }
                            },
                            onError = {
                                Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                            }
                    )
        }
    }
}
