package dev.olaore.spannables

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.text.style.URLSpan
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var privacyPolicy: String = resources.getString(R.string.privacy_policy_url)
        var termsOfService: String = resources.getString(R.string.terms_of_service_url)

        var spannable = SpannableStringBuilder()
        var termsOfServiceText = resources.getString(
            R.string.terms_of_service, privacyPolicy, termsOfService
        )

        println("debug: " +
                "Full text: $termsOfServiceText " +
                "Start Of PP: ${ termsOfServiceText.indexOf(privacyPolicy) } " +
                "End Of PP: ${ termsOfServiceText.indexOf(privacyPolicy) + privacyPolicy.length
        }")

        spannable.append(termsOfServiceText)
        spannable.setSpan(
            ForegroundColorSpan(Color.RED),
            termsOfServiceText.indexOf(privacyPolicy),
            termsOfServiceText.indexOf(privacyPolicy) + privacyPolicy.length,
            Spanned.SPAN_INCLUSIVE_EXCLUSIVE
        )
        spannable.setSpan(
            AbsoluteSizeSpan(30),
            termsOfServiceText.indexOf(privacyPolicy),
            termsOfServiceText.indexOf(privacyPolicy) + privacyPolicy.length,
            Spanned.SPAN_INCLUSIVE_EXCLUSIVE
        )
        spannable.setSpan(
            URLSpan("privacy_policy_url"),
            termsOfServiceText.indexOf(privacyPolicy),
            termsOfServiceText.indexOf(privacyPolicy) + privacyPolicy.length,
            Spanned.SPAN_INCLUSIVE_EXCLUSIVE
        )

        spannable_text.text = spannable

    }
}
