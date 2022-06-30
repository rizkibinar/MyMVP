package id.co.rizki.mymvp

import id.co.rizki.mymvp.model.Student


/**
 * Created by Rizky Putra on 30/06/22.
 */
class MainPresenterImpl(val view: MainView) : MainPresenter{

    private val STUDENTS = mutableListOf<Student>()

    override fun addData(firstName: String, lastName: String) {
        if(firstName.isEmpty() || lastName.isEmpty())
            view.showMessage("Field tidak boleh kosong")
        else {
            STUDENTS.add(Student("MR " +firstName, lastName))

            view.showMessage("Sukses Input Data $firstName")

            view.clearField()

        }
    }

    override fun loadData() {
        if(STUDENTS.isEmpty())
            view.showMessage("Data Masih Kosong")
        else {
            var allData = ""

            STUDENTS.forEach { student ->
                allData += "Nama Depan : ${student.firstName}\nNama Belakang : ${student.lastName} \n\n"
            }

            allData += "Total data ${STUDENTS.size}"

            view.showData(allData)
        }

    }
}