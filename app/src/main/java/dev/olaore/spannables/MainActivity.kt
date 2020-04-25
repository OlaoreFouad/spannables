package dev.olaore.spannables

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.*
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
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

        spannable.append(Html.fromHtml("Find more details in <br/> $privacyPolicy and $termsOfService", Html.FROM_HTML_MODE_LEGACY))
        spannable.setSpan(
            RelativeSizeSpan(1.5f),
            termsOfServiceText.indexOf("Find"),
            termsOfServiceText.indexOf("Find") + "Find".length,
            Spanned.SPAN_INCLUSIVE_EXCLUSIVE
        )
        spannable.setSpan(
            ForegroundColorSpan(Color.parseColor("#FFA500")),
            termsOfServiceText.indexOf(privacyPolicy),
            termsOfServiceText.indexOf(privacyPolicy) + privacyPolicy.length,
            Spanned.SPAN_INCLUSIVE_EXCLUSIVE
        )
        spannable.setSpan(
            StrikethroughSpan(),
            termsOfServiceText.indexOf("details"),
            termsOfServiceText.indexOf("details") + "details".length,
            Spanned.SPAN_INCLUSIVE_EXCLUSIVE
        )
        spannable.setSpan(
            BackgroundColorSpan(Color.RED),
            termsOfServiceText.indexOf(privacyPolicy),
            termsOfServiceText.indexOf(privacyPolicy) + privacyPolicy.length,
            Spanned.SPAN_INCLUSIVE_EXCLUSIVE
        )
        spannable.setSpan(
            ForegroundColorSpan(Color.RED),
            termsOfServiceText.indexOf(termsOfService),
            termsOfServiceText.indexOf(termsOfService) + termsOfService.length,
            Spanned.SPAN_INCLUSIVE_EXCLUSIVE
        )

        spannable_text.text = spannable

    }
}
