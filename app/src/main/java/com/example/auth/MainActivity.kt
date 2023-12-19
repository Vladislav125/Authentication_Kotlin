package com.example.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.auth.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val vModel: VModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val replace =
            supportFragmentManager.beginTransaction().replace(R.id.fragment, AuthFragment())
        replace.commit()

        val db = DataBase(this, null)
        vModel.goOn.observe(this, {
            if(it.login == "@&uuuHHkO-^f" && it.password == "ghwgmffue7"){
                Toast.makeText(this, "Неверные данные", Toast.LENGTH_SHORT).show()
            }
            else{
                if(db.getUser(it)){
                    supportFragmentManager.beginTransaction().replace(R.id.fragment, ConfirmFragment()).commit()
                }
                else{
                    Toast.makeText(this, "Такого пользователя нет", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}