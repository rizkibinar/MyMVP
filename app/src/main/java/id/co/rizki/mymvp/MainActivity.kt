package id.co.rizki.mymvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import id.co.rizki.mymvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {

    lateinit var binding : ActivityMainBinding

    lateinit var presenter: MainPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        presenter = MainPresenterImpl(this)

        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            val firstName = binding.etFirstName.text.toString()
            val lastName = binding.etLastName.text.toString()

            presenter.addData(firstName, lastName)
        }

        binding.btnShow.setOnClickListener {
            presenter.loadData()
        }

    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showData(data: String) {
        val dialog = AlertDialog.Builder(this)

        dialog.setTitle("Data")

        dialog.setMessage(data)

        dialog.show()
    }

    override fun clearField() {
        binding.etFirstName.setText("")
        binding.etLastName.setText("")
    }
}