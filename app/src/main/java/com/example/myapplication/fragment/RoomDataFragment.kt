package com.example.myapplication.fragment


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapter.StudentAdapter
import com.example.myapplication.room.Student
import com.example.myapplication.viewmodel.StudentViewModel
import kotlinx.android.synthetic.main.fragment_room_data.*


/**
 * A simple [Fragment] subclass.
 */
class RoomDataFragment : Fragment() {

    private lateinit var studentViewModel: StudentViewModel
    private var studentAdapter: StudentAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_room_data, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        studentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)

        val linearLayoutManager = LinearLayoutManager(activity)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        studentRecyclerView.layoutManager = linearLayoutManager

        studentAdapter = StudentAdapter()
        studentRecyclerView.adapter = studentAdapter

        btnInsertData.setOnClickListener {
            studentViewModel.insertStudentList()
        }

        btnSelectStudentList.setOnClickListener {
            studentViewModel.selectConcreteList()
            observerPageList()
        }

        btnDeleteRecord.setOnClickListener {
            val student = Student()
            student.studentName = "Arun V 1"
            student.studentRollNo = 10
            student.studentAge = 34 + 1
            student.studentPlace = "Salem $1"
            studentViewModel.deleteStudentRecord(student)
        }
    }

    private fun observerPageList() {
        studentViewModel.concreteList?.observe(viewLifecycleOwner, Observer { pagedListObject ->

            if (pagedListObject != null) {
                Log.i("-----> ", "PageList Size : ${pagedListObject.size}")
                for (student: Student in pagedListObject) {
                    Log.i("ID :", "" + student.studentRollNo)
                    Log.i("Name : ", "" + student.studentName)
                    Log.i("Age : ", "" + student.studentAge)
                    Log.i("Place : ", "" + student.studentPlace)
                }
                studentAdapter?.submitList(pagedListObject)
            }
        })
    }

}
