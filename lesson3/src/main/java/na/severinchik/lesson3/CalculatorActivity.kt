package na.severinchik.lesson3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView

class CalculatorActivity : AppCompatActivity() {

    lateinit var inputField: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        inputField = findViewById(R.id.ac_input_field)
        inputField.setOnClickListener { TODO("Not yet implemented") }
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.ac_one -> inputField.text = "${inputField.text}1"
            R.id.ac_two -> inputField.text = "${inputField.text}2"
            R.id.ac_three -> inputField.text = "${inputField.text}3"
            R.id.ac_four -> inputField.text = "${inputField.text}4"
            R.id.ac_five -> inputField.text = "${inputField.text}5"
            R.id.ac_six -> inputField.text = "${inputField.text}6"
            R.id.ac_seven -> inputField.text = "${inputField.text}7"
            R.id.ac_eight -> inputField.text = "${inputField.text}8"
            R.id.ac_nine -> inputField.text = "${inputField.text}9"
        }
    }
}


///snippet sealed class

sealed class ResultWrapper<out T> {
    object Loading : ResultWrapper<Unit>()
    data class Success<T>(val data: T) : ResultWrapper<T>()
    data class Error(val code: Int) : ResultWrapper<Unit>()
    object None : ResultWrapper<Unit>()
}

//fun main() {
//    var result: ResultWrapper<String> = ResultWrapper.Success("")
//
////    when(val temporary=result){
////        is ResultWrapper.Error -> println("Throw exception ${temporary.code}")
////        ResultWrapper.Loading -> println("Display loading screen")
////        ResultWrapper.None -> Unit
////        is ResultWrapper.Success -> println("Parsing data ${temporary.data}")
////    }
//}
//
//object DB {
//    fun createInstance() {}
//}
//
//interface Validation{
//    fun isValidate()
//}

//class BaseValidation():Validation{
//    override fun isValidate() {
//        TODO("Not yet implemented")
//    }
//}
//
//interface Log{
//    fun printLog()
//}
//
//class LocalLog():Log{
//    override fun printLog() {
//        TODO("Not yet implemented")
//    }
//
//}
//
//class RemoteLog():Log{
//    override fun printLog() {
//        TODO("Not yet implemented")
//    }
//
//}
//
//class Manager(log:Log,validation: Validation):Log by log,Validation by validation{

//}
