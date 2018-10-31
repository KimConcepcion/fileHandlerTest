package dk.pme.kim.filehandlertest

import android.content.Context
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import java.io.BufferedReader
import java.io.File
import java.io.FileOutputStream
import java.io.InputStreamReader
import java.lang.StringBuilder

open class fileHandler : AppCompatActivity()
{
    fun setDataFile(file_name : String, file_content : String)
    {
        val file = File(Environment.getExternalStorageDirectory(), file_name)
        val fos : FileOutputStream = FileOutputStream(file)
        fos.write(file_content.toByteArray())
        fos.close()
    }

    fun getDataFile(file_name : String) : String
    {
        val file = InputStreamReader(openFileInput(file_name))
        val br = BufferedReader(file)
        var line = br.readLine()
        val all = StringBuilder()

        while(line != null)
        {
            all.append(line + "\n")
            line = br.readLine()
        }

        br.close()
        file.close()
        return all.toString()
    }
}