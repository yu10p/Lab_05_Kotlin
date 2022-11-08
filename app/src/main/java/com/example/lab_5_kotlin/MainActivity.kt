package com.example.lab_5_kotlin

import android.content.DialogInterface
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //初始化Activity
        super.onCreate(savedInstanceState)
        //連接main1.xml畫面
        setContentView(R.layout.activity_main)

        //連接button元件
        val btn = findViewById<Button>(R.id.button)
        //btn點擊事件
        btn.setOnClickListener(){
            val dialog = AlertDialog.Builder(this@MainActivity)
                .setTitle("請選擇功能")
                .setMessage("請根據下方按鈕選擇要顯示的物件")
                .setNeutralButton("取消",DialogInterface.OnClickListener{ dialog, which ->
                    Toast.makeText(this,"dialog關閉",Toast.LENGTH_SHORT).show()
                })
                .setNegativeButton("自定義Toast",DialogInterface.OnClickListener{ dialog, which ->
                    showToast()
                })
                .setPositiveButton("顯示list",DialogInterface.OnClickListener{ dialog, i ->
                    showListDialog()
                })
                .show()
        }
    }


    private fun showToast(){
        val toast = Toast(this)
        toast.setGravity(Gravity.TOP,0,50)
        toast.duration = Toast.LENGTH_SHORT
        val inflater = layoutInflater
        val layout = inflater.inflate(R.layout.custom_toast, findViewById(R.id.custom_toast_root))
        toast.setView(layout)
        toast.show()
    }

    private fun showListDialog(){
        val list = arrayOf("message1", "message2", "message3", "message4", "message5")
        val dialog_list = AlertDialog.Builder(this@MainActivity)
            .setTitle("使用LIST呈現")
            .setItems(list,DialogInterface.OnClickListener { dialog, i ->
                Toast.makeText(this,"你選的是"+list[i],Toast.LENGTH_SHORT).show()
            })
            .show()
    }
}