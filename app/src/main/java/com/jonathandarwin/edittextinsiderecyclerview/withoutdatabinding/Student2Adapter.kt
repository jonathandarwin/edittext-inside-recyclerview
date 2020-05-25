package com.jonathandarwin.edittextinsiderecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.RecyclerView
import com.jonathandarwin.edittextinsiderecyclerview.databinding.ListStudentItemBinding

class Student2Adapter(private val studentList : ArrayList<Student>, private val callback : StudentInterface) : RecyclerView.Adapter<Student2Adapter.StudentViewHolder>() {

    inner class StudentViewHolder(private val binding : ListStudentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(student : Student, position : Int){
            binding.etScore.doAfterTextChanged {
                callback.onScoreChange(it.toString(), position)
            }

            binding.etName.doAfterTextChanged {
                callback.onNameChange(it.toString(), position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder =
        StudentViewHolder(ListStudentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = studentList.size

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(studentList[position], position)
    }
}

interface StudentInterface {
    fun onScoreChange(text : String, idx : Int)
    fun onNameChange(text : String, idx : Int)
}