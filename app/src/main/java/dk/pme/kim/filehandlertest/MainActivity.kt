package dk.pme.kim.filehandlertest

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity()
{
    //val filename = "onlinedata.txt"
    val filename = "testfile.txt"
    val content = "Dette er en seriøs test!\n"

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fh = fileHandler()
        fh.setDataFile(filename, content, applicationContext)

        fh.appendDataFile(filename, "Dette er en lille test!\n", applicationContext)

        val ret_val : String = fh.getDataFile(filename, applicationContext)
        txtView.setText(ret_val)
    }

    fun writeFile(file_name : String, file_content : String)
    {
        val file = File(Environment.getExternalStorageDirectory(), file_name)
        val fos : FileOutputStream = openFileOutput(file_name, Context.MODE_PRIVATE)
        fos.write(content.toByteArray())
        fos.close()

        Toast.makeText(this, "File saved!", Toast.LENGTH_LONG).show()
    }

    fun readFile(file_name : String) : String
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