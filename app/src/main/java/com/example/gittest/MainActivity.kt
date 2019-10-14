package com.example.gittest

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnToast.setOnClickListener(this)
        btnDialog.setOnClickListener(this)
        btnIntent.setOnClickListener(this)
        btnIntent1.setOnClickListener(this)
        btnPhone.setOnClickListener(this)
        btnSnackbar.setOnClickListener(this)

        btnSnackbar2.setOnClickListener {
            Snackbar.make(it, "이것이 스낵바 Toast다", Snackbar.LENGTH_LONG).show()

        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnToast -> {
                toast("Toast 개꿀띠")
            }
            R.id.btnDialog -> {
                alert("안뇽???", "I am Title") {
                    this.yesButton {
                        toast("나는 Yes 버튼이다!")
                    }
                    this.noButton {
                        toast("나는 No 버튼인디?")
                    }
                }.show()
            }
            R.id.btnIntent -> {
                startActivity<IntentOneAct>()
            }
            R.id.btnIntent1 -> {
                if (!edt1.text.toString().isNullOrEmpty()) {
                    startActivity<IntentOneAct>(
                        "Edt1" to edt1.text.toString()
                    )
                } else {
                    toast("데이터 없잔아 ㅡㅡ")
                }
            }
            R.id.btnPhone -> {
                val _stest = edt2.text.toString()

                if (_stest.length == 11) {
                    makeCall(
                        String.format(
                            "%s\u002D%s\u002D%s", _stest.substring(0, 3),
                            _stest.substring(3, 7), _stest.substring(7)
                        )
                    )
                } else {
                    toast("제대로 입력해라")
                }
            }
            R.id.btnSnackbar -> {
                var snackbar: Snackbar = Snackbar.make(v!!, "이것이 스낵바다", Snackbar.LENGTH_INDEFINITE)

                snackbar.setAction("확인눌러라", {
                    toast("확인버튼 이벤트 ㅇㅇ")
                    snackbar.dismiss()
                })

                snackbar.setActionTextColor(Color.BLUE)
                var snackbarView: View = snackbar.view
                snackbarView.setBackgroundColor(Color.GRAY)


                snackbar.show()
            }
        }
    }
}
