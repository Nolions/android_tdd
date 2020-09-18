package tw.nolions.tdd

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var num = 0
    val text: MutableLiveData<String> = MutableLiveData("0")

    fun onPlusClick() {
        num++
        text.value = num.toString()
    }

    fun onMinusClick() {
        num--
        text.value = num.toString()
    }
}