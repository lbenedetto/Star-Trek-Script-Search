package com.lbenedetto.stss.customview

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.lbenedetto.stss.R
import kotlinx.android.synthetic.main.search_input_view.view.*

class SearchInputView : ConstraintLayout {
    private val searchFields = ArrayList<View>()
    private lateinit var hint: String

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initView(
            context, context.obtainStyledAttributes(
                attrs,
                R.styleable.SearchInputView,
                0, 0
            )
        )
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView(
            context, context.obtainStyledAttributes(
                attrs,
                R.styleable.SearchInputView,
                defStyleAttr, 0
            )
        )
    }

    private fun initView(context: Context, a: TypedArray) {
        View.inflate(context, R.layout.search_input_view, this)

        try {

            separator.visibility =
                if (a.getBoolean(R.styleable.SearchInputView_separator, true)) View.VISIBLE else View.GONE
            tvLabel.text = a.getString(R.styleable.SearchInputView_label)
            hint = a.getString(R.styleable.SearchInputView_hint)!!
            llFields.findViewById<EditText>(R.id.searchField).hint = hint
        } finally {
            a.recycle()
        }

        llFields.findViewById<ImageView>(R.id.ivFieldAction).setOnClickListener(this::actionAddField)

    }

    private fun actionAddField(clickedView: View) {
        val newView = LayoutInflater.from(clickedView.context).inflate(R.layout.search_field, null)
        val newSearchField = newView.findViewById<EditText>(R.id.searchField)
        val newActionBtn = newView.findViewById<ImageView>(R.id.ivFieldAction)

        newSearchField.hint = hint

        clickedView.setBackgroundResource(R.drawable.ic_remove_circle_white_24dp)
        clickedView.setOnClickListener(this::actionRemoveField)
        newActionBtn.setOnClickListener(this::actionAddField)

        searchFields.add(newView)
        llFields.addView(newView, llFields.childCount)
    }

    private fun actionRemoveField(btnAction: View) {
        val ix = llFields.indexOfChild(btnAction.parent as View)
        searchFields.removeAt(ix)
        llFields.removeViewAt(ix)
    }

    fun getInputs(): List<String> {
        return searchFields
            .map { it.findViewById<EditText>(R.id.searchField).text.toString() }
            .filter { it.isNotBlank() }
    }

}
