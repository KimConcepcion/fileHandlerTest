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

class fileHandler
{
    //  Write to a file, but delets former content:
    fun setDataFile(file_name : String, file_content : String, context : Context)
    {
        context.openFileOutput(file_name, Context.MODE_PRIVATE).use{
            it.write(file_content.toByteArray())
        }
    }

    //  Append a file:
    fun appendDataFile(file_name : String, append_text : String, context : Context)
    {
        context.openFileOutput(file_name, Context.MODE_APPEND).use{
            it.write(append_text.toByteArray())
        }
    }

    //  Read the file, line by line:
    fun getDataFile(file_name : String, context : Context) : String
    {
        val file = InputStreamReader(context.openFileInput(file_name))
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