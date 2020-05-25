package com.jonathandarwin.edittextinsiderecyclerview.withoutdatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.jonathandarwin.edittextinsiderecyclerview.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(), View.OnClickListener, StudentInterface {

    private val studentList : ArrayList<Student> = ArrayList()
    private lateinit var studentAdapter : Student2Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        setAdapter()
        setListener()
    }

    private fun setAdapter(){
        studentAdapter = Student2Adapter(studentList, this)
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@SecondActivity)
            adapter = studentAdapter
        }
    }

    private fun setListener() {
        tv_add_item.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }

    override fun onScoreChange(text: String, idx: Int) {
        studentList[idx].score = text
    }

    override fun onNameChange(text: String, idx: Int) {
        studentList[idx].name = text
    }

    override fun onClick(v: View?) {
        when(v?.id){
            tv_add_item.id -> {
                studentList.add(Student())
                studentAdapter.notifyItemInserted(studentList.size-1)
            }
            btn_submit.id -> {
                studentList.forEachIndexed { index, student ->
                    Log.d("<RESULT>", "$index Name : ${student.name} - Score : ${student.score}")
                }
            }
        }
    }
}
