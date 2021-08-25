package cz.lastaapps.common.app

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cz.lastaapps.common.DeveloperInfo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.first_text)?.text = DeveloperInfo.getName(this)
        findViewById<TextView>(R.id.second_text)?.text = DeveloperInfo.getNameAndBuildYear(this)

    }
}