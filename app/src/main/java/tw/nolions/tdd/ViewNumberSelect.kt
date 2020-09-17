package tw.nolions.tdd

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.view_number_select.view.*

class ViewNumberSelect : LinearLayout {

//    private lateinit var addButton: Button
//    private lateinit var minusButton: Button
//    private lateinit var valueTextView: TextView

    //最小值
    private var minValue: Int = 0

    //最大值
    private var maxValue: Int = 0

    //預設值
    private var defaultValue: Int = 0

    //目前數值
    var textValue: Int = 0

    private var listener: NumberSelectListener? = null

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        View.inflate(context, R.layout.view_number_select, this)
        descendantFocusability = ViewGroup.FOCUS_BLOCK_DESCENDANTS

        textValue = 0
        maxValue = Integer.MAX_VALUE
        minValue = 0

        if (attrs != null) {
            val attributes =
                context.theme.obtainStyledAttributes(attrs, R.styleable.NumberSelect, 0, 0)

            maxValue = attributes.getInt(R.styleable.NumberSelect_max_value, this.maxValue)
            minValue = attributes.getInt(R.styleable.NumberSelect_min_value, this.minValue)
            defaultValue = attributes.getInt(R.styleable.NumberSelect_default_value, 0)

            valueTextView.text = defaultValue.toString()
            textValue = defaultValue
        }

        addButton.setOnClickListener {
            addTextValue()
            if (listener != null) {
                listener!!.onValueChange(textValue)
            }
        }

        minusButton.setOnClickListener {
            minusTextValue()
            if (listener != null) {
                listener!!.onValueChange(textValue)
            }
        }
    }

    fun setMaxValue(value: Int) {
        this.maxValue = value
    }

    fun setMinValue(value: Int) {
        this.minValue = value
    }

    fun setDefaultValue(value: Int) {
        this.defaultValue = value
        this.textValue = value
    }

    private fun addTextValue() {
        if (this.textValue < this.maxValue) {
            this.textValue++
            this.valueTextView.text = this.textValue.toString()
        }
    }

    private fun minusTextValue() {
        if (this.textValue > this.minValue) {
            this.textValue--
            this.valueTextView.text = this.textValue.toString()
        }
    }

    fun setListener(listener: NumberSelectListener) {
        this.listener = listener
    }

    interface NumberSelectListener {
        fun onValueChange(value: Int)
    }
}