package com.jonathandarwin.edittextinsiderecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.jonathandarwin.edittextinsiderecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val studentList : ArrayList<Student> = ArrayList()
    private lateinit var studentAdapter : StudentAdapter
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setAdapter()
        setListener()
    }

    private fun setAdapter(){
        studentAdapter = StudentAdapter(studentList)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = studentAdapter
        }
    }

    private fun setListener() {
        binding.tvAddItem.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            binding.tvAddItem.id -> {
                studentList.add(Student())
                studentAdapter.notifyItemInserted(studentList.size-1)
            }
            binding.btnSubmit.id -> {
                studentList.forEachIndexed { index, student ->
                    Log.d("<RESULT>", "Name : ${student.name} - Score : ${student.score}")
                }
            }
        }
    }
}
