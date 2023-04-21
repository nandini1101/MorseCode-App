package com.example.morsecode

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Assign variables
        var etInput = findViewById<EditText>(R.id.etInput)
        var etOutput = findViewById<EditText>(R.id.etOutput)
        var btnDecode = findViewById<Button>(R.id.btndecode)
        var btnEncode = findViewById<Button>(R.id.btnEncode)
        var btnClear = findViewById<Button>(R.id.btnClear)

        // initializing string arrays
        val alphaNumeric = arrayOfNulls<String>(37)

        // string array for storing alphabets and numbers
        val alphaNumeric1 = arrayOfNulls<String>(37)

        // string array for storing corresponding morse code
        // assigning alphabets to the string array Alphanumeric[]
        alphaNumeric[0] = "A"
        alphaNumeric[1] = "B"
        alphaNumeric[2] = "C"
        alphaNumeric[3] = "D"
        alphaNumeric[4] = "E"
        alphaNumeric[5] = "F"
        alphaNumeric[6] = "G"
        alphaNumeric[7] = "H"
        alphaNumeric[8] = "I"
        alphaNumeric[9] = "J"
        alphaNumeric[10] = "K"
        alphaNumeric[11] = "L"
        alphaNumeric[12] = "M"
        alphaNumeric[13] = "N"
        alphaNumeric[14] = "O"
        alphaNumeric[15] = "P"
        alphaNumeric[16] = "Q"
        alphaNumeric[17] = "R"
        alphaNumeric[18] = "S"
        alphaNumeric[19] = "T"
        alphaNumeric[20] = "U"
        alphaNumeric[21] = "V"
        alphaNumeric[22] = "W"
        alphaNumeric[23] = "X"
        alphaNumeric[24] = "Y"
        alphaNumeric[25] = "Z"
        alphaNumeric[26] = "0"
        alphaNumeric[27] = "1"
        alphaNumeric[28] = "2"
        alphaNumeric[29] = "3"
        alphaNumeric[30] = "4"
        alphaNumeric[31] = "5"
        alphaNumeric[32] = "6"
        alphaNumeric[33] = "7"
        alphaNumeric[34] = "8"
        alphaNumeric[35] = "9"
        alphaNumeric[36] = " "

        // assigning the corresponding morse code
        // for each letter and number to
        // Alphanumeric1[] array
        alphaNumeric1[0] = ".-"
        alphaNumeric1[1] = "-..."
        alphaNumeric1[2] = "-.-."
        alphaNumeric1[3] = "-.."
        alphaNumeric1[4] = "."
        alphaNumeric1[5] = "..-."
        alphaNumeric1[6] = "--."
        alphaNumeric1[7] = "...."
        alphaNumeric1[8] = ".."
        alphaNumeric1[9] = ".---"
        alphaNumeric1[10] = "-.-"
        alphaNumeric1[11] = ".-.."
        alphaNumeric1[12] = "--"
        alphaNumeric1[13] = "-."
        alphaNumeric1[14] = "---"
        alphaNumeric1[15] = ".--."
        alphaNumeric1[16] = "--.-"
        alphaNumeric1[17]= ".-."
        alphaNumeric1[18] = "..."
        alphaNumeric1[19] = "-"
        alphaNumeric1[20] = "..-"
        alphaNumeric1[21] = "...-"
        alphaNumeric1[22] = ".--"
        alphaNumeric1[23] = "-..-"
        alphaNumeric1[24] = "-.--"
        alphaNumeric1[25] = "--.."
        alphaNumeric1[26] = "-----"
        alphaNumeric1[27] = ".----"
        alphaNumeric1[28] = "..---"
        alphaNumeric1[29] = "...--"
        alphaNumeric1[30] = "....-"
        alphaNumeric1[31] = "....."
        alphaNumeric1[32] = "-...."
        alphaNumeric1[33] = "--..."
        alphaNumeric1[34] = "---.."
        alphaNumeric1[35] = "----."
        alphaNumeric1[36] = "/"
        btnEncode.setOnClickListener(View.OnClickListener { // When button encode is clicked then the
            // following lines inside this curly
            // braces will be executed

            // to get the input as string which the user wants to encode
            val input = etInput.getText().toString()
            var output = ""

            // variable used to compute the output
            // to get the length of the input string
            val l = input.length

            // variables used in loops
            var i: Int
            var j: Int
            i = 0
            while (i < l) {


                // to extract each Token of the string at a time
                val ch = input.substring(i, i + 1)

                // the loop to check the extracted token with
                // each letter and store the morse code in
                // the output variable accordingly
                j = 0
                while (j < 37) {
                    if (ch.equals(alphaNumeric[j], ignoreCase = true)) {

                        // concat space is used to separate
                        // the morse code of each token
                        output = output + alphaNumeric1[j] + " "
                    }
                    j++
                }
                i++
            }

            // to display the output
            etOutput.setText(output)
        })
        btnClear.setOnClickListener(View.OnClickListener { // When button clear is clicked then the
            // following lines inside this curly
            // braces will be executed

            // to clear the etinput
            etInput.setText("")

            // to clear etoutput
            etOutput.setText("")
        })
        btnDecode.setOnClickListener(View.OnClickListener { // When button decode is clicked then the
            // following lines inside this curly
            // braces will be executed

            // to get the input given by the user as string
            val input1 = etInput.getText().toString()

            // to add space to the end of the string
            // because of the logic used in decoding
            val input = "$input1 "

            // to get the length of the input string
            val l = input.length

            // i and j are integer variables used in loops.
            // Variable p is used as the end index of
            // substring() function
            var i: Int
            var j: Int
            var p = 0

            // variable used as a starting
            // index of substring() function
            var pos = 0

            // to store the extracted morse code
            // for each Alphabet,number or space
            var letter = ""

            // a to store the output in it
            var output = ""
            i = 0
            while (i < l) {


                // a variable used to trigger the j loop only
                // when the complete morse code of a letter
                // or number is extracted
                var flag = 0

                // to extract each token at a time
                val ch = input.substring(i, i + 1)

                // if the extracted token is a space
                if (ch.equals(" ", ignoreCase = true)) {

                    // to store the value of i in p
                    p = i

                    // to extract the morse code for each letter or number
                    letter = input.substring(pos, p)

                    // to update the value of pos so that next
                    // time the morse code for the next letter
                    // or digit is extracted
                    pos = p + 1
                    flag = 1
                }
                val letter1 = letter.trim { it <= ' ' }
                // to delete extra whitespaces at
                // both ends in case there are any
                if (flag == 1) {
                    j = 0
                    while (j <= 36) {
                        if (letter1.equals(alphaNumeric1[j], ignoreCase = true)) {
                            output = output + alphaNumeric[j]
                            break
                        }
                        j++
                    }
                }
                i++
            }
            // to display the output
            etOutput.setText(output)
        })
    }
}