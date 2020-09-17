package tw.nolions.tdd

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        send.setOnClickListener {
            val userName = userName.text.toString()

            val verify = RegisterVerify().verifyUserName(userName)


            if (verify) {
                Repository(this).saveUserName(userName)
                startActivity(ResultActivity.getIntent(this))
            } else {
                val builder = AlertDialog.Builder(this)
                builder.setMessage("data format error").setTitle("Fail")
                builder.show()

                Toast.makeText(this, "Fail", Toast.LENGTH_LONG).show()
            }
        }
    }
}